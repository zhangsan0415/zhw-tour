package com.zhw.service.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zhw.domain.MemberScoreChangeInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.mapper.MemberScoreChangeMapper;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;
import com.zhw.service.ManagerService;
import com.zhw.type.IfWithdrawEnum;
@Service
public class ManagerServiceImpl implements ManagerService {

	@Resource
	private MemberScoreChangeMapper infoMapper;
	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;
	
	@Override
	public PageResult queryWithdraw(String hyCode,String txStatus,int currentPage) throws Exception{
		int count = infoMapper.selectCount(hyCode, 0);//查询积分提现总数0
		if (count == 0)return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<MemberScoreChangeInfo> list =infoMapper.queryScoreByAdmin(hyCode, 0, txStatus, null, start, PageResult.pageSize);
		//设置转账类型
		list.forEach(obj->{
			obj.setZzType(IfWithdrawEnum.getNameByCode(obj.getZzType()));
			obj.setTxStatus(IfWithdrawEnum.getNameByCode(obj.getTxStatus()));
			obj.setRealMoney(obj.getZzMoney().multiply(new BigDecimal(0.95)));//这个待定，可能是先扣5%的管理费，再扣8%的所得税
		});
		return PageResult.getPageInstance(list, currentPage, count);
	}

	@Override
	public BaseResult delWithdraw(String pkId) throws Exception{
		return infoMapper.delScoreByAnmin(pkId)== 0
				?BaseResult.exceptionInstance():BaseResult.sucessInstance().setMsg("删除成功！");

	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public BaseResult confirmWithdraw(String pkId) throws Exception{
		//提现审核确认
		int num = infoMapper.conWithdrawByAnmin(pkId);
		if(num==0)return BaseResult.exceptionInstance();
		//确认成功以后，更新数据
		//根据主键查询积分提现信息
		MemberScoreChangeInfo scoreInfo = infoMapper.queryInfo(pkId);
		//查询积分明细
		MemberScoreInfo info = scoreInfoMapper.selectScoreInfoByCode(scoreInfo.getHyCode());
		if (scoreInfo.getZzType().equals("1016")) {
			//提取奖金积分
			info.setJjScore(info.getJjScore().subtract(scoreInfo.getZzMoney()));
			scoreInfoMapper.updateScoreInfo(info);
		}else if(scoreInfo.getZzType().equals("1017")){
			//提取旅游积分
			info.setLyScore(info.getLyScore().subtract(scoreInfo.getZzMoney()));
			scoreInfoMapper.updateScoreInfo(info);
		}
		return BaseResult.sucessInstance().setMsg("积分提现审核成功！");
	}

	@Override
	public PageResult queryRecharge(String hyCode, String czStatus,
			int currentPage) throws Exception {
		int count = infoMapper.selectCount(hyCode, 2);//查询积分充值总数2
		if (count == 0)return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<MemberScoreChangeInfo> list =infoMapper.queryScoreByAdmin(hyCode, 2, czStatus, null, start, PageResult.pageSize);
		//设置转账类型
		list.forEach(obj->{
			obj.setZzType(IfWithdrawEnum.getNameByCode(obj.getZzType()));
			obj.setCzStatus(IfWithdrawEnum.getNameByCode(obj.getCzStatus()));
		});
		return PageResult.getPageInstance(list, currentPage, count);
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public BaseResult confirmRecharge(String pkId) throws Exception {
		int num = infoMapper.conRechargeByAnmin(pkId);
		if(num == 0)return BaseResult.exceptionInstance();
		//确认成功以后，更新数据
		//根据主键查询积分充值信息
		MemberScoreChangeInfo scoreInfo = infoMapper.queryInfo(pkId);
		//查询积分明细
		MemberScoreInfo info = scoreInfoMapper.selectScoreInfoByCode(scoreInfo.getHyCode());
		if (scoreInfo.getZzType().equals("1018")) {
			//充值报单积分
			info.setBdScore(info.getBdScore().add(scoreInfo.getZzMoney()));
			scoreInfoMapper.updateScoreInfo(info);
		}else if(scoreInfo.getZzType().equals("1019")){
			//充值现金积分
			info.setXjScore(info.getXjScore().add(scoreInfo.getZzMoney()));
			scoreInfoMapper.updateScoreInfo(info);
		}
		return BaseResult.sucessInstance().setMsg("积分充值审核成功！");
	}

}

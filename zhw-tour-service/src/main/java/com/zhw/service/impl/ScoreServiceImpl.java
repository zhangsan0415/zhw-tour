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
import com.zhw.response.PageResult;
import com.zhw.service.ScoreService;
import com.zhw.type.IfWithdrawEnum;
import com.zhw.type.ZZTypeEnum;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;
	
	@Resource
	private MemberScoreChangeMapper changeMapper;
	
	@Override
	public PageResult queryInfo(String hyCode,int status,int currentPage){
		// TODO Auto-generated method stub
		int count = changeMapper.selectCount(hyCode, status);
		if (count == 0)return 	PageResult.getOkInstance();
		int start = PageResult.getStartNumber(currentPage);
		List<MemberScoreChangeInfo> list = changeMapper.queryInfoByHycode(hyCode,status,start,PageResult.pageSize);
		if(list.size()==0|| list==null)return null;
		//设置转账类型
		list.forEach(obj->{
			if(obj.getTxStatus()!=null){
				obj.setZzType(IfWithdrawEnum.getNameByCode(obj.getZzType()));
				obj.setTxStatus(IfWithdrawEnum.getNameByCode(obj.getTxStatus()));
				obj.setRealMoney(obj.getZzMoney().multiply(new BigDecimal(0.95)));
			}else{	obj.setZzType(ZZTypeEnum.getNameByCode(obj.getZzType()));}
		});
		return PageResult.getPageInstance(list, currentPage, count);
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public MemberScoreInfo zzScore(MemberScoreInfo info,MemberScoreChangeInfo scoreInfo)throws Exception {
		BigDecimal money = scoreInfo.getZzMoney();//转账金额
		BigDecimal bdScore = info.getBdScore();//报单积分
		BigDecimal jjScore = info.getJjScore();//奖金积分
		BigDecimal lyScore = info.getLyScore();//旅游积分
		switch (scoreInfo.getZzType()) {
		case "1010"://报单积分转给其他会员
			//金额大于报单积分时，直接返回
			if (money.compareTo(bdScore)==1) {
				info.setType("0");
				return info;
			}
			//借方报单积分减少，贷方报单积分增加
			info.setBdScore(bdScore.subtract(money));
			//更新借方积分信息
			scoreInfoMapper.updateScoreInfo(info);
			//查询贷方信息
			MemberScoreInfo score = scoreInfoMapper.selectScoreInfoByCode(scoreInfo.getDfCode());
			if(score == null) {	
				info.setType("1");
				return info;
			}
			score.setBdScore(money.add(score.getBdScore()));
			//更新贷方积分信息
			scoreInfoMapper.updateScoreInfo(score);
			break;
		case "1011"://奖金积分 转 报单积分
			if (money.compareTo(jjScore)==1) {
				info.setType("0");
				return info;
			}
			info.setJjScore(jjScore.subtract(money));
			info.setBdScore(money.add(info.getBdScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1012"://奖金积分 转 现金积分
			if (money.compareTo(jjScore)==1) {
				info.setType("0");
				return info;
			}
			info.setJjScore(jjScore.subtract(money));
			info.setXjScore(money.add(info.getXjScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1013"://奖金积分 转 购物积分
			if (money.compareTo(jjScore)==1) {
				info.setType("0");
				return info;
			}
			info.setJjScore(jjScore.subtract(money));
			info.setGwScore(money.add(info.getGwScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1014"://旅游积分 转 报单积分
			if (money.compareTo(lyScore)==1) {
				info.setType("0");
				return info;
			}
			info.setJjScore(lyScore.subtract(money));
			info.setBdScore(money.add(info.getBdScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1015"://旅游积分 转 现金积分
			if (money.compareTo(lyScore)==1) {
				info.setType("0");
				return info;
			}
			info.setJjScore(lyScore.subtract(money));
			info.setXjScore(money.add(info.getXjScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		default:
			break;
		}
		//插入积分日志
		changeMapper.insertScoreInfo(scoreInfo);
		return scoreInfoMapper.selectScoreInfoByhyCode(info.getHyCode());
	}


	@Override
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public MemberScoreInfo withdrawScore(MemberScoreInfo info,
			MemberScoreChangeInfo scoreInfo) throws Exception {
		
		scoreInfo.setDfCode(info.getHyCode());
		scoreInfo.setTxStatus("0");//未确认
		if (scoreInfo.getZzType().equals("1016")) {
			//提取奖金积分
			if (scoreInfo.getZzMoney().compareTo(info.getLyScore())==1) {
				info.setType("0");
				return info;
			}
			info.setJjScore(info.getJjScore().subtract(scoreInfo.getZzMoney()));
			scoreInfoMapper.updateScoreInfo(info);
		}else if(scoreInfo.getZzType().equals("1017")){
			//提取旅游积分
			if (scoreInfo.getZzMoney().compareTo(info.getLyScore())==1) {
				info.setType("0");
				return info;
			}
			info.setLyScore(info.getLyScore().subtract(scoreInfo.getZzMoney()));
			scoreInfoMapper.updateScoreInfo(info);
		}
		//插入积分日志
		changeMapper.insertScoreInfo(scoreInfo);
		return scoreInfoMapper.selectScoreInfoByhyCode(info.getHyCode());
	}

	
}

package com.zhw.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zhw.domain.MemberScoreChangeInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.response.BaseResult;
import com.zhw.service.ScoreService;
import com.zhw.type.JHStatusEnum;
import com.zhw.utils.StringUtils;

/**
 * 积分操作类
 * @author admin
 *
 */
@Controller
@RequestMapping(value="/score")
public class ScoreController {

	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private ScoreService scoreService;
	/**
	 * 转账按钮
	 * @param hyCode 借方会员编号
	 * @param dfCode 贷方会员编号
	 * @param type  转账类型
	 * @param money 金额
	 * @return
	 */
	@RequestMapping(value="/zzScore.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult traferScore(String zzType,String dfCode,BigDecimal zzMoney,HttpServletRequest request){
		try {
		   if(zzMoney.compareTo(BigDecimal.ZERO)!=1)return BaseResult.failedInstance("充值金额有误，请重新填写！");
			//验证参数
			BaseResult result =checkParams(dfCode,zzType,zzMoney);
			if (result.isFailed()) {
				return BaseResult.conditionErrorInstance();
			}
			MemberScoreInfo info = ControllerUtils.getScoreInfo(request);
			MemberScoreChangeInfo scoreInfo = new MemberScoreChangeInfo();
			if(!dfCode.equals("")&&dfCode!=null)
			{
				scoreInfo.setDfCode(dfCode);
			}else{
				scoreInfo.setDfCode(info.getHyCode());//积分之间的互转，贷方直接是当前登录人
			}
			scoreInfo.setZzType(zzType);
			scoreInfo.setZzMoney(zzMoney);
			scoreInfo.setHyCode(info.getHyCode());
			scoreInfo.setZzStatus(1);//操作状态，积分互转
			MemberScoreInfo scoreInfos =scoreService.zzScore(info,scoreInfo);
			if(scoreInfos.getType()!=null&&!scoreInfos.getType().equals("")){
				if(scoreInfos.getType().equals("0")) return BaseResult.failedInstance("互转金额有误，请重新填写！");
				if (scoreInfos.getType().equals("1")) return BaseResult.failedInstance("互转会员不存在，请重新填写！");
			}
			//成功后，设置session信息
			ControllerUtils.setScoreInfo(request, scoreInfos);
			return BaseResult.sucessInstance().setMsg("操作成功！") ;
		} catch (Exception e) {
			logger.error("积分互转失败"+e);
			return BaseResult.exceptionInstance();
		}
		
	}
	
/*
	 * 积分提现
	 * @param type 提现类型
	 * @param money 提现金额
	 * @return
	 */
	@RequestMapping(value="/withdrawScore",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult withdrawScore(String zzType,BigDecimal zzMoney,HttpServletRequest request){
		try {
			if(zzMoney.compareTo(BigDecimal.ZERO)!=1)return BaseResult.failedInstance("提现金额有误，请重新填写！");
			if(StringUtils.isEmpty(zzType)|| zzMoney == null)return BaseResult.conditionErrorInstance();
			//验证提现金额是100的倍数
			if (zzMoney.divideAndRemainder(new BigDecimal(100))[1].compareTo(new BigDecimal(0))!=0) {
				return BaseResult.failedInstance("提取金额必须是100的倍数！");
			}
			MemberScoreInfo info = ControllerUtils.getScoreInfo(request);
			MemberScoreChangeInfo scoreInfo = new MemberScoreChangeInfo();
			scoreInfo.setZzType(zzType);
			scoreInfo.setZzMoney(zzMoney);
			scoreInfo.setHyCode(info.getHyCode());
			scoreInfo.setZzStatus(0);
			MemberScoreInfo scoreInfos = scoreService.withdrawScore(info,scoreInfo);
			if(scoreInfos.getType()!=null&&!scoreInfos.getType().equals("")){
				if(scoreInfos.getType().equals("0")) return BaseResult.failedInstance("提现金额有误，请重新填写！");
			}
			//成功后，设置seesion信息
			//ControllerUtils.setScoreInfo(request, scoreInfos);
			return BaseResult.sucessInstance().setMsg("操作成功！") ;
		} catch (Exception e) {
			logger.error("积分提现失败"+e);
			return BaseResult.exceptionInstance();
		}
		
	
	}
	/*
	 * 积分充值
	 * @param type 充值类型
	 * @param money 金额
	 * @return
	 */
	@RequestMapping(value="/rechargeScore",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult rechargeScore(String zzType,BigDecimal zzMoney,HttpServletRequest request){
		try {
			if(StringUtils.isEmpty(zzType)|| zzMoney == null)return BaseResult.conditionErrorInstance();
			//验证充值金额大于0
			if(zzMoney.compareTo(BigDecimal.ZERO)!=1)return BaseResult.failedInstance("充值金额有误，请重新填写！");
			MemberScoreInfo info = ControllerUtils.getScoreInfo(request);
			MemberScoreChangeInfo scoreInfo = new MemberScoreChangeInfo();
			scoreInfo.setZzType(zzType);
			scoreInfo.setZzMoney(zzMoney);
			scoreInfo.setHyCode(info.getHyCode());
			scoreInfo.setZzStatus(2);
			MemberScoreInfo scoreInfos = scoreService.rechargeScore(info,scoreInfo);
			//成功后，设置seesion信息
			ControllerUtils.setScoreInfo(request, scoreInfos);
			return BaseResult.sucessInstance().setMsg("操作成功！") ;
		} catch (Exception e) {
			logger.error("积分提现失败"+e);
			return BaseResult.exceptionInstance();
		}
		
	
	}
	//积分提现记录
	@RequestMapping(value="/getScoreWithdraw.do")
	@ResponseBody
	public BaseResult toScoreWithdraw(int currentPage,HttpServletRequest request) {
		try {
			String hyCode = ControllerUtils.getUserInfo(request).getHyCode();
			int status = JHStatusEnum.ACTIVED.getTypeCode();
			return scoreService.queryInfo(hyCode,status,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取积分提现记录列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
		
	}
	
	//积分互换记录
	@RequestMapping(value="/getChangeScore.do")
	@ResponseBody
	public BaseResult changeScore(int currentPage,HttpServletRequest request) {
		try {
			String hyCode = ControllerUtils.getUserInfo(request).getHyCode();
			int status = JHStatusEnum.UNACTIVED.getTypeCode();
			return scoreService.queryInfo(hyCode,status,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取积分提现记录列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
		
	}
	
	//积分充值记录
	@RequestMapping(value="/getScoreRecharge.do")
	@ResponseBody
	public BaseResult toScoreRecharge(int currentPage,HttpServletRequest request) {
		try {
			String hyCode = ControllerUtils.getUserInfo(request).getHyCode();
			int status = JHStatusEnum.RECHARGE.getTypeCode();
			return scoreService.queryInfo(hyCode,status,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取积分提现记录列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
		
	}
		
	private BaseResult checkParams(String dfCode, String type, BigDecimal money) {
		if(!StringUtils.isEmpty(type)){
			if("1010".equals(type)){
				if(StringUtils.isEmpty(dfCode)|| money ==null){
					return BaseResult.conditionErrorInstance();
				}else{return BaseResult.sucessInstance();}
			}else{
				if(StringUtils.isEmpty(dfCode)&& money !=null)return BaseResult.sucessInstance();
				else{
					return BaseResult.conditionErrorInstance();
				}
			}
		}
		return BaseResult.conditionErrorInstance();
	}

}

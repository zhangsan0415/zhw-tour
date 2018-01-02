package com.zhw.controller;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zhw.domain.MemberScoreInfo;
import com.zhw.response.BaseResult;
import com.zhw.service.ScoreService;
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
	public BaseResult traferScore(String dfCode,String type,BigDecimal money,HttpServletRequest request){
		try {
			String hyCode = ControllerUtils.getUserInfo(request).getHyCode();//当前登录人为贷方
			//验证参数
			BaseResult result =checkParams(dfCode,type,money);
			if (result.isFailed()) {
				return BaseResult.conditionErrorInstance();
			}
			MemberScoreInfo info = ControllerUtils.getScoreInfo(request);
			info.setDfCode(dfCode);
			info.setZzType(type);
			info.setZzMoney(money);
			MemberScoreInfo scoreInfo =scoreService.zzScore(info);
			if(scoreInfo == null) return BaseResult.exceptionInstance();
			//成功后，设置seesion信息
//			info.setBdScore(scoreInfo.getBdScore());
//			info.setXjScore(scoreInfo.getXjScore());
//			info.setGwScore(scoreInfo.getGwScore());
//			info.setJjScore(scoreInfo.getJjScore());
//			info.setLyScore(scoreInfo.getLyScore());
			ControllerUtils.setScoreInfo(request, scoreInfo);
			return BaseResult.sucessInstance().setMsg("操作成功！") ;
		} catch (Exception e) {
			logger.error("积分互转失败"+e);
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

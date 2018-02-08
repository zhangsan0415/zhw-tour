package com.zhw.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zhw.domain.BdApply;
import com.zhw.response.BaseResult;
import com.zhw.service.BdApplyService;
import com.zhw.utils.StringUtils;

@RestController
@RequestMapping("/bdapply")
public class BdApplyController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BdApplyService bdService;
	
	@RequestMapping("/apply.do")
	public BaseResult apply(BdApply obj) {
		try {
			return bdService.addBdApply(obj);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("申请报单中心异常：",obj.getHyCode()));
			return BaseResult.exceptionInstance();
		}
	}

}

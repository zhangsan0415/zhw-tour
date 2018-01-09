package com.zhw.service;

import com.zhw.response.BaseResult;
import com.zhw.response.PageResult;

public interface ManagerService {

	//查询积分提现待审核信息
	PageResult queryWithdraw(String hyCode,String txStatus,int currentPage)throws Exception;
	//删除积分提现、充值信息
	BaseResult delWithdraw(String pkId)throws Exception;
	//确认积分提现审核信息
	BaseResult confirmWithdraw(String pkId)throws Exception;
	
	//查询积分充值待审核信息
	PageResult queryRecharge(String hyCode,String czStatus,int currentPage)throws Exception;
	//确认积分充值审核信息
	BaseResult confirmRecharge(String pkId)throws Exception;
	
	
}

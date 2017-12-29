package com.zhw.service;



public interface PersonService {
/**
 * 修改资料
 * @return
 */
	 int modifyInfo(String hyCode,String khBankName,String khCardCode,String khName,String khProvince,
				String khCity,String sfzCardCode,String yxEmail,String sjMobile)throws Exception;
	
	 /**
	  * 修改密码
	  * @return
	  */
	 int modifyPwd(String hyCode,String yjPwd,String ejPwd)throws Exception;
}

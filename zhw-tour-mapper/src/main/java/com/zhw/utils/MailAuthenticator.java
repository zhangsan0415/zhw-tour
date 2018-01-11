package com.zhw.utils;



import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator{

	private String userName;//邮箱
	private String password;//密码
	

	//重写Authenticator方法
	@Override
	protected PasswordAuthentication getPasswordAuthentication(){
		return new PasswordAuthentication(userName, password);
	}
	
	public MailAuthenticator(){}
	
	public MailAuthenticator(String userName,String password){
		this.userName = userName;
		this.password = password;
	}
	
	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}


}

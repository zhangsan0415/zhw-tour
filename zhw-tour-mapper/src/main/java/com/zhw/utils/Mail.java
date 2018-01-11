package com.zhw.utils;

public class Mail {

	private String subject;//主题
	private String content;//内容
	
	public Mail(){}
	
	public Mail(String subject,String content){
		this.subject = subject;
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}

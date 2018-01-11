package com.zhw.utils;

import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.internet.MimeMessage.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.sun.mail.util.MailSSLSocketFactory;

public class MailSender {

	//发送邮箱的properties文件
	private final transient Properties props = System.getProperties();
	//服务器邮箱登录验证
	private transient MailAuthenticator mailAuthenticator;
	//邮箱session
	private transient Session session;
	   /**
     * 初始化邮箱发送器
     * 
     * @param mailServiceUrl
     *          服务器邮箱地址
     * @param username
     *          服务器邮箱用户名
     * @param password
     *          服务器邮箱登录密码
     */
    public MailSender(final String mailServiceUrl,final String username, final String password){
        init(mailServiceUrl, username, password);
    }
    /**
     * 初始化邮箱发送器
     * 
     * @param username
     *          服务器邮箱用户名
     * @param password
     *          服务器邮箱登录密码
     */
    public MailSender(final String username, final String password){
        //通过邮箱地址解析smtp服务器，对大多数邮箱都管用
        final String mailServiceUrl = "smtp." + username.split("@")[1]; 
        init(mailServiceUrl, username, password);
    }
	public  void init(String mailServiceUrl, String username, String password) {
		
		try {
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			//初始化props
			  props.put("mail.smtp.auth", "true");
			  props.put("mail.smtp.ssl.enable", "true");
			  props.put("mail.smtp.ssl.socketFactory", sf);
		      props.put("mail.smtp.host", mailServiceUrl);
			//服务器邮箱验证
			mailAuthenticator = new MailAuthenticator(username, password);
			
			session = Session.getInstance(props,mailAuthenticator);
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  /**
     * 发送邮件
     * 
     * @param recipient
     *          收信人邮箱地址
     * @param subject
     *          邮件标题
     * @param content
     *          邮件内容
     * @throws AddressException
     * @throws MessagingException
     */
	 public void send(String recipient, String subject, String content) throws AddressException, MessagingException{
		
		 final MimeMessage msg = new MimeMessage(session);
		 
	       //设置发信人
	        msg.setFrom(new InternetAddress(mailAuthenticator.getUserName()));
	        //设置收信人
	        msg.setRecipient(RecipientType.TO, new InternetAddress(recipient));
	        //设置邮件标题
	        msg.setSubject(subject);
	        //设置邮件内容
	        msg.setContent(content, "text/html;charset=utf-8");
	        //发送邮件
	        Transport.send(msg);
	}
	 /**
	     * 发送邮件
	     * 
	     * @param recipient
	     *          收信人邮箱地址
	     * @param mail
	     *          邮件对象
	     * @throws AddressException
	     * @throws MessagingException
	     * @throws
	     */
	    public void send(String recipient, Mail mail) throws AddressException, MessagingException{
	        this.send(recipient, mail.getSubject(), mail.getContent());
	    }
	    
	    
	    
}

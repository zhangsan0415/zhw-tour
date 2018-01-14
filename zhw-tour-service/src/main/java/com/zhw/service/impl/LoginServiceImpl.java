package com.zhw.service.impl;

import java.io.InputStream;
import java.util.Properties;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.mapper.MemberInfoMapper;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.response.BaseResult;
import com.zhw.service.LoginService;
import com.zhw.type.HyLevelEnum;
import com.zhw.utils.Mail;
import com.zhw.utils.MailSender;

@Service
public class LoginServiceImpl implements LoginService{
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Resource
	private MemberInfoMapper userInfoMapper;
	
	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;
	
	@Override
	public MemberInfo checkLogin(String hyCode, String password) throws Exception {
		return userInfoMapper.selectForLogin(hyCode, password);
	}

	@Override
	public boolean isHyExsists(String hyCode) throws Exception {
		return userInfoMapper.selectCountByHyCode(hyCode) > 0;
	}

	@Override
	public MemberScoreInfo getScoreInfoByHyCode(String hyCode) throws Exception {
		MemberScoreInfo obj = scoreInfoMapper.selectScoreInfoByCode(hyCode);
		obj.setHyLevelName(HyLevelEnum.getNameByCode(obj.getHyLevel()));
		return obj;
	}

	@Override
	public BaseResult forgetPwd(String hyCode, String email) throws Exception {
		//查询信息
		MemberInfo info = userInfoMapper.selectHyInfoByCode(hyCode);
		if(info == null)return BaseResult.failedInstance("该会员不存在！");
		if(!info.getYxEmail().equals(email))return BaseResult.failedInstance("邮箱输入错误！");
		//发邮箱
		Properties pro = new Properties();
		InputStream in = LoginServiceImpl.class.getClassLoader().getResourceAsStream("mail.properties");
	//	FileInputStream in = new FileInputStream("mail.properties");
		pro.load(in);
		in.close();
		String userName = pro.getProperty("username");
		String password = pro.getProperty("password");
		//创建邮箱发送器
        MailSender mailSender = new MailSender(userName,password);
        //邮箱对象
        Mail mail = new Mail("找回密码","密码为"+info.getYjPwd());
        //收件人邮箱地址：这里填写收件的邮箱的地址即可
        String recipient = info.getYxEmail(); 
        try {
            mailSender.send(recipient, mail);
        } catch (AddressException e) {
       //     System.out.println("发信人邮箱路径不正确........");
            logger.error(hyCode+"邮箱不对"+e+e.getMessage());
            return BaseResult.failedInstance("发信人邮箱路径不正确!");
            
        } catch (MessagingException e) {
       //     System.out.println("邮件发送失败........");
            logger.error(hyCode+"邮箱发送失败"+e+e.getMessage());
            return BaseResult.failedInstance("邮件发送失败!");
        }
		return BaseResult.sucessInstance().setMsg("发送成功，请注意查看！");
	}
	
}

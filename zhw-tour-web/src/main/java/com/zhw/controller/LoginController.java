package com.zhw.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhw.domain.MemberInfo;
import com.zhw.domain.MemberScoreInfo;
import com.zhw.response.BaseResult;
import com.zhw.utils.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhw.service.LoginService;
import com.zhw.type.HyLevelEnum;
import com.zhw.type.IfBdCenterEnum;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/login")
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String CHECK_CODE_KEY = "CHECK_CODE";
	
	@Resource
	private LoginService loginService;
	
	@RequestMapping("/index.do")
	public String index() {
		return "login";
	}

	/**
	 * 登录操作
	 * @param memberCode
	 * @param password
     * @return
     */
	@RequestMapping(value="/doLogin.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult doLogin(String hyCode, String password, String checkCode, HttpServletRequest request){
		try {
			if(StringUtils.isEmpty(hyCode,password,checkCode)) return BaseResult.conditionErrorInstance();

			String valideCode = (String) request.getSession().getAttribute(CHECK_CODE_KEY);
			request.getSession().removeAttribute(CHECK_CODE_KEY);
			if(!StringUtils.isEqualIgnoreCase(valideCode,checkCode)) return BaseResult.failedInstance("验证码错误！");
			MemberInfo check = loginService.checkLogin(hyCode,password);
			if(check == null) return BaseResult.failedInstance("密码错误！");
			
			MemberScoreInfo scoreInfo = loginService.getScoreInfoByHyCode(check.getHyCode());
			scoreInfo.setHyLevelName(HyLevelEnum.getNameByCode(check.getHyLevel()));
			ControllerUtils.setScoreInfo(request,scoreInfo );
			
			//设置session信息
			check.setIfBdCenterName(IfBdCenterEnum.getNameByCode(check.getIfBdCenter()));
			ControllerUtils.setUserInfo(request, check);
			return BaseResult.sucessInstance().setMsg("登录成功！");
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",hyCode,"登录失败：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}

	/**
	 * 验证用户（会员编号）名是否存在
	 * @param memberCode
	 * @return
     */
	@RequestMapping("/checkHyCode.do")
	@ResponseBody
	public BaseResult checkMemberCode(String hyCode){
		if(StringUtils.isEmpty(hyCode))  return BaseResult.conditionErrorInstance();

		try {
			boolean check = loginService.isHyExsists(hyCode);
			if(!check)	return BaseResult.failedInstance("会员编码不存在！");
			return BaseResult.sucessInstance();
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",hyCode,"验证失败：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	
	/**
	 * 进入home页面
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/toHome.do")
	public String toHomePage(HttpServletRequest request) throws Exception {
		return "home";
	}
	
	@RequestMapping(value="/logout.do")
	public String logout(HttpServletRequest request) {
		ControllerUtils.removeUserInfo(request);
		return "login";
	}
	
	//生成四位随机验证码
	@RequestMapping(value="/createCheckCode.do")
	public void createCheckCode(HttpServletRequest request,HttpServletResponse response) throws IOException {
		
		//设置响应头，以便图像画出后快速返回客户端
		response.setContentType("image/jpeg");
		
		// 设置浏览器不要缓存此图片
		response.setHeader("Pragma", "No-cache");
		response.setHeader("Cache-Control", "no-cache");
		response.setDateHeader("Expires", 0);

		int width = 60,height = 20;
		//创建内存图像
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		//获取画笔
		Graphics g = image.getGraphics();
		g.setColor(new Color(0xDCDCDC));//画背景
		g.fillRect(0, 0, width, height);//画形状
		
		//随机产生120个干扰点
		for (int i = 0; i < 120; i++) {
			int x = (int) (Math.random() * width);
			int y = (int) (Math.random() * height);
			int red = (int) (Math.random() * 255);
			int green = (int) (Math.random() * 255);
			int blue = (int) (Math.random() * 255);
			g.setColor(new Color(red, green, blue));
			g.drawOval(x, y, 1, 0);
		}
		
		//设置字体YAN色字体
		g.setColor(Color.BLACK);
		g.setFont(new Font(null, Font.ITALIC|Font.BOLD,18));
		
		//获取随机验证码数字，同时放入session
		char[] rands = this.getChars(4);
		request.getSession().setAttribute(CHECK_CODE_KEY, String.valueOf(rands));
		
		// 在不同高度输出验证码的不同字符
		g.drawString("" + rands[0], 1, 17);
		g.drawString("" + rands[1], 16, 15);
		g.drawString("" + rands[2], 31, 18);
		g.drawString("" + rands[3], 46, 16);
		g.dispose();
		
		// 将图像传至客户端
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ImageIO.write(image, "JPEG", bos);
		byte[] buffer = bos.toByteArray();
		bos.close();
		
		response.setContentLength(buffer.length);
		OutputStream os = response.getOutputStream();
		os.write(buffer);
		os.close();
	}
	
	private char[] getChars(int length) {
		String chars="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		char[] rands=new char[length];
		for(int i=0;i<rands.length;i++) {
			int index = (int)(Math.random()*chars.length());
			rands[i] = chars.charAt(index);
		}
		return rands;
	}
	

	@RequestMapping(value="/forgetPwd.do",method= RequestMethod.POST)
	@ResponseBody
	public BaseResult forgetPwd(String hyCode,String yxEmail){
		
		try {
			return loginService.forgetPwd(hyCode, yxEmail);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("用户",hyCode,"忘记密码失败：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
}

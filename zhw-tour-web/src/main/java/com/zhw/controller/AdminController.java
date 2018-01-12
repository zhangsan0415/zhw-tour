package com.zhw.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sun.tools.internal.ws.processor.model.Request;
import com.zhw.domain.NewsCenterInfo;
import com.zhw.domain.TourItem;
import com.zhw.response.BaseResult;
import com.zhw.service.AdminService;
import com.zhw.utils.StringUtils;

@RequestMapping("/admin")
@RestController
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AdminService adminService;
	
	/***********************旅游管理****************************************/
	
	//分页查询管理员行程管理
	@RequestMapping(value="/tourItems.do",method=RequestMethod.POST)
	public BaseResult tourItems(Integer areaType,int currentPage) {
		try {
			return adminService.getTourItems(areaType,currentPage);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("获取旅游行程失败，原因：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//删除旅游行程
	@RequestMapping(value="/delTourItem.do",method=RequestMethod.POST)
	public BaseResult delTourItem(int pkId) {
		try {
			return adminService.removeTourItem(pkId);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("删除旅游行程失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//添加旅游行程
	@RequestMapping(value="/addTourItem.do",method=RequestMethod.POST)
	public BaseResult addTourItem(TourItem obj,HttpServletRequest request) {
		try {
			if(obj == null)	return BaseResult.failedInstance("添加数据不能为空！");
			return adminService.addOneTourItem(obj,ControllerUtils.getUserInfo(request).getHyCode());
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("添加旅游行程异常，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	//旅游报名查看
	@RequestMapping(value="/queryTourList.do",method= RequestMethod.POST)
	public BaseResult getTourList(String hyCode,int areaType,int tourType,String cfDate,int currentPage,HttpServletRequest request){
		try {
			return adminService.queryTourList(hyCode,areaType,tourType,cfDate,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("分页获取报名列表失败，当前会员编号：",ControllerUtils.getUserInfo(request).getHyCode(),",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	//管理员删除报名记录
	@RequestMapping(value="/delTourInfo.do",method=RequestMethod.POST)
	public BaseResult delTourInfo(int pkId) {
		try {
			return adminService.delTourInfo(pkId);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("管理员删除报名记录，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	//管理员确认报名记录
	@RequestMapping(value="/confirmTourInfo.do",method=RequestMethod.POST)
	public BaseResult confirmTourInfo(int pkId) {
		try {
			return adminService.confirmTourInfo(pkId);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("管理员确认报名记录，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	
	/***********************会员管理****************************************/
	@RequestMapping(value="/auditList.do",method=RequestMethod.POST)
	public BaseResult auditList(String hyCode,int currentPage ){
		try {
			return adminService.getAuditList(hyCode, currentPage);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取已激活会员列表失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/auditHy.do",method=RequestMethod.POST)
	public BaseResult auditHy(String hyCode) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.conditionErrorInstance();
			return adminService.auditHy(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("审核会员异常，编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/delHy.do",method=RequestMethod.POST)
	public BaseResult delHy(String hyCode) {
		try {
			if(StringUtils.isEmpty(hyCode))	return BaseResult.conditionErrorInstance();
			return adminService.delHy(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("删除会员异常，编号：",hyCode,",异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/notBdList.do",method=RequestMethod.POST)
	public BaseResult notBdList(String hyCode,int currentPage) {
		try {
			return adminService.getNotBdList(hyCode, currentPage);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("分页获取非报单中心列表失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/ktBd.do",method=RequestMethod.POST)
	public BaseResult ktBd(String hyCode) {
		try {
			return adminService.ktBdCenter(hyCode);
		}catch(Exception e) {
			logger.error(StringUtils.putTogether("开通报单中心失败，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	
	/***********************新闻编辑****************************************/
	@RequestMapping(value="/addNews", method=RequestMethod.POST)
	public BaseResult addNews(String newsTitle,MultipartFile picture){
		try {
			if(StringUtils.isEmpty(newsTitle)|| picture == null)return BaseResult.conditionErrorInstance();
		
			String fileName = picture.getOriginalFilename();//图片原始名称
			String pic_path = "F:\\temp\\images\\";//存储路径
		    String newFileName = UUID.randomUUID().toString().replace("-", "");//新图片名称
		    String type = fileName.split("\\.")[1];//图片后缀名
			File file = new File(pic_path+newFileName);
			picture.transferTo(file);//将内存中的数据写入磁盘
			NewsCenterInfo info = new NewsCenterInfo();
			info.setNewsName(newFileName);//图片名称
			info.setNewsTitle(newsTitle);//主题
			info.setNewsType(type);//后缀
			return adminService.addNews(info);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("添加新闻，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
	
	@RequestMapping(value="/queryNews", method=RequestMethod.POST)
	public BaseResult queryList(String newsTitle,int currentPage){
		try {
			return adminService.getNewsList(newsTitle,currentPage);
		} catch (Exception e) {
			logger.error(StringUtils.putTogether("查询新闻列表，异常信息：",e.getMessage()),e);
			return BaseResult.exceptionInstance();
		}
	}
}

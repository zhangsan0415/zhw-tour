package com.zhw.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zhw.domain.MemberInfo;

public interface MemberInfoMapper {

	//登录时通过用户名密码查询用户
	MemberInfo selectForLogin(@Param("hyCode")String hyCode,@Param("yjPwd")String yjPwd);
	
	//验证会员编号是否存在时查询指定会员编号的会员个数
	int selectCountByHyCode(String hyCode);
	
	//插入新的会员信息
	int insertNewHyInfo(MemberInfo obj);
	
	//修改密码
	int modifyPwd(@Param("hyCode")String hyCode,@Param("yjPwd")String yjPwd,@Param("ejPwd")String ejPwd);

	//修改资料(手机号和邮箱)
	int modifyInfo(@Param("hyCode")String hyCode,@Param("sjMobile")String phone,@Param("yxEmail")String email,@Param("sfzCardCode")String sfzCardCode);

	//根据开通状态查询会员信息
	List<MemberInfo> selectMemberInfoByKtManAndStatus(@Param("hyCode")String hyCode,@Param("jhStatus")int jhStatus);

	//查询接点人工号
	String selectJdManCode(String hyCode);
	
	//根据推荐人查询会员信息
	List<MemberInfo> selectMemberInfoBytjMan(String tjMan);
	
	//根据会员编码查询会员信息
	MemberInfo selectHyInfoByCode(String hyCode);

	//修改是否报单中心状态为已修改
	int updateIfBdCenter(String hyCode);
	
	//分页查询是否激活会员列表的总条数
	int selectCountForActivedOrNot(@Param("hyCode")String hyCode,@Param("jhStatus")int jhStatus,@Param("currentUser")String currentUser);
	
	//分页查询已激活或者未激活的会员列表
	List<MemberInfo> selectActivedOrNotPageList(@Param("hyCode")String hyCode
			,@Param("jhStatus")int jhStatus,@Param("start")int start,@Param("pageSize")int pageSize,@Param("currentUser")String currentUser);
	
	//更新会员的激活状态,开通会员时使用
	int updateJhStatus(@Param("hyCode")String hyCode,@Param("ktTime")String ktTime,@Param("jhStatus")int jhStatus);
	
	//删除会员时使用
	int deleteHyByCode(String hyCode);
	
}

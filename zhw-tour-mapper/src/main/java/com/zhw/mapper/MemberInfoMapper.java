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
	List<MemberInfo> selectMemberInfoByStatus(@Param("hyCode")String hyCode,@Param("jhStatus")int jhStatus);

	//查询接点人工号
	String selectJdManCode(String hyCode);
	//查询推荐的人的信息
	List<MemberInfo> selectMemberInfoBytjMan(String tjMan);
}

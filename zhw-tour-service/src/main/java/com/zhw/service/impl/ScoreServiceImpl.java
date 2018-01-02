package com.zhw.service.impl;

import java.math.BigDecimal;
import java.util.List;







import javax.annotation.Resource;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zhw.domain.MemberScoreInfo;
import com.zhw.mapper.MemberScoreInfoMapper;
import com.zhw.service.ScoreService;
import com.zhw.type.ZZTypeEnum;

@Service
public class ScoreServiceImpl implements ScoreService {

	@Resource
	private MemberScoreInfoMapper scoreInfoMapper;
	
	
	@Override
	public List<MemberScoreInfo> queryInfo(String hyCode){
		// TODO Auto-generated method stub
		List<MemberScoreInfo> list = scoreInfoMapper.queryInfoByHycode(hyCode);
		if(list.size()==0|| list==null)return null;
		//设置转账类型
		list.forEach(obj->{
			obj.setZzType(ZZTypeEnum.getNameByCode(obj.getZzType()));
		});
		return list;
	}


	@Override
	@Transactional
	public MemberScoreInfo zzScore(MemberScoreInfo info)throws Exception {
		BigDecimal money = info.getZzMoney();//转账金额
		BigDecimal bdScore = info.getBdScore();//报单积分
		BigDecimal jjScore = info.getJjScore();//奖金积分
		BigDecimal lyScore = info.getLyScore();//旅游积分
		switch (info.getZzType()) {
		case "1010"://报单积分转给其他会员
			//金额大于报单积分时，直接返回
			if (money.compareTo(bdScore)>1) {
				return null;
			}
			//借方报单积分减少，贷方报单积分增加
			info.setBdScore(money.subtract(bdScore));
			//更新借方积分信息
			scoreInfoMapper.updateScoreInfo(info);
			//查询贷方信息
			MemberScoreInfo score = scoreInfoMapper.selectScoreInfoByCode(info.getDfCode());
			score.setBdScore(money.add(score.getBdScore()));
			//更新贷方积分信息
			scoreInfoMapper.updateScoreInfo(score);
			break;
		case "1011"://奖金积分 转 报单积分
			if (money.compareTo(jjScore)>1) {
				return null;
			}
			info.setJjScore(money.subtract(jjScore));
			info.setBdScore(money.add(info.getBdScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1012"://奖金积分 转 现金积分
			if (money.compareTo(jjScore)>1) {
				return null;
			}
			info.setJjScore(money.subtract(jjScore));
			info.setXjScore(money.add(info.getXjScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1013"://奖金积分 转 购物积分
			if (money.compareTo(jjScore)>1) {
				return null;
			}
			info.setJjScore(money.subtract(jjScore));
			info.setGwScore(money.add(info.getGwScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1014"://旅游积分 转 报单积分
			if (money.compareTo(lyScore)>1) {
				return null;
			}
			info.setJjScore(money.subtract(lyScore));
			info.setBdScore(money.add(info.getBdScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		case "1015"://旅游积分 转 现金积分
			if (money.compareTo(lyScore)>1) {
				return null;
			}
			info.setJjScore(money.subtract(lyScore));
			info.setXjScore(money.add(info.getXjScore()));
			scoreInfoMapper.updateScoreInfo(info);
			break;
		default:
			break;
		}
		return scoreInfoMapper.selectScoreInfoByCode(info.getHyCode());
	}

	
}

package com.hrm.service.impl;

import java.util.List;

import com.hrm.dao.BipMapper;
import com.hrm.dao.BipSkillMapper;
import com.hrm.dao.ForeignMapper;
import com.hrm.dao.ZjGrqzdjbMapper;
import com.hrm.dao.ZjGrqzgzbMapper;
import com.hrm.service.JobRegistService;
import com.hrm.vo.Bip;
import com.hrm.vo.BipSkill;
import com.hrm.vo.Bip_foreignlanguage;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
import com.hrm.vo.pojo.ForeignList;
import com.hrm.vo.pojo.GrqzgzbList;
import com.hrm.vo.pojo.SkillList;

public class JobRegistServiceImp implements JobRegistService {
	private BipMapper bipMapper;
	private BipSkillMapper skillMapper;
	private ZjGrqzgzbMapper gzMapper;
	private ZjGrqzdjbMapper gzdjbMapper;
	private ForeignMapper foreignMapper;
	@Override
	public Bip getBipById(String s) {
		// TODO Auto-generated method stub
		Bip bip=bipMapper.getBipById(s);
		return bip;
	}
	@Override
	public void save(Bip bip, SkillList bipskill, GrqzgzbList zjGrqzgzb, ForeignList forgign, ZjGrqzdjb gzdjb) {
		// TODO Auto-generated method stub
		bipMapper.insert(bip);
		gzdjbMapper.insert(gzdjb);
		if(zjGrqzgzb!=null){
			for(int m=0;m<zjGrqzgzb.getList().size();m++){
				gzMapper.insert(zjGrqzgzb.getList().get(m));
			}
			
		}
		if(zjGrqzgzb!=null){
			for(int i=0;i<bipskill.getList().size();i++){
				skillMapper.insert(bipskill.getList().get(i));
			}
		}
		if(bipskill!=null){
			for(int j=0;j<bipskill.getList().size();j++){
				foreignMapper.insert(forgign.getList().get(j));
			}
		}
		
		
		
		
	}
	@Override
	public ZjGrqzdjb getZj_grqzdjbById(String bipCitizenid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<ZjGrqzgzb> getbip_Zj_grqzgzbById(String qzbh) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Bip_foreignlanguage> getBip_flById(String bipCitizenid) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<BipSkill> getbip_skillById(String bipCitizenid) {
		// TODO Auto-generated method stub
		return null;
	}
}

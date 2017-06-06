package com.hrm.service;

import java.util.List;

import com.hrm.vo.Bip;
import com.hrm.vo.BipSkill;
import com.hrm.vo.Bip_foreignlanguage;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
import com.hrm.vo.pojo.ForeignList;
import com.hrm.vo.pojo.GrqzgzbList;
import com.hrm.vo.pojo.SkillList;

public interface JobRegistService {

	Bip getBipById(String s);
	void save(Bip bip, SkillList bipskill, GrqzgzbList zjGrqzgzb, ForeignList forgign, ZjGrqzdjb gzdjb);
	ZjGrqzdjb getZj_grqzdjbById(String bipCitizenid);
	List<ZjGrqzgzb> getbip_Zj_grqzgzbById(String qzbh);
	List<Bip_foreignlanguage> getBip_flById(String bipCitizenid);
	List<BipSkill> getbip_skillById(String bipCitizenid);
}

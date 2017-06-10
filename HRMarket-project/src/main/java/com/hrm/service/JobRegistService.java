package com.hrm.service;

import java.util.List;

import com.hrm.vo.Bip;
import com.hrm.vo.BipSkill;
import com.hrm.vo.BipForeignlanguage;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
import com.hrm.vo.model.RegistModel;

public interface JobRegistService {

	ZjGrqzdjb getZj_grqzdjbById(String bipId);
	List<ZjGrqzgzb> getbip_Zj_grqzgzbById(String qzbh);
	List<BipForeignlanguage> getBip_flById(String bipId);
	List<BipSkill> getbip_skillById(String bipId);
	void save(RegistModel registModel);
	Bip findBipInfoByBipCitizenid(String bipCitizenid);
	void delectForeignByFlId(String code);
	void delectSkillById(String code);
	void delectGzById(String code);
	void updateAll(RegistModel registModel);
	
}

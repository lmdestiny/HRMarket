package com.hrm.dao;

import java.util.List;

import com.hrm.vo.BipSkill;

public interface BipSkillMapper {
	void insert(BipSkill bipskill);
	List<BipSkill> getbip_skillById(String bipId);
	void deleteSkillById(String code);
}
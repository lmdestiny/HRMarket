package com.hrm.dao;

import java.util.List;

import com.hrm.vo.BipForeignlanguage;

public interface ForeignMapper {

	void insert(BipForeignlanguage bip_foreignlanguage);
	List<BipForeignlanguage> getBip_flById(String bipId);
	void delectForeignByFlId(String code);
}

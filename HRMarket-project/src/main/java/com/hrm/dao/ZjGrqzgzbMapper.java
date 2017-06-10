package com.hrm.dao;

import java.util.List;
import java.util.Map;

import com.hrm.vo.ZjGrqzgzb;

public interface ZjGrqzgzbMapper {
	
	void insert(ZjGrqzgzb gzb);
	List<ZjGrqzgzb> getbip_Zj_grqzgzbById(String qzbh);
	void upDateGuidang(Map<String, Object> map);
	void delectGzById(String code);
   
}
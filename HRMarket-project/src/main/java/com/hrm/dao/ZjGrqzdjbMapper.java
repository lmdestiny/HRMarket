package com.hrm.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hrm.vo.ZjGrqzdjb;

public interface ZjGrqzdjbMapper {
	
	void insert(ZjGrqzdjb gzdjb);

	void update(@Param("bipId") String bipId,@Param("str") String str);

	void upDateGuidang(Map<String, Object> map);
  
}
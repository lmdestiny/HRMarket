package com.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hrm.vo.ZjGrqzdjjdb;

public interface ZjGrqzdjjdbMapper {

	List<ZjGrqzdjjdb> getAllBy(String qzbh);

	ZjGrqzdjjdb getByQzbh(String qzbh);

	void update(@Param("qzbh") String qzbh, @Param("str") String str,@Param("reason") String reason,@Param("updatetime") String updatetime);

	void upDateGuidang(Map<String,Object> map);

}
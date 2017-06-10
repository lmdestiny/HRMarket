package com.hrm.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hrm.vo.Bip;

public interface BipMapper {
	
	void insert(Bip bip);

	List<Bip> findBip(Map<String,Object> map);

	Bip findBipByCitizenid(String bipCitizenid);

	List<Bip> findBipByBipName(String bipName);

	Bip findState(String bipCitizenid);

	Bip findBipInfoByBipCitizenid(String bipCitizenid);

	List<Bip> findBipByArray(@Param("bipCitizenid")String bipCitizenid,@Param("bipName") String bipName,@Param("sfdj") String sfdj);

	void updateById(Bip bip);

}
package com.hrm.dao;

import java.util.List;
import java.util.Map;

import com.hrm.vo.Bip;

public interface BipMapper {

	List<Bip> findBip(Map<String,Object> map);
  
}
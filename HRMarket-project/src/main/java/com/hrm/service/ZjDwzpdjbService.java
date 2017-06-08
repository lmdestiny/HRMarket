package com.hrm.service;

import java.util.List;

import org.junit.validator.PublicClassValidator;

import com.hrm.vo.ZjDwzpdjb;

public interface ZjDwzpdjbService {
	public void save(ZjDwzpdjb dwzpdjb);
	public void update(ZjDwzpdjb dwzpdjb);
	//根据 招聘编号 删除
	public void delete(String zpbh);
	public List<ZjDwzpdjb> getAll();
	
}

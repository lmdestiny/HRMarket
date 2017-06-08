package com.hrm.service;

import java.util.List;

import com.hrm.vo.ZjDwzpgzb;

public interface ZjDwzpgzbService {
	public void inset(ZjDwzpgzb dwzpgzb);
	public void update(ZjDwzpgzb dwzpgzb);
	public void delete(String zpgzbh);
	//查询全部
	public List<ZjDwzpgzb> getAll();
	//根据 招聘编号(zpbh) 查询所有招聘工种 
	public List<ZjDwzpgzb> getbyZPBH(String zpbh);
	//根据 招聘工种编号(zpgzbh)查询
	public ZjDwzpgzb getOne(String zpgzbh);
	
}

package com.hrm.dao;

import java.util.List;

import com.hrm.vo.ZjDwzpgzb;

public interface ZjDwzpgzbMapper {
	public void insert(ZjDwzpgzb dwzpgzb);
	
	public void update(ZjDwzpgzb dwzpgzb);
	//根据 招聘工种编号(zpgzbh) 删除
	public void delete(String zpgzbh);
	//查询全部
	public List<ZjDwzpgzb> getAll();
	//根据 招聘工种编号(zpgzbh)查询
	public ZjDwzpgzb getOne(String zpgzbh);
	//根据 招聘编号(zpbh) 查询所有招聘工种 
	public List<ZjDwzpgzb> getbyZPBH(String zpbh);
	//根据 招聘工种 和 招聘编号（登记表主键）查询该工种信息
	public ZjDwzpgzb getbyBHandGZ(String zpbh,String zpgz);
}
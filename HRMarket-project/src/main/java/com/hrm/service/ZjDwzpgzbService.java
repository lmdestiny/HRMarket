package com.hrm.service;

import java.util.List;

import com.hrm.vo.ZjDwzpdjb;
import com.hrm.vo.ZjDwzpgzb;

public interface ZjDwzpgzbService {
	//增添验证信息，保存前先确定该表是否存在，并根据登记表进行插入或更新；
	public boolean save(ZjDwzpgzb dwzpgzb,ZjDwzpdjb dwzpdjb);
	public void update(ZjDwzpgzb dwzpgzb);
	public void delete(String zpgzbh);
	//查询全部
	public List<ZjDwzpgzb> getAll();
	//根据 招聘编号(zpbh) 查询所有招聘工种 
	public List<ZjDwzpgzb> getbyZPBH(String zpbh);
	//根据 招聘工种编号(zpgzbh)查询 
	public ZjDwzpgzb getOne(String zpgzbh);
	
	
}

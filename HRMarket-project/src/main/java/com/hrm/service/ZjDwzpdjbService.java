package com.hrm.service;

import java.util.List;

import com.hrm.vo.ZjDwzpdjb;

public interface ZjDwzpdjbService {
	public void save(ZjDwzpdjb dwzpdjb);
	public void update(ZjDwzpdjb dwzpdjb);
	//根据 招聘编号 删除
	public void delete(String zpbh);
	public List<ZjDwzpdjb> getAll();
	//根据 招聘编号 查找
	public ZjDwzpdjb getOne(String zpbh);
	//根据 单位编号 查找所有招聘信息
	public List<ZjDwzpdjb> getbyDWBH(String dwbh);
	
}

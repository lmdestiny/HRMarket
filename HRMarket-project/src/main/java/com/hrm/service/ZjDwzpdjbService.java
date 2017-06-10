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
	public ZjDwzpdjb getOnebyDWBH(String dwbh);
	//该方法用于 在zpgz中调用，作用是 验证 该登记信息是否已存在 返回主键，用于工种表中信息插入
	public String confrimInfo(ZjDwzpdjb dwzpdjb);
	
	//
	public void updateDjjd(String zpbh);
}

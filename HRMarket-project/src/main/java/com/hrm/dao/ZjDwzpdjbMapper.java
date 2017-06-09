package com.hrm.dao;

import java.util.List;

import com.hrm.vo.ZjDwzpdjb;

/**
 * 单位招聘登记表
 * @author qst
 *
 */
public interface ZjDwzpdjbMapper {
	public void insert(ZjDwzpdjb dwzpdjb);
	public void update(ZjDwzpdjb dwzpdjb);
	//根据 招聘编号(zpbh) 删除
	public void delete(String zpbh);
	public List<ZjDwzpdjb> getAll();
	//根据 招聘编号 查找
	public ZjDwzpdjb getOne(String zpbh);
	//根据 单位编号 查找所有招聘信息
	public ZjDwzpdjb getOnebyDWBH(String dwbh);
}
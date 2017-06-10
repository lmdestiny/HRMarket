package com.hrm.service;

import java.util.List;
import java.util.Map;

import com.hrm.vo.BioDj;
import com.hrm.vo.ZjDwdjjdb;

public interface ZjDwdjjdbService {
	public void insert(ZjDwdjjdb dwdjjdb);
	public void update(ZjDwdjjdb dwdjjdb);
	public void delete(String dwdjjdbh);
	public List<ZjDwdjjdb> getAll();
	//根据 单位法人码 获得 状态，名称，地址，电话，时间,招聘编号
	public BioDj  getbyFRM(String dwfrm);
	//根据 单位名称获得
	public List<BioDj>  getbyDWMC(String dwmc);
	public BioDj  getbyZPBH(String zpbh);
}

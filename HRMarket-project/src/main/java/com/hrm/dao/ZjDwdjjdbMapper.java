package com.hrm.dao;

import java.util.List;
import java.util.Map;

import com.hrm.vo.BioDj;
import com.hrm.vo.ZjDwdjjdb;

/**
 * 单位冻结解冻表
 * @author qst
 *
 */
public interface ZjDwdjjdbMapper {
	public void insert(ZjDwdjjdb dwdjjdb);
	public void update(ZjDwdjjdb dwdjjdb);
	public void delete(String dwdjjdbh);
	public List<ZjDwdjjdb> getAll();
	public BioDj  getbyFRM(String dwfrm);
	public List<BioDj>  getbyDWMC(String dwmc);
	public BioDj  getbyZPBH(String zpbh);
}
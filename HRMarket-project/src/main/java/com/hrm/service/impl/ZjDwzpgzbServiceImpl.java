package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.ZjDwzpgzbMapper;
import com.hrm.service.ZjDwzpgzbService;
import com.hrm.vo.ZjDwzpgzb;
import com.imti.ldlsc.common.util.GenerateID;

@Service
public class ZjDwzpgzbServiceImpl implements ZjDwzpgzbService {
	
	@Autowired
	private ZjDwzpgzbMapper ZjDwzpgzbdao;
	private GenerateID generateid=new GenerateID();
	@Override
	public void inset(ZjDwzpgzb dwzpgzb) {
		// TODO 自动生成的方法存根
		dwzpgzb.setZpgzbh(generateid.getGenerateId());
		ZjDwzpgzbdao.inset(dwzpgzb);
		

	}

	@Override
	public void update(ZjDwzpgzb dwzpgzb) {
		// TODO 自动生成的方法存根
		ZjDwzpgzbdao.update(dwzpgzb);
	}
	
	//根据 招聘工种编号(zpgzbh) 删除
	@Override
	public void delete(String zpgzbh) {
		// TODO 自动生成的方法存根
		ZjDwzpgzbdao.delete(zpgzbh);
	}

	@Override
	public List<ZjDwzpgzb> getAll() {
		return ZjDwzpgzbdao.getAll();
	}
	
	//根据 招聘编号(zpbh) 查询所有添加的招聘工种 
	@Override
	public List<ZjDwzpgzb> getbyZPBH(String zpbh) {
		return ZjDwzpgzbdao.getbyZPBH(zpbh);
	}
	//根据 招聘工种编号(zpgzbh)查询
	@Override
	public ZjDwzpgzb getOne(String zpgzbh) {
		return ZjDwzpgzbdao.getOne(zpgzbh);
	}

}

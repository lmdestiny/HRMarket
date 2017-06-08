package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.ZjDwzpdjbMapper;
import com.hrm.service.ZjDwzpdjbService;
import com.hrm.vo.ZjDwzpdjb;
import com.imti.ldlsc.common.util.GenerateID;

@Service
public class ZjDwzpdjbServiceImpl implements ZjDwzpdjbService {
	
	@Autowired
	ZjDwzpdjbMapper ZjDwzpdjbdao;
	private GenerateID generateid=new GenerateID();
	@Override
	public void save(ZjDwzpdjb dwzpdjb) {
		dwzpdjb.setZpbh(generateid.getGenerateId());
		ZjDwzpdjbdao.insert(dwzpdjb);

	}

	@Override
	public void update(ZjDwzpdjb dwzpdjb) {
		ZjDwzpdjbdao.update(dwzpdjb);

	}

	@Override
	public void delete(String zpbh) {
		ZjDwzpdjbdao.delete(zpbh);
	}

	@Override
	public List<ZjDwzpdjb> getAll() {
		return ZjDwzpdjbdao.getAll();
	}

	@Override
	public ZjDwzpdjb getOne(String zpbh) {
		return ZjDwzpdjbdao.getOne(zpbh);
	}

	@Override
	public List<ZjDwzpdjb> getbyDWBH(String dwbh) {
		return ZjDwzpdjbdao.getbyDWBH(dwbh);
	}

}

package com.hrm.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.ZjDwdjjdbMapper;
import com.hrm.service.ZjDwdjjdbService;
import com.hrm.service.ZjDwzpdjbService;
import com.hrm.vo.BioDj;
import com.hrm.vo.ZjDwdjjdb;
import com.imti.ldlsc.common.util.GenerateID;

@Service
public class ZjDwdjjdbServiceImpl implements ZjDwdjjdbService {

	@Autowired
	ZjDwdjjdbMapper ZjDwdjjdbdao;
	@Autowired
	ZjDwzpdjbService zjDwzpdjbService;
	private GenerateID generateid=new GenerateID();
	
	@Override
	@Transactional
	public void insert(ZjDwdjjdb dwdjjdb) {
		zjDwzpdjbService.updateDjjd(dwdjjdb.getZpbh());
		dwdjjdb.setDwdjjdbh(generateid.getGenerateId());
		ZjDwdjjdbdao.insert(dwdjjdb);
	}

	@Override
	public void update(ZjDwdjjdb dwdjjdb) {
		ZjDwdjjdbdao.update(dwdjjdb);
	}

	@Override
	public void delete(String dwdjjdbh) {
		ZjDwdjjdbdao.delete(dwdjjdbh);
	}

	@Override
	public List<ZjDwdjjdb> getAll() {
		return ZjDwdjjdbdao.getAll();
	}

	@Override
	public BioDj getbyFRM(String dwfrm) {	
		return ZjDwdjjdbdao.getbyFRM(dwfrm);
		
	}

	@Override
	public List<BioDj> getbyDWMC(String dwmc) {
		return ZjDwdjjdbdao.getbyDWMC(dwmc);
	}

	@Override
	public BioDj getbyZPBH(String zpbh) {
		// TODO 自动生成的方法存根
		return ZjDwdjjdbdao.getbyZPBH(zpbh);
	}

}

package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.ZjDwdjjdbMapper;
import com.hrm.service.ZjDwgdService;
import com.hrm.vo.BioDj;
import com.hrm.vo.ZjDwgd;

@Service
public class ZjDwgdServiceImpl implements ZjDwgdService {

	@Autowired
	private ZjDwdjjdbMapper ZjDwdjjdbdao;
	@Override
	public List<BioDj> getAll(ZjDwgd dwgd) {
		return ZjDwdjjdbdao.getGDinfo(dwgd);
		
	}
	

	
	
	
}

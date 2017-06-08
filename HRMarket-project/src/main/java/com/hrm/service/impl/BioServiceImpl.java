package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.BioMapper;
import com.hrm.service.BioService;
import com.hrm.vo.Bio;
import com.imti.ldlsc.common.util.GenerateID;

@Service
public class BioServiceImpl implements BioService {
	
	@Autowired
	private BioMapper bioDao;
	private GenerateID generateid=new GenerateID();
	
	@Override
	@Transactional
	public void save(Bio bio) {
		// TODO 自动生成的方法存根
		bio.setBioId(generateid.getGenerateId());
		bioDao.insert(bio);
	}

	@Override
	public void update(Bio bio) {
		// TODO 自动生成的方法存根
		bioDao.update(bio);
	}

	@Override
	public void delete(String id) {
		// TODO 自动生成的方法存根
		bioDao.delete(id);
	}

	@Override
	public List<Bio> getAll() {
		return bioDao.getAll();
	}

	//按bio_id查找（表编号自动生成）
	@Override
	public Bio getbyId(String id) {
		return bioDao.getOnebyId(id);
	}

	//按bio_no（法人码）查找
	@Override
	public Bio getbyNo(String no) {
		// TODO 自动生成的方法存根
		return bioDao.getOnebyNo(no);	
	}
}

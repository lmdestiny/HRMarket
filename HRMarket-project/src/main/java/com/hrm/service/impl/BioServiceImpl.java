package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.BioMapper;
import com.hrm.service.BioService;
import com.hrm.vo.Bio;

@Service
public class BioServiceImpl implements BioService {
	@Autowired
	BioMapper bioDao;
	
	@Override
	@Transactional
	public void save(Bio bio) {
		// TODO 自动生成的方法存根
		System.out.println(bioDao.getClass());
		bioDao.insert(bio);
		System.out.println(bio);
	}

	@Override
	@Transactional
	public void update(Bio bio) {
		// TODO 自动生成的方法存根
		bioDao.update(bio);
	}

	@Override
	@Transactional
	public void delete(String id) {
		// TODO 自动生成的方法存根
		bioDao.delete(id);
		
	}

	@Override
	@Transactional
	public List<Bio> getAll() {
		return bioDao.getAll();
	}

	@Override
	public Bio getbyId(String id) {
		
		return bioDao.getOnebyId(id);
	}

	@Override
	@Transactional
	public Bio getbyNo(String no) {
		// TODO 自动生成的方法存根
		return bioDao.getOnebyNo(no);
		
	}



}

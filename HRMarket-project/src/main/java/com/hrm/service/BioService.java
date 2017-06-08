package com.hrm.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hrm.vo.Bio;

@Component
public interface BioService {
	
	public void save(Bio bio);
	public void update(Bio bio);
	public void delete(String id);
	public List<Bio> getAll();
	public Bio getbyId(String id);
	public Bio getbyNo(String no);

}

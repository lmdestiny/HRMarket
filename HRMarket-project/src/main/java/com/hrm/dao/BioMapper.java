package com.hrm.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrm.vo.Bio;

public interface BioMapper {
	public void insert(Bio bio);
	public void update(Bio bio);
	public void delete(String bioid);
	public List<Bio> getAll();
	public Bio getOnebyId(String bioid);
	public Bio getOnebyNo(String bioNo);
}
package com.hrm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.dao.ZjGrqzdjjdbMapper;
import com.hrm.service.ZjGrqzdjjdbService;
import com.hrm.vo.ZjGrqzdjjdb;
/**
 * 个人求职冻结解冻操作
 * @author wangbin
 *
 */
@Service
public class ZjGrqzdjjdbServiceImpl implements ZjGrqzdjjdbService{

	/**
	 * 根据求职编号得到个人求职冻结解冻对象
	 */
	@Autowired
	private ZjGrqzdjjdbMapper zjGrqzdjjdbMapper;
	@Override
	public ZjGrqzdjjdb getZjGrqzdjjdbByQzbh(String qzbh){
		ZjGrqzdjjdb zjGrqzdjjdb = zjGrqzdjjdbMapper.getByQzbh(qzbh);
		return zjGrqzdjjdb;
	}

}

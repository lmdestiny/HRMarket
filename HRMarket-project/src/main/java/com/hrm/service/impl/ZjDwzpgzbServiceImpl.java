package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.ZjDwzpdjbMapper;
import com.hrm.dao.ZjDwzpgzbMapper;
import com.hrm.service.ZjDwzpdjbService;
import com.hrm.service.ZjDwzpgzbService;
import com.hrm.vo.ZjDwzpdjb;
import com.hrm.vo.ZjDwzpgzb;
import com.imti.ldlsc.common.util.GenerateID;

@Service
public class ZjDwzpgzbServiceImpl implements ZjDwzpgzbService {
	
	@Autowired
	private ZjDwzpgzbMapper ZjDwzpgzbdao;
	@Autowired
	private ZjDwzpdjbService zjDwzpdjbService;
	private GenerateID generateid=new GenerateID();
	
	@Override
	@Transactional
	public boolean save(ZjDwzpgzb dwzpgzb,ZjDwzpdjb dwzpdjb) {
		//首先根据登记表获得主键
		String zpbh=zjDwzpdjbService.confrimInfo(dwzpdjb);
		dwzpgzb.setZpbh(zpbh);
		//验证：根据 招聘工种 和 招聘编号（登记表主键）查询该工种信息是否已存在		
		ZjDwzpgzb gzbconfrim=ZjDwzpgzbdao.getbyBHandGZ(dwzpgzb.getZpbh(), dwzpgzb.getZpgz());
		//如果存在，返回 false 表示插入失败
		if(gzbconfrim!=null){
			return false;
		}else {
			//如果不存在 新建 
			//生成主键
			dwzpgzb.setZpgzbh(generateid.getGenerateId());
			//插入数据库
			ZjDwzpgzbdao.insert(dwzpgzb);
			//返回 true 插入成功
			return true;
		}
		
		

	}

	@Override
	public void update(ZjDwzpgzb dwzpgzb) {
		ZjDwzpgzbdao.update(dwzpgzb);
	}
	
	//根据 招聘工种编号(zpgzbh) 删除
	@Override
	public void delete(String zpgzbh) {
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

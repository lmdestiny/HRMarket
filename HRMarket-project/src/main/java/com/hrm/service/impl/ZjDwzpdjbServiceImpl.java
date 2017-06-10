package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	public ZjDwzpdjb getOnebyDWBH(String dwbh) {
		return ZjDwzpdjbdao.getOnebyDWBH(dwbh);
	}

	@Override
	@Transactional
	public String confrimInfo(ZjDwzpdjb dwzpdjb) {
		//根据单位编号查询 是否已存在该招聘登记信息 
		ZjDwzpdjb djbconfrim=ZjDwzpdjbdao.getOnebyDWBH(dwzpdjb.getDwbh());
		//如果存在（不为空），1.将已存在的表中招聘编号即主键set到参数表中，更新该表；
		if(djbconfrim!=null){
			dwzpdjb.setZpbh(djbconfrim.getZpbh());
			ZjDwzpdjbdao.update(dwzpdjb);
		}else {
			//如果不存在，先生成主键，然后插入
			dwzpdjb.setZpbh(generateid.getGenerateId());
			ZjDwzpdjbdao.insert(dwzpdjb);
		}
		return dwzpdjb.getZpbh();
		
	}

	@Override
	@Transactional
	public boolean updateDjjd(String zpbh) {
		ZjDwzpdjb zjDwzpdjb=ZjDwzpdjbdao.getOne(zpbh);
		if(zjDwzpdjb.getSfdj().equals("0")){
			ZjDwzpdjbdao.updateDjjd("1", zpbh);
			//由 未冻结 变为 冻结  插入冻结表 返回true
			return true;
		}else {
			ZjDwzpdjbdao.updateDjjd("0", zpbh);
			return false;
		}
		
	}

}

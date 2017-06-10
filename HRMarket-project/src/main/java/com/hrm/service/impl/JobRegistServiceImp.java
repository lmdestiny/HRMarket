package com.hrm.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.BipMapper;
import com.hrm.dao.BipSkillMapper;
import com.hrm.dao.ForeignMapper;
import com.hrm.dao.ZjGrqzdjbMapper;
import com.hrm.dao.ZjGrqzgzbMapper;
import com.hrm.service.JobRegistService;
import com.hrm.utils.IDUtils;
import com.hrm.vo.Bip;
import com.hrm.vo.BipSkill;
import com.hrm.vo.BipForeignlanguage;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
import com.hrm.vo.model.RegistModel;
@Service
public class JobRegistServiceImp implements JobRegistService {
	@Autowired
	private BipMapper bipMapper;
	@Autowired
	private BipSkillMapper skillMapper;
	@Autowired
	private ZjGrqzgzbMapper gzMapper;
	@Autowired
	private ZjGrqzdjbMapper gzdjbMapper;
	@Autowired
	private ForeignMapper foreignMapper;
		
	@Override
	public List<ZjGrqzgzb> getbip_Zj_grqzgzbById(String qzbh) {
		// TODO Auto-generated method stub
		List<ZjGrqzgzb> list=gzMapper.getbip_Zj_grqzgzbById(qzbh);
		return list;
	}
	@Override
	public List<BipForeignlanguage> getBip_flById(String bipId) {
		// TODO Auto-generated method stub
		return foreignMapper.getBip_flById(bipId);
	}
	@Override
	public List<BipSkill> getbip_skillById(String bipId) {
		// TODO Auto-generated method stub
		return skillMapper.getbip_skillById(bipId);
	}

	@Override
	@Transactional
	public void save(RegistModel registModel) {
		// TODO Auto-generated method stub
		registModel.getBip().setBipId(IDUtils.genItemId()+"");
		registModel.getBip().setBipBirthday(registModel.getBip().getBipCitizenid().substring(6, 14));
		registModel.getZjGrqzdjb().setBipId(registModel.getBip().getBipId());
		String djsj=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
		registModel.getZjGrqzdjb().setDjsj(djsj);
		registModel.getZjGrqzdjb().setDjyxq("15");
		registModel.getZjGrqzdjb().setQzbh(IDUtils.genItemId()+"");
		bipMapper.insert(registModel.getBip());
		gzdjbMapper.insert(registModel.getZjGrqzdjb());
		for(BipForeignlanguage bf:registModel.getBipForeignlanguags()){
			bf.setBipFlId(IDUtils.genItemId()+"");
			bf.setBipId(registModel.getBip().getBipId());
			foreignMapper.insert(bf);
		}
		for(ZjGrqzgzb zg:registModel.getZjGrqzgzbs()){
			zg.setQzgzbh(IDUtils.genItemId()+"");
			zg.setQzbh(registModel.getZjGrqzdjb().getQzbh());
			String djsj2=new SimpleDateFormat("yyyy/MM/dd").format(new Date());
			zg.setDjsj(djsj2);
			gzMapper.insert(zg);
		}
		for(BipSkill bs:registModel.getBipSkills()){
			bs.setBipSId(IDUtils.genItemId()+"");
			bs.setBipId(registModel.getBip().getBipId());
			skillMapper.insert(bs);
		}
		
		
	}
	@Override
	public ZjGrqzdjb getZj_grqzdjbById(String bipId) {
		// TODO Auto-generated method stub
		return gzdjbMapper.getZj_grqzdjbById(bipId);
	}
	@Override
	public Bip findBipInfoByBipCitizenid(String bipCitizenid) {
		// TODO Auto-generated method stub
		Bip bip=bipMapper.findBipByCitizenid(bipCitizenid);
		return bip;
	}
	@Override
	public void delectForeignByFlId(String code) {
		// TODO Auto-generated method stub
		if(code!=null){
		foreignMapper.delectForeignByFlId(code);
		}
		
		
	}
	@Override
	public void delectSkillById(String code) {
		// TODO Auto-generated method stub
		skillMapper.deleteSkillById(code);
		
	}
	@Override
	public void delectGzById(String code) {
		// TODO Auto-generated method stub
		gzMapper.delectGzById(code);
	}
	@Override
	public void updateAll(RegistModel registModel) {
		// TODO Auto-generated method stub
		bipMapper.updateById(registModel.getBip());
		registModel.getZjGrqzdjb().setBipId(registModel.getBip().getBipId());
		gzdjbMapper.update2(registModel.getZjGrqzdjb());
		for(BipForeignlanguage bf:registModel.getBipForeignlanguags()){
			bf.setBipFlId(IDUtils.genItemId()+"");
			bf.setBipId(registModel.getBip().getBipId());
			foreignMapper.insert(bf);
		}
		for(ZjGrqzgzb zg:registModel.getZjGrqzgzbs()){
			zg.setQzgzbh(IDUtils.genItemId()+"");
			zg.setQzbh(registModel.getZjGrqzdjb().getQzbh());
			gzMapper.insert(zg);
		}
		for(BipSkill bs:registModel.getBipSkills()){
			bs.setBipSId(IDUtils.genItemId()+"");
			bs.setBipId(registModel.getBip().getBipId());
			skillMapper.insert(bs);
		}
		
	}
}

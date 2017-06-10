package com.hrm.service.impl;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.dao.BipMapper;
import com.hrm.dao.ZjGrqzdjbMapper;
import com.hrm.dao.ZjGrqzdjjdbMapper;
import com.hrm.dao.ZjGrqzgzbMapper;
import com.hrm.service.BipService;
import com.hrm.utils.HRMResult;
import com.hrm.vo.Bip;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzdjjdb;

@Service
public class BipServiceImpl implements BipService{
	@Autowired
	private BipMapper bipMapper;
	@Autowired
	private  ZjGrqzdjjdbMapper zjGrqzdjjdbMapper;
	@Autowired
	private ZjGrqzdjbMapper zjGrqzdjbMapper;
	@Autowired
	private ZjGrqzgzbMapper ZjGrqzgzbMapper;
	@Override
	public List<Bip> search(Bip bip, String nl1, String nl2, String xl1, String xl2,
			String djrq1, String djrq2, String qzgw, String cxfw){
		Map<String ,Object> map = new HashMap<>();
		map.put("bip",bip);
		map.put("qzgw", qzgw);
		map.put("cxfw", cxfw);
		List<Bip> bips = bipMapper.findBip(map);
		for(Bip b:bips) {
			System.out.println(b);
		}
		List<Bip> collect = bips.stream().filter((x)->{
			if(nl1 != ""&&x!=null){
				return  Integer.parseInt(x.getBipAge())>=Integer.parseInt(nl1);
				}else
					return true;
			})
		.filter((x)->{
			if(nl2 != ""&&x!=null){
				return  Integer.parseInt(x.getBipAge())<=Integer.parseInt(nl2);
				}else 
					return true;
			})
		.filter((x)->{
			if(xl1 !=""&&x!=null) {
				return Integer.parseInt(x.getBipEducationallevel2())>=Integer.parseInt(xl1);
				}else
					return true;
		})
		.filter((x)->{
			if(xl2 !=""&&x!=null) {
				return Integer.parseInt(x.getBipEducationallevel2())<=Integer.parseInt(xl2);
				}else
					return true;
		})
		.collect(Collectors.toList());
		return collect;
	}
	@Override
	/**
	 * 根据身份证查询姓名
	 */
	public HRMResult findBipByBipCitizenid(String bipCitizenid){
		try {
			Bip bip = bipMapper.findBipByCitizenid(bipCitizenid);
			if(bip ==null)
				return HRMResult.build(400,"该身份证号不存在");
			return HRMResult.ok(bip.getBipName());
		}catch(Exception e) {
			return HRMResult.build(400,"error");
		}
	}
	@Override
	public HRMResult findBipByBipName(String bipName){
		try {
			List<Bip> bips = bipMapper.findBipByBipName(bipName);
			if(bips ==null) {
				return HRMResult.build(400,"该人员不存在");
			}
			else if(bips.size() ==1) {
				return HRMResult.ok(bips.get(0).getBipCitizenid());
			}else if(bips.size() >1){
				return HRMResult.build(400,"发现多组人员,请输入身份证");
			}else {
				return HRMResult.build(400,"人员不存在");
			}
		}catch(Exception e) {
			return HRMResult.build(400,"error");
		}
	}
	@Override
	public boolean changeStopState(String bipCitizenid){
		Bip bip = bipMapper.findState(bipCitizenid);
		if(bip.getZjGrqzdjbs() !=null &&bip.getZjGrqzdjbs().size()>0) {
		}
		return false;
	}
	@Override
	public Bip findBipInfoByBipCitizenid(String bipCitizenid){
		return bipMapper.findBipInfoByBipCitizenid(bipCitizenid);
	}
	@Override
	public boolean getDongjieStateChange(String qzbh){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		List<ZjGrqzdjjdb> zjGrqzdjjdbs = zjGrqzdjjdbMapper.getAllBy(qzbh);
		if(zjGrqzdjjdbs != null && zjGrqzdjjdbs.size()>0) {
			//最大冻结时间
			List<ZjGrqzdjjdb> collect = zjGrqzdjjdbs.stream()
			.sorted((x,y)->{
				LocalDate localDate = LocalDate.parse(x.getDojsj(), dtf);
				LocalDate localDate2 = LocalDate.parse(y.getDojsj(), dtf);
				return localDate.compareTo(localDate2);
			}).limit(1).collect(Collectors.toList());
			//最大解冻时间
			List<ZjGrqzdjjdb> collect2 = zjGrqzdjjdbs.stream()
			.sorted((x,y)->{
				LocalDate localDate = LocalDate.parse(x.getJidsj(), dtf);
				LocalDate localDate2 = LocalDate.parse(y.getJidsj(), dtf);
				return localDate.compareTo(localDate2);
			}).limit(1).collect(Collectors.toList());
			//判断解冻时间与冻结时间 谁更新
			if(LocalDate.parse(collect.get(0).getJidsj(), dtf)
					.compareTo(LocalDate.parse(collect2.get(0).getDojsj(), dtf))>0) {
				//false  为冻结,true 为解冻
				return true;
			}else {
				return false;
			}
		}
		return true;
	}
	/**
	 * 更改状态  是否冻结
	 */
	@Override
	@Transactional
	public void changeState(String bipId, String str, String reason){
		zjGrqzdjbMapper.update(bipId,str);
		Bip bip= bipMapper.findState(bipId);
		String qzbh = bip.getZjGrqzdjbs().get(0).getQzbh();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String  updatetime = LocalDate.now().format(dtf);
		zjGrqzdjjdbMapper.update(qzbh,str,reason,updatetime);
	}
	/**
	 * 人员归档条件查询
	 */
	@Override
	public List<Bip> findBipByArray(String sfzhm, String xm, String cxkssj,
			String cxjssj, String sfdj){
		List<Bip> lists = bipMapper.findBipByArray(sfzhm,xm,sfdj);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		if(cxkssj != "" &&cxjssj!="" &&lists != null && lists.size()>0 &&lists.get(0).getZjGrqzdjbs()!=null) {
			List<Bip> collect = lists.stream().filter((x)->{
				String str = x.getZjGrqzdjbs().get(0).getDjsj();
				LocalDate localDate = LocalDate.parse(str, dtf);
				LocalDate localDate2 =LocalDate.parse(cxkssj, dtf);
				if(localDate.compareTo(localDate2)>=0) {
					return true;
				}else 
					return false;
			}).filter((x)->{
				String str = x.getZjGrqzdjbs().get(0).getDjsj();
				LocalDate localDate = LocalDate.parse(str, dtf);
				LocalDate localDate2 =LocalDate.parse(cxjssj, dtf);
				if(localDate.compareTo(localDate2)<=0) {
					return true;
				}else 
					return false;
			}).filter((x)->x.getZjGrqzdjbs().get(0).getGdsj().equals(""))
					.collect(Collectors.toList());
			
			return collect;
		}
		
		if(lists != null && lists.size()>0 &&lists.get(0).getZjGrqzdjbs()!=null) {
			List<Bip> collect = lists.stream().filter((x)->x.getZjGrqzdjbs().get(0).getGdsj()==null)
					.collect(Collectors.toList());
			return collect;
		}
		return lists;
	}
	/**
	 * 归档  即更新表的归档时间
	 */
	@Transactional
	@Override
	public void guidangService(String[] qzbhs){
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		String date = LocalDate.now().format(dtf);
		for(String qzbh:qzbhs) {
			Map<String,Object> map = new HashMap<>();
			map.put("qzbh", qzbh);
			map.put("gdsj", date);
			zjGrqzdjjdbMapper.upDateGuidang(map);
			zjGrqzdjbMapper.upDateGuidang(map);
			ZjGrqzgzbMapper.upDateGuidang(map);
			map = null;
		}
	}
	
}

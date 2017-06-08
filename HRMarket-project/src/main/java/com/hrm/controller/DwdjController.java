package com.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hrm.service.BioService;
import com.hrm.utils.JsonUtils;
import com.hrm.vo.Bio;
import com.imti.ldlsc.common.codetable.ComputergradeOperation;
import com.imti.ldlsc.common.codetable.EducationallevelOperation;
import com.imti.ldlsc.common.codetable.EmploytypeOperation;
import com.imti.ldlsc.common.codetable.HealthstateOperation;
import com.imti.ldlsc.common.codetable.IndustryOperation;
import com.imti.ldlsc.common.codetable.LanguageOperation;
import com.imti.ldlsc.common.codetable.MarriageOperation;
import com.imti.ldlsc.common.codetable.OrgtypeOperation;
import com.imti.ldlsc.common.codetable.PersonneltypeOperation;
import com.imti.ldlsc.common.codetable.ProficiencyOperation;
import com.imti.ldlsc.common.codetable.RegioncodeOperation;
import com.imti.ldlsc.common.codetable.RegtypeOperation;
import com.imti.ldlsc.common.codetable.RprtypeOperation;
import com.imti.ldlsc.common.codetable.SpecialtyOperation;
import com.imti.ldlsc.common.codetable.ZjdgwlbOperation;
/**
 * 
 * @author yx
 * dwdj_2的controller
 *
 */
@Controller
@RequestMapping("/service/zj/dwzp")
public class DwdjController {
	
	@Autowired
	private BioService bioService;
	JsonUtils utils=new JsonUtils();
	
	//获取codetable信息
	@GetMapping(value="/dwdj_1.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String staticResources(String code,String province,String city){
		if("dwxz".equals(code)){
			System.out.println(OrgtypeOperation.getOption());
			return OrgtypeOperation.getOption();
		}else if("dwjjlx".equals(code)){
			return RegtypeOperation.getOption();
		}else if("dwhy".equals(code)){
			return IndustryOperation.getOption();
		}else if("dwszs".equals(code)){
			return RegioncodeOperation.getProvince();
		}else if("dwszq".equals(code)){
			return RegioncodeOperation.getSelectedRegion(province, "city");
		}else if("dwszj".equals(code)){
			return RegioncodeOperation.getSelectedRegion(city, "village");
		}else if("whcd".equals(code)){
			return EducationallevelOperation.getOption();
		}else if("ygxs".equals(code)){
			return EmploytypeOperation.getOption();
		}else if("hyzk".equals(code)){
			return MarriageOperation.getOption();
		}else if("jkzk".equals(code)){
			return HealthstateOperation.getOption();
		}else if("rylb".equals(code)){
			return PersonneltypeOperation.getOption();
		}else if("zpdq".equals(code)){
			return RegioncodeOperation.getOption();
		}else if("jsjdj".equals(code)){
			return ComputergradeOperation.getOption();
		}else if("jsjslcd".equals(code)){
			return ProficiencyOperation.getOption();
		}else if("jyyz".equals(code)){
			return LanguageOperation.getOption();
		}else if("yzslcd".equals(code)){
			return ProficiencyOperation.getOption();
		}else if("gwlb".equals(code)){
			return ZjdgwlbOperation.getOption();
		}else if("hjxz".equals(code)){
			return RprtypeOperation.getOption();
		}else if("zpgz".equals(code)){
			return SpecialtyOperation.getOption();
		}else{
			return "<option></option>";
		}
	}
	
	
	
	//单位（用户）已存在是否显示该单位，做回显
	@GetMapping(value="dwdjInfo.do",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String showInfo(String code,String frm,String textd){
		if("blur".equals(code)){
			if(frm!=null){
				return utils.objectToJson(bioService.getbyNo(frm));
			}else{
				return null;
			}
		}else if("dwszj".equals(code)){
			if(textd!=null){
				return  RegioncodeOperation.getOption(textd);
			}else{
				return null;
			}
		}else if("dwszq".equals(code)){
			if(textd!=null){
				return  RegioncodeOperation.getSelectedRegion(textd.substring(0, 6)+"000000","city");
			}else{
				return null;
			}
		}else if("dwszs".equals(code)){
			if(textd!=null){
				return  RegioncodeOperation.getSelectedRegion(textd.substring(0, 2)+"0000000000","province");
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	//单位信息录入
	@PostMapping("dwdjInfo.do")
	public String saveInfo(String dwfrm,String dwqc,String dwjc,String dwxz,String dwjjlx,
			String dwhy,String yzbm,String czjh,String email,String dwszj,String lxdz,Model model){
		Bio bio=bioService.getbyNo(dwfrm);
		if(bio==null){
			bio=new Bio(dwfrm, dwqc, dwjc, dwxz, dwjjlx, dwhy, dwszj, yzbm, czjh, email, lxdz);
			bioService.save(bio);
		}else{
			String id=bio.getBio_id();
			bio=new Bio(dwfrm, dwqc, dwjc, dwxz, dwjjlx, dwhy, dwszj, yzbm, czjh, email, lxdz);
			bio.setBio_id(id);
			bioService.update(bio);
		}
		model.addAttribute("bio", bio);
		return "/service/zj/dwzp/dwdj_3";
	}
	
	//新增单位基本信息返回功能
	@RequestMapping("/home")
	public String home(){
		return "frames/right";
	}
}

package com.hrm.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.service.BioService;
import com.hrm.service.ZjDwzpdjbService;
import com.hrm.service.ZjDwzpgzbService;
import com.hrm.utils.JsonUtils;
import com.hrm.utils.StaticDataConfigration;
import com.hrm.vo.Bio;
import com.hrm.vo.ZjDwzpdjb;
import com.hrm.vo.ZjDwzpgzb;
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
@SessionAttributes("bio")
@RequestMapping("/service/zj/dwzp")
public class DwdjController {
	
	@Autowired
	private BioService bioService;
	@Autowired
	private ZjDwzpdjbService dwzpdjbService;
	@Autowired
	private ZjDwzpgzbService DwzpgzbService;
	JsonUtils utils=new JsonUtils();
	
	//获取codetable信息
	@GetMapping(value="/dwdj_1.do",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String staticResources(String code,String province,String city,String str){
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
		}else if("gz0".equals(code)){
			return SpecialtyOperation.getSelectedGz(str, "gz1");
		}else if("gz1".equals(code)){
			return SpecialtyOperation.getSelectedGz(str, "gz2");
		}else if("gz2".equals(code)){
			return SpecialtyOperation.getSelectedGz(str, "gz3");
		}else{
			return "<option></option>";
		}
	}
	
	
	
	//单位（用户）已存在是否显示该单位，做回显
	@GetMapping(value="/dwdjInfo.do",produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String showInfo(String code,String frm,String textd,String dwbh){
		//回显bio
		if("blur".equals(code)){
			if(frm!=null){
				return utils.objectToJson(bioService.getbyNo(frm));
			}else{
				return null;
			}
			//回显区
		}else if("dwszj".equals(code)){
			if(textd!=null){
				return  RegioncodeOperation.getOption(textd);
			}else{
				return null;
			}
			//回显市
		}else if("dwszq".equals(code)){
			if(textd!=null){
				return  RegioncodeOperation.getSelectedRegion(textd.substring(0, 6)+"000000","city");
			}else{
				return null;
			}
			//回显省
		}else if("dwszs".equals(code)){
			if(textd!=null){
				return  RegioncodeOperation.getSelectedRegion(textd.substring(0, 2)+"0000000000","province");
			}else{
				return null;
			}
		}else if("dwbh".equals(code)){
			if(dwbh!=null){
				ZjDwzpdjb dwzpdjb=dwzpdjbService.getOnebyDWBH(dwbh);
				return utils.objectToJson(dwzpdjb);
			}else{
				return null;
			}
		}else{
			return null;
		}
	}
	
	//单位信息录入
	@PostMapping("/dwdjInfo.do")
	public ModelAndView saveInfo(String dwfrm,String dwqc,String dwjc,String dwxz,String dwjjlx,
			String dwhy,String yzbm,String czjh,String email,String dwszj,String lxdz){
		Bio bio=bioService.getbyNo(dwfrm);
		String id="";
		if(bio==null){
			bio=new Bio(dwfrm, dwqc, dwjc, dwxz, dwjjlx, dwhy, dwszj, yzbm, czjh, email, lxdz);
			id=bioService.save(bio);
			bio.setBio_id(id);
		}else{
			id=bio.getBio_id();
			bio=new Bio(dwfrm, dwqc, dwjc, dwxz, dwjjlx, dwhy, dwszj, yzbm, czjh, email, lxdz);
			bio.setBio_id(id);
			bioService.update(bio);
		}
		ModelAndView modelAndView=new ModelAndView("/service/zj/dwzp/dwdj_3");
		modelAndView.addObject("bio", bio);
		return modelAndView;
	}
	
	//单位招聘信息录入
	@PostMapping("/dwzpdjInfo.do")
	public void dwzpdjinfo(String dwbh,String dwlxr,String lxrsfzhm,
			String lxrsj,String zpgz,String zpgzbm,String gwlb,String nars,
			String nvrs,String xbbx,String hjxz,String fbkssj,String fbjssj,
			String zxnl,String zdnl,String whcd,String ygxs,String zdyx,
			String zgyx,String hyzk,String jkzk,String sfyjgxbys,String rylb,
			String zpdq,String jsjdj,String jsjslcd,String jyyz,String yzslcd,
			String gzdd,String gwms,String fldy,HttpServletResponse response) throws IOException {
		String zrs="";
		if(nars!=null&&nvrs!=null){
			Integer n=Integer.valueOf(nars)+Integer.valueOf(nvrs);
			zrs=n.toString();
		}
		PrintWriter printWriter=response.getWriter();
		if(dwbh==null){
			printWriter.print("<script type=\"text/javascript\">alert(\"未获取到单位信息，请检查！\");window.location.href='/service/zj/dwzp/dwdj_2.jsp'</script>");
		}
		ZjDwzpdjb dwzpdjb=new ZjDwzpdjb(dwbh, dwlxr, lxrsfzhm, lxrsj, "0", StaticDataConfigration.getDengjiyouxiaoqi(), new Date(new java.util.Date().getTime())+"", "");
		ZjDwzpgzb dwzpgzb=new ZjDwzpgzb(zpgz, zpgzbm, gwlb, zrs, nars, nvrs, xbbx, hjxz, fbkssj, 
				fbjssj, zxnl, zdnl, whcd, ygxs, zdyx, zgyx, hyzk, jkzk, rylb, sfyjgxbys, zpdq, jyyz, yzslcd, jsjdj, 
				jsjslcd, gwms, gzdd, "0", "0", StaticDataConfigration.getDengjiyouxiaoqi()+"", new Date(new java.util.Date().getTime())+"", "");	
		if(DwzpgzbService.save(dwzpgzb, dwzpdjb)){
			printWriter.print("<script type=\"text/javascript\">alert(\"录入成功！\");window.location.href='/service/zj/dwzp/dwdj_3.jsp'</script>");
		}else{
			printWriter.print("<script type=\"text/javascript\">alert(\"录入失败！工种已存在！\");window.location.href='/service/zj/dwzp/dwdj_3.jsp'</script>");
		}
	}
	
	//新增单位基本信息返回功能
	@RequestMapping("/home")
	public String home(){
		return "frames/right";
	}
	
	//新增工种信息返回功能
	@RequestMapping("/dwdj_2")
	public ModelAndView back(@ModelAttribute Bio bio){
		bio=new Bio();
		ModelAndView modelAndView=new ModelAndView("/service/zj/dwzp/dwdj_2");
		modelAndView.addObject("bio", bio);
		return modelAndView;
	}
}

package com.hrm.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.service.JobRegistService;
import com.hrm.vo.Bip;
import com.hrm.vo.BipForeignlanguage;
import com.hrm.vo.BipSkill;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
import com.hrm.vo.model.RegistModel;
import com.imti.ldlsc.common.codetable.ComputergradeOperation;
import com.imti.ldlsc.common.codetable.Deformity;
import com.imti.ldlsc.common.codetable.EducationallevelOperation;
import com.imti.ldlsc.common.codetable.EmploytypeOperation;
import com.imti.ldlsc.common.codetable.HealthstateOperation;
import com.imti.ldlsc.common.codetable.IndustryOperation;
import com.imti.ldlsc.common.codetable.LanguageOperation;
import com.imti.ldlsc.common.codetable.MarriageOperation;
import com.imti.ldlsc.common.codetable.NationOperation;
import com.imti.ldlsc.common.codetable.OrgtypeOperation;
import com.imti.ldlsc.common.codetable.PersonneltypeOperation;
import com.imti.ldlsc.common.codetable.PoliticsaspectOperation;
import com.imti.ldlsc.common.codetable.ProficiencyOperation;
import com.imti.ldlsc.common.codetable.QualificationOperation;
import com.imti.ldlsc.common.codetable.RegioncodeOperation;
import com.imti.ldlsc.common.codetable.RegtypeOperation;
import com.imti.ldlsc.common.codetable.RprtypeOperation;
import com.imti.ldlsc.common.codetable.SexOperation;
import com.imti.ldlsc.common.codetable.SpecialtyOperation;

/**
 * 用于求职登记页面操作
 * @author 李若楠
 *
 */
//跳转页面
@Controller
@RequestMapping("/jobregist")
public class JobRegistController {
	@Autowired
	private JobRegistService jrs;
	
	@RequestMapping("/toJobRegistPage")
	public String toJobRegistPage(){
		return "service/zj/grqz/qzdj_1";
	}
	
	@RequestMapping("/save")
	@Transactional
	public String save(RegistModel registModel,Model model,String dwszj,String dwszq,String dwszs){
		String hkszd=null;
		if(dwszj==null){
			if(dwszq==null){
				hkszd=dwszs;
			}else{
				hkszd=dwszq;
			}			
		}else{
			hkszd=dwszj;
		}
		registModel.getBip().setBipHkszd(hkszd);
		jrs.save(registModel);
		return "service/zj/grqz/qzdj_1";
	}
	@RequestMapping("/qzdj_1.do")
	public void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//身份证号码
		String sfzhm=request.getParameter("bipCitizenid");

		String code = request.getParameter("code");
		if ("bipMinzu".equals(code)) {
			out.print(NationOperation.getOption());
		} else if ("bipZzmm".equals(code)) {
			out.print(PoliticsaspectOperation.getOption());
		} else if ("bipHyzk".equals(code)) {
			out.print(MarriageOperation.getOption());
		} else if ("bipHjxz".equals(code)) {
			out.print(RprtypeOperation.getOption());
		} else if ("bipRylb".equals(code)) {
			out.print(PersonneltypeOperation.getOption());
		} else if ("bipJkzk".equals(code)) {
			out.print(HealthstateOperation.getOption());
		} else if ("bipCjqk".equals(code)) {
			out.print(Deformity.getOption());
		} else if ("dwszs".equals(code)) {
			out.print(RegioncodeOperation.getProvince());
		} else if ("dwszq".equals(code)) {
			out.print(RegioncodeOperation
					.getSelectedRegion(request.getParameter("selectedId"),
							request.getParameter("region")));
		} else if ("dwszj".equals(code)) {
			out.print(RegioncodeOperation
					.getSelectedRegion(request.getParameter("selectedId"),
							request.getParameter("region")));
		} else if ("bipWhcd".equals(code)) {
			out.print(EducationallevelOperation.getOption());
		} else if ("bipPcDj".equals(code)) {
			out.print(ComputergradeOperation.getOption());
		} else if ("bipPcSlcd".equals(code)) {
			out.print(ProficiencyOperation.getOption());
		} else if ("bipSex".equals(code)) {
			// 性别
			String sex = (sfzhm).charAt(16) + "";
			String xb = (Integer.parseInt(sex) % 2 == 0 ? "2" : "1");
			out.print(SexOperation.getOption(xb));
		} else if ("bipAge".equals(code)) {
			// 年龄
			out.print(getAge(sfzhm));
		} else if ("init_jywy".equals(code)) {
			out.print(LanguageOperation.getOption());
		} else if ("init_wyslcd".equals(code)) {
			out.print(ProficiencyOperation.getOption());
		}
		// 四联菜单
		else if ("gw".equals(code)) {
			out.print(SpecialtyOperation.getHy());
		} else if ("gz1".equals(code)) {
			out.print(SpecialtyOperation.getGz(request.getParameter("str")));
		} else if ("gz2".equals(code)) {
			out.print(SpecialtyOperation.getGz(request.getParameter("str")));
		} else if ("gz3".equals(code)) {
			out.print(SpecialtyOperation.getGz(request.getParameter("str")));
		}
		//职业技能
		else if("bipSZyjn".equals(code)){
			out.print(SpecialtyOperation.getOption());
		}
		// 技术等级
		else if ("bipSJsdj".equals(code)) {
			out.print(QualificationOperation.getOption());
		}
		// 择业信息+小窗口地区编号
		else if ("dwxx".equals(code)) {
			out.print(OrgtypeOperation.getOption());
		} else if ("dwhy".equals(code)) {
			out.print(IndustryOperation.getOption());
		} else if ("dwjjlx".equals(code)) {
			out.print(RegtypeOperation.getOption());
		} else if ("gzdq".equals(code)) {
			out.print(RegioncodeOperation.getProvince());
		} else if ("gzdq_dwszq".equals(code)) {
			out.print(RegioncodeOperation
					.getSelectedRegion(request.getParameter("selectedId"),
							request.getParameter("region")));
		} else if ("gzdq_dwszj".equals(code)) {
			out.print(RegioncodeOperation
					.getSelectedRegion(request.getParameter("selectedId"),
							request.getParameter("region")));
		}else if("gz".equals(code)){
			out.print(SpecialtyOperation.getOption());
		}
		// 择业工种
		else if ("ygxs".equals(code)) {
			out.print(EmploytypeOperation.getOption());
		}
		//判断
		else if ("panduan".equals(code)) {
			String s=request.getParameter("s");
			Bip map=new Bip();
			if(s!=null){
				map =jrs.findBipInfoByBipCitizenid(s);
				if(map!=null){
					out.print("1");
				}else{
					out.print("0");
				}
			}else{
				map=null;
			}
		}
		//修改的判断
		else if ("panduan2".equals(code)) {
			String s=request.getParameter("s");
			Bip map=new Bip();
			if(s!=null){
				map=jrs.findBipInfoByBipCitizenid(s);
				if(map!=null){
					out.print("1");
				}else{
					out.print("0");
				}
			}else{
				map=null;
			}
		}
		out.flush();
		out.close();
	}

	
	@RequestMapping("/qzdj_3.do")
	public String doPost2(String bipCitizenid,Model model){
		
		Bip bip=jrs.findBipInfoByBipCitizenid(bipCitizenid);
		model.addAttribute("Sex", SexOperation.getOption((Integer.parseInt((bipCitizenid).charAt(16)+"")%2==0?"2":"1")+""));
		model.addAttribute("Age", getAge(bipCitizenid));
		model.addAttribute("Nation", NationOperation.getOption(bip.getBipMinzu()+""));		
		model.addAttribute("Politicsaspect", PoliticsaspectOperation.getOption(bip.getBipZzmm()+""));
		model.addAttribute("Marriage", MarriageOperation.getOption(bip.getBipHyzk()+""));
		model.addAttribute("Rprtype", RprtypeOperation.getOption(bip.getBipHjxz()+""));
		model.addAttribute("Personneltype", PersonneltypeOperation.getOption(bip.getBipRylb()+""));
		model.addAttribute("Healthstate", HealthstateOperation.getOption(bip.getBipJkzk()+""));
		model.addAttribute("Deformity", Deformity.getOption(bip.getBipCjqk()+""));
		model.addAttribute("Dwszs", RegioncodeOperation.getSelectedRegion(bip.getBipHkszd(),"province"));
		
		model.addAttribute("Dwszq", RegioncodeOperation.getSelectedRegion(bip.getBipHkszd(),"city"));
		model.addAttribute("Dwszj", RegioncodeOperation.getSelectedRegion(bip.getBipHkszd(),"village"));
		model.addAttribute("Educationallevel",EducationallevelOperation.getOption(bip.getBipWhcd()+""));
		String str=bip.getBipPcDj();
		model.addAttribute("Computergrade",ComputergradeOperation.getOption(str+""));
		str=bip.getBipPcSlcd();
		model.addAttribute("ComputerProficiency",ProficiencyOperation.getOption(str+""));
		List<BipForeignlanguage> list1=jrs.getBip_flById(bip.getBipId());
		if(list1!=null){
			String table="";
			for(int i=0;i<list1.size();i++){
				table+="<div><table id='jywyTable' style='word-break:break-all;width:fixed' width='100%' align='center' border='0' cellpadding='0' cellspacing='1'>" +
				"<tr class='line2' align='center'>" +
						"<td width='13%' align='right'>具有外语 </td>" +
						"<td width='15%'><input name='bip_fl_jywy' value='"+list1.get(i).getBipFlJywy()+"' type='hidden'><input name='init_jywy' size='1' value='"+LanguageOperation.getNameById(list1.get(i).getBipFlJywy())+"' readonly='readonly' style='WIDTH: 100%' type='text'></td>" +
						"<td width='13%' align='right'>熟练程度 </td>" +
						"<td width='15%'><input name='bip_fl_years' value='"+list1.get(i).getBipFlYears()+"' type='hidden'><input name='init_wyslcd' value='"+ProficiencyOperation.getNameById(list1.get(i).getBipFlYears())+"' size='1' readonly='readonly' style='WIDTH: 100%' type='text'></td>" +
						"<td width='13%' align='right'>外语说明 </td>" +
						"<td width='15%'><input name='init_wysm' value='"+list1.get(i).getBipFlWysm()+"' readonly='readonly' style='WIDTH: 100%' type='text'></td>" +
						"<td align='center'><input name='bip_fl_id' value='"+list1.get(i).getBipFlId()+"' type='hidden'></td><td width='8%' align='center'><input name='wysc1' value='删除' class='BUTTON2'  type='button'></td>" +
				"</tr></table></div>";
							
			}
			
			model.addAttribute("tab2", table);
			
		}
		List<BipSkill> list2=jrs.getbip_skillById(bip.getBipId());
		if(list2!=null){
			String table="";
			for(int i=0;i<list2.size();i++){
				table+="<table id='jywyTable' style='word-break:break-all;width:fixed' width='100%' align='center' border='0' cellpadding='0' cellspacing='1'>" +
				"<tr class='line2' align='center'>" +
						"<td width='13%' align='right'>职业技能 </td>" +
						"<td width='15%'><input name='bip_s_zyjn' value='"+list2.get(i).getBipSZyjn()+"' type='hidden'><input name='init_zyjn' size='1' value='"+SpecialtyOperation.getNameById(list2.get(i).getBipSZyjn())+"' readonly='readonly' style='WIDTH: 100%' type='text'></td>" +
						"<td width='13%' align='right'>技术等级 </td>" +
						"<td width='15%'><input name='bip_s_jsdj' value='"+list2.get(i).getBipSJsdj()+"' type='hidden'><input name='init_jsdj' value='"+QualificationOperation.getNameById(list2.get(i).getBipSJsdj())+"' size='1' readonly='readonly' style='WIDTH: 100%' type='text'></td>" +
						"<td width='13%' align='right'>从事年限 </td>" +
						"<td width='15%'><input name='bip_s_years' value='"+list2.get(i).getBipSYears()+"' readonly='readonly' style='WIDTH: 100%' type='text'></td>" +
						"<td align='center'><input name='bip_s_id' value='"+list2.get(i).getBipSId()+"' type='hidden'></td><td width='8%' align='center'><input name='jnsc1' value='删除' class='BUTTON2'  type='button'></td>" +
				"</tr></table>";				
				
			}
			model.addAttribute("tab1", table);
		}
		ZjGrqzdjb Zj_grqzdjb=jrs.getZj_grqzdjbById(bip.getBipId());
		
		model.addAttribute("Orgtype", OrgtypeOperation.getOption(Zj_grqzdjb.getDwxx()+""));
		model.addAttribute("Industry", IndustryOperation.getOption(Zj_grqzdjb.getDwhy()+""));	
		model.addAttribute("Regtype", RegtypeOperation.getOption(Zj_grqzdjb.getDwjjlx()+""));	
		model.addAttribute("Regioncode", RegioncodeOperation.getOption(Zj_grqzdjb.getGzdq()+""));	
		
		List<ZjGrqzgzb> list3=jrs.getbip_Zj_grqzgzbById(Zj_grqzdjb.getQzbh());
		if(list3!=null){
			String table="";
			for(int i=0;i<list3.size();i++){
				
				table+="<table id='"+list3.get(i).getQzgzbh()+"' width='100%' border=0 cellPadding=0 cellSpacing=1 class='tablebody' style='display:block'>" +
						"<tr class='line1' align='center'>" +
						""+
						"<td width='40'>工种</td>" +
						"<td width='110'><select class='qzgz1' name='qzgz1' size='1'style='WIDTH:100%'>" +
						"<option value='"+list3.get(i).getGz()+"' selected='selected'>"+SpecialtyOperation.getNameById(list3.get(i).getGz())+"</option>"+
						"</select><input type='hidden' name='GZ' value='"+list3.get(i).getGz()+"'/></td>" +
						"<td width='50'>用工形式</td>" +
						"<td width='80'><select name='ygxs1' size='1' style='WIDTH:100%'>" +
						EmploytypeOperation.getOption(list3.get(i).getYgxs())+
						"</select><input type='hidden' name='YGXS' value='"+list3.get(i).getYgxs()+"'/></td>" +
						"<td width='50' align='right'>月薪</td>" +
						"<td width='140'>" +
						"<div id='yx' style='display:'>" +
						"<table><tr><td>" +
						"<input name='ZDYX' type='text' value='"+list3.get(i).getZdyx()+"' style='width:40px' maxlength='6'>" +
						"至" +
						"<input name='ZGYX' type='text' value='"+list3.get(i).getZgyx()+"' style='width:40px' maxlength='6'>" +
						"元</td></tr></table>" +
						"</div>" +
						"</td>" +
						"<!---->" +
						"<td width='40'><input type='hidden' name='qzgzbh' value='"+list3.get(i).getQzgzbh()+"'></td>" +
						"<td width='40'><input type='button' name='gzsc1' value='删除' class='BUTTON2'></td>" +
						"</tr>" +
						"</table>";				
				
			}
			model.addAttribute("tab3", table);
		}
		
		model.addAttribute("bip", bip);
		model.addAttribute("Zj_grqzdjb", Zj_grqzdjb);
//request.getRequestDispatcher("qzdj_3.jsp").forward(request, response);
		return "service/zj/grqz/qzdj_3";
	}
	
	@RequestMapping("/qzdj_4.do")
	public String toPage3(Model model,RegistModel registModel,String dwszj,String dwszq,String dwszs){
				
		//String xb=(Integer.parseInt((registModel.getBip().getBipCitizenid()).charAt(16)+"")%2==0?"2":"1");//性别
		//判断下一级地域是否有值 没有则取前一个
		String hkszd=null;
		if(dwszj==null){
			if(dwszq==null){
				hkszd=dwszs;
			}else{
				hkszd=dwszq;
			}			
		}else{
			hkszd=dwszj;
		}	
		registModel.getBip().setBipHkszd(hkszd);
		jrs.updateAll(registModel);
		//model.addAttribute("flag", "保存成功");
		return "service/zj/grqz/qzdj_3";
	}
	
	@RequestMapping("/delectWy.do")
	public void delectWy(@RequestBody String code){
		jrs.delectForeignByFlId(code);
	}
	@RequestMapping("/deleteSkill.do")
	public void deleteSkill(@RequestBody String code){
		jrs.delectSkillById(code);
		
	}
	@RequestMapping("/deleteGz.do")
	public void deleteGz(@RequestBody String code){
		jrs.delectGzById(code);
		
	}
	public static int getAge(String id){
		Calendar cal1=Calendar.getInstance();
		Calendar today=Calendar.getInstance();
		
		String yyyy=id.substring(6, 10);
		String mm=id.substring(10, 12);
		String dd=id.substring(12, 14);
		
		cal1.set(Integer.parseInt(yyyy),Integer.parseInt(mm),Integer.parseInt(dd));
		return getYear(today,cal1);
		
	}
	public static int getYear(Calendar cal,Calendar cal1){
		int m=(cal.get(cal.MONTH))-(cal1.get(cal1.MONTH));
		int y=(cal.get(cal.YEAR))-(cal1.get(cal1.YEAR));
		return (y*12+m)/12;
		
	}
}

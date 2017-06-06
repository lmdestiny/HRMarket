package com.hrm.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.service.JobRegistService;
import com.hrm.vo.Bip;
import com.hrm.vo.BipSkill;
import com.hrm.vo.Bip_foreignlanguage;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
import com.hrm.vo.pojo.ForeignList;
import com.hrm.vo.pojo.GrqzgzbList;
import com.hrm.vo.pojo.SkillList;
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
/*import com.imti.ldlsc.common.dao.QzdjDaoImp;
import com.imti.ldlsc.common.vo.Bip_skill;
import com.imti.ldlsc.common.vo.ZJ_GRQZDJB;
import com.imti.ldlsc.common.vo.ZJ_GRQZGZB;
import com.imti.ldlsc.servlet.Qzdj_1Servlet;*/

/**
 * 用于求职登记页面操作
 * @author 李若楠
 *
 */
//跳转页面
@Controller
@RequestMapping("/jobregist")
public class JobRegistController {
	
	private JobRegistService jrs;
	
	@RequestMapping("/toJobRegistPage")
	public String toJobRegistPage(){
		return "service/zj/grqz/qzdj_1";
	}
	
	@RequestMapping("/save")
	public String save(Bip bip,SkillList bipskill,GrqzgzbList zjGrqzgzb,ForeignList forgign,ZjGrqzdjb gzdjb,String dwszj,String dwszq,String dwszs){
		
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
		bip.setBipSex(Integer.parseInt((bip.getBipCitizenid()).charAt(16)+"")%2==0?"2":"1");
		bip.setBipHkszd(hkszd);
		gzdjb.setDjyxq("90");
		jrs.save(bip, bipskill, zjGrqzgzb, forgign, gzdjb);
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
			Map map=new HashMap();
			if(s!=null){
				//map =jrs.getBipById(s);
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
			Map map=new HashMap();
			if(s!=null){
				//map =jrs.getBipById(s);
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
	/*@RequestMapping("/qzdj_2.do")
	public String toPage2(){
		
		return "";
	}*/
	@RequestMapping("/qzdj_3.do")
	public String toPage3(String bipCitizenid,String qzbh){
		Bip bip=(Bip) jrs.getBipById(bipCitizenid);
		//外语
		List<Bip_foreignlanguage> list1=jrs.getBip_flById(bipCitizenid);
		//技能
		List<BipSkill> list2=jrs.getbip_skillById(bipCitizenid);
		//登记表
		ZjGrqzdjb grqzdjb=jrs.getZj_grqzdjbById(bipCitizenid);
		grqzdjb.setDwxx(OrgtypeOperation.getOption(grqzdjb.getDwxx()));
		grqzdjb.setDwhy(IndustryOperation.getOption(grqzdjb.getDwhy()));	
		grqzdjb.setDwjjlx(RegtypeOperation.getOption(grqzdjb.getDwjjlx()));
		grqzdjb.setGzdq(RegioncodeOperation.getOption(grqzdjb.getGzdq()));
	
		
		List<ZjGrqzgzb> list3=jrs.getbip_Zj_grqzgzbById(qzbh);
		return "qzdj_3.jsp";
	}
	@RequestMapping("qzdj_4.do")
	public String toPage3(){
				
		/*String xb=(Integer.parseInt((sfzhm).charAt(16)+"")%2==0?"2":"1");//性别
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
		String sfdb=(request.getParameter("sfdb")!=null?"1":"0");//是否低保
		
		String sfllsf=(request.getParameter("sfllsf")!=null?"1":"0");//两劳释放
		String sftk=(request.getParameter("sftk")!=null?"1":"0");//是否特困
		String sfnzf=(request.getParameter("sfnzf")!=null?"1":"0");//农转非
		String sffytw=(request.getParameter("sffytw")!=null?"1":"0");//是否复员退伍
		String sfwfzr=(request.getParameter("sfwfzr")!=null?"1":"0");//外埠转入
		String sfczjyyhz=(request.getParameter("sfczjyyhz")!=null?"1":"0");//再就业
		String sfrhfl=(request.getParameter("sfrhfl")!=null?"1":"0");//	入户分离	
		String sfyjgxbys=(request.getParameter("sfyjgxbys")!=null?"1":"0");	//是否应届毕业生			

		//增加新的外语表(内部其实已经先删除了原先的外语表)
		List<Bip_foreignlanguage> list2=new ArrayList<Bip_foreignlanguage>();
		
		//技能
		List<Bip_skill> list3=new ArrayList<Bip_skill>();
		
		//择业
		
		String sfjsdx=(request.getParameter("sfjsdx")!=null?"1":"0");
		String sfcjpx=(request.getParameter("sfcjpx")!=null?"1":"0");
		String sfjszyzd=(request.getParameter("sfjszyzd")!=null?"1":"0");
		
		ZJ_GRQZDJB zj_grqzdjb
		
		//工种
		List<ZJ_GRQZGZB> list4=new ArrayList<ZJ_GRQZGZB>();		
		//执行修改
		dao.update(bip,list2,list3,zj_grqzdjb,list4);*/
		return "qzdj_3.do?sfzhm=";
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

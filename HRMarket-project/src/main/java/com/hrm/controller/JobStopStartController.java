package com.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hrm.service.BipService;
import com.hrm.service.ZjGrqzdjbService;
import com.hrm.service.ZjGrqzdjjdbService;
import com.hrm.utils.HRMResult;
import com.hrm.vo.Bip;
import com.hrm.vo.ZjGrqzdjjdb;

/**
 * 求职冻结解冻相关操作 controller
 * @author wangbin
 *
 */
@Controller
@RequestMapping("/jobStopStart")
public class JobStopStartController{
	@Autowired
	private BipService bipService;
	@Autowired
	private ZjGrqzdjbService zjGrqzdjbService;
	@Autowired
	private ZjGrqzdjjdbService zjGrqzdjjdbService;
	
	/**
	 * 进入到求职冻结解冻页面
	 * @return
	 */
	@RequestMapping("/tojobstartPage")
	public String framesJobRestart() {
		return "service/zj/grqz/qzdjjd_1";
	}
	/**
	 * google下不能使用
	 * @param bipName
	 * @param bipCitizenid
	 * @return
	 */
	@RequestMapping("/regist")
	@ResponseBody
	public HRMResult regist(String bipCitizenid) {
		HRMResult  hRMResult = null;
		try {
			hRMResult = bipService.findBipByBipCitizenid(bipCitizenid);
			return hRMResult;
		}catch(Exception e) {
			return HRMResult.build(400,"系统错误");
		}
	}
	
	@RequestMapping("/regist2")
	@ResponseBody
	public HRMResult regist2(String bipName) {
		HRMResult  hRMResult = null;
		try {
			hRMResult = bipService.findBipByBipName(bipName);
			return hRMResult;
		}catch(Exception e) {
			return HRMResult.build(400,"系统错误");
		}
	}
	
	@RequestMapping("/getInfo")
	public String getInfo(String bip_citizenid,Model model) {
		String  bipCitizenid = bip_citizenid;
		Bip bip = bipService.findBipInfoByBipCitizenid(bipCitizenid);
		model.addAttribute("bip",bip);
		//得到是否冻结状态 ,解冻为true,冻结为false
		if(bip.getZjGrqzdjbs()!=null &&bip.getZjGrqzdjbs().size()>0) {
			if ("1".equals(bip.getZjGrqzdjbs().get(0).getSfdj())) {
				model.addAttribute("b","冻结");
			}else{
				model.addAttribute("b","解冻");
			}
		}else {
			model.addAttribute("b","解冻");
		}
		return "service/zj/grqz/qzdjjd_2";
	}
	
	//查看详细信息
	@RequestMapping("/detailInfo/{bipCitizenid}")
	public String detailInfo(@PathVariable String bipCitizenid,Model model) {
		Bip bip = bipService.findBipInfoByBipCitizenid(bipCitizenid);
		model.addAttribute("bip",bip);
		if(bip != null &&bip.getZjGrqzdjbs()!=null &&bip.getZjGrqzdjbs().size()>0) {
			ZjGrqzdjjdb zjGrqzdjjdb =
					zjGrqzdjjdbService.getZjGrqzdjjdbByQzbh(bip.getZjGrqzdjbs().get(0).getQzbh());
			if(zjGrqzdjjdb !=null) {
				model.addAttribute("z",zjGrqzdjjdb);
			}
		}
		return "service/zj/grqz/qzdjjd_3";
	}
	//
	@RequestMapping("/save")
	public String save(String bipId,String sfdj,String djreason,String bipCitizenid,RedirectAttributes attributes) {
		String str;
		
		//更改后
		if("冻结".equals(sfdj))
			str ="2";
		else
			str ="1";
		bipService.changeState(bipId,str,djreason);
		attributes.addAttribute("bip_citizenid", bipCitizenid);
		System.out.println(bipCitizenid);
		return "redirect:getInfo";
	}
}

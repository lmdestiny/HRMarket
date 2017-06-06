package com.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.service.BipService;
import com.hrm.vo.Bip;

/**
 * 求职归档管理界面
 * @author wangbin
 *
 */
@Controller
@RequestMapping("/jobSupervise")
public final class JobSuperviseController{
	@Autowired
	private BipService bipService;
	@RequestMapping("/toJobSupervisePage")
	public String toJobSupervisePage() {
		return "service/zj/grqz/qzgd_1";
	}
	@RequestMapping("/find")
	public String toFind(String sfzhm,String xm,String cxkssj,String cxjssj,String sfdj,Model model) {
		List<Bip> bips = bipService.findBipByArray(sfzhm,xm,cxkssj,cxjssj,sfdj);
		model.addAttribute("bips", bips);
		return "service/zj/grqz/qzgd_2";
	}
	@RequestMapping("/change")
	public String change(String[] pkdata) {
		if(pkdata !=null && pkdata.length>0) {
				bipService.guidangService(pkdata);
		}
		return "redirect:toJobSupervisePage";
	}
	
}

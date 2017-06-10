package com.hrm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.service.ZjDwgdService;
import com.hrm.vo.ZjDwgd;

@Controller
@RequestMapping("/service/zj/dwzp/dwgd")
public class DwgdController {
	
	@Autowired
	ZjDwgdService dwgdservice;
	
	@RequestMapping("/gdcx.do")
	public ModelAndView gdsearch(String dwfrm,String dwqc,String djrqq,String djrqz,String sfdj){
		ModelAndView modelAndView=new ModelAndView("/service/zj/dwzp/dwgd_2");
		ZjDwgd zjDwgd=new ZjDwgd(dwfrm, dwqc, djrqq, djrqz, sfdj);
		
		modelAndView.addObject("DwInfo",dwgdservice.getAll(zjDwgd));
		return modelAndView;
	}
}

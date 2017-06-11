package com.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.ldlsc.common.codetable.LanguageOperation;


@Controller
public final class IndexController{
	
	@RequestMapping(value="/toPageIndex")
	public String toIndex() {
		return "/";
	}
	
	@RequestMapping(value="/edu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String test(String cd_id) {
		if(cd_id==null){
			return LanguageOperation.getOption();
		}else{
			System.out.println(cd_id);
			return LanguageOperation.getOption(cd_id);
		}
		
	}
	
	@RequestMapping("/test")
	public String te(){
		return "test";
	}
}

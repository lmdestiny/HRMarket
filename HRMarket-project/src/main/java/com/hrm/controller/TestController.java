package com.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.ldlsc.common.codetable.HealthstateOperation;

@Controller
public final class TestController{
	@RequestMapping(value="/edu",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String  first(String cd_id) {
		if(cd_id =="") {
			return HealthstateOperation.getOption();
		}
		return HealthstateOperation.getOption(cd_id);
	}
	
}

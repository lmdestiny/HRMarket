package com.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imti.ldlsc.common.codetable.IndustryOperation;
import com.imti.ldlsc.common.codetable.OrgtypeOperation;
import com.imti.ldlsc.common.codetable.RegioncodeOperation;
import com.imti.ldlsc.common.codetable.RegtypeOperation;

@Controller
@RequestMapping("/service/zj/dwzp")
public class DwdjController {
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
		}else{
			return "<option></option>";
		}
	}
}

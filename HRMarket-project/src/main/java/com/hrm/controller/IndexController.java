package com.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public final class IndexController{
	
	@RequestMapping(value="/toPageIndex")
	public String toIndex() {
		return "index";
	}
}

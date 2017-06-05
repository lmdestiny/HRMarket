package com.hrm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 用于iframe框架页面中的跳转
 * @author 李若楠
 * 
 *
 */
@Controller
public class PageTransferController {
	@RequestMapping("/framesleft")
	public String turnleft(String restype){
		return "frames/left";
	}
}

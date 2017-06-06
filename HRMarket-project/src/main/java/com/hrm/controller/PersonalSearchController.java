package com.hrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.service.BipService;
import com.hrm.vo.Bip;

/**
 * 个人信息查询操作
 * @since 2017/6/5
 * @author wangbin
 *
 */
@Controller
@RequestMapping("/personalSearch")
public final class PersonalSearchController{
	@Autowired 
	private BipService bipService;
	/**
	 * 进入到查询个人查询页面
	 * @return
	 */
	@RequestMapping("/topersonalSearchPage")
	public String topersonalSearchPage() {
		return "service/zj/grqz/xxcx_1";
	}
	/**
	 * 查询个人信息
	 * @return
	 */
	@RequestMapping("/search")
	public String search(Bip bip,String nl1,String nl2,String xl1,String xl2,String djrq1,String djrq2,
			String qzgw,String cxfw,Model model) {
		List<Bip> show = bipService.search(bip,nl1,nl2,xl1,xl2,djrq1,djrq2,qzgw,cxfw);
		model.addAttribute("list", show);
		if(show !=null &&show.size()>0) {
		model.addAttribute("count",show.size());
		}else {
			model.addAttribute("count",0);
		}
		return "service/zj/grqz/xxcx_2";
	}
	
	
}

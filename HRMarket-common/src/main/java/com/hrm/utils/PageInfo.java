package com.hrm.utils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class PageInfo<T> {
	
	//查询结果
	private List<T> list=new ArrayList<T>();
	//每页的记录数
	private Integer recordSize=5;
	//总记录数
	private Integer recordCount;
	
	//总记页数
	@SuppressWarnings("unused")
	private Integer pageCount;
	
	//当前页
	private Integer currentPage=1;
	
	
	//url
	private String url;


	public Integer getPageCount() {
		return this.recordCount/this.recordSize+(this.recordCount%this.recordSize==0?0:1);
	}


	
	public PageInfo() {
		super();
	}


	public PageInfo(HttpServletRequest request) {
		String current=request.getParameter("currentPage");
		
		if(current!=null){
			//赋给pageInfo
			this.setCurrentPage(Integer.valueOf(current));
		}
		
		//获得uri:			
		this.setUrl(request.getRequestURI());
		
	}


	public List<T> getList(){
		return list;
	}


	public void setList(List<T> list){
		this.list = list;
	}



	public Integer getRecordSize(){
		return recordSize;
	}



	public void setRecordSize(Integer recordSize){
		this.recordSize = recordSize;
	}



	public Integer getRecordCount(){
		return recordCount;
	}



	public void setRecordCount(Integer recordCount){
		this.recordCount = recordCount;
	}



	public Integer getCurrentPage(){
		return currentPage;
	}



	public void setCurrentPage(Integer currentPage){
		this.currentPage = currentPage;
	}



	public String getUrl(){
		return url;
	}



	public void setUrl(String url){
		this.url = url;
	}



	public void setPageCount(Integer pageCount){
		this.pageCount = pageCount;
	}
	

}

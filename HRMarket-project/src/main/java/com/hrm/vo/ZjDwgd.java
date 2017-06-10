package com.hrm.vo;

public class ZjDwgd {
	private String dwfrm=null;
	private String dwmc=null;
	private String djsjq=null;
	private String djsjz=null;
	private String sfdj=null;
	public ZjDwgd() {
		super();
	}
	public ZjDwgd(String dwfrm, String dwmc, String djsjq, String djsjz, String sfdj) {
		super();
		this.dwfrm = dwfrm;
		this.dwmc = dwmc;
		this.djsjq = djsjq;
		this.djsjz = djsjz;
		this.sfdj = sfdj;
	}
	public String getDwfrm() {
		return dwfrm;
	}
	public void setDwfrm(String dwfrm) {
		this.dwfrm = dwfrm;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDjsjq() {
		return djsjq;
	}
	public void setDjsjq(String djsjq) {
		this.djsjq = djsjq;
	}
	public String getDjsjz() {
		return djsjz;
	}
	public void setDjsjz(String djsjz) {
		this.djsjz = djsjz;
	}
	public String getSfdj() {
		return sfdj;
	}
	public void setSfdj(String sfdj) {
		this.sfdj = sfdj;
	}
	@Override
	public String toString() {
		return "ZjDwgd [dwfrm=" + dwfrm + ", dwmc=" + dwmc + ", djsjq=" + djsjq + ", djsjz=" + djsjz + ", sfdj=" + sfdj
				+ "]";
	}
	
	
	
	
}

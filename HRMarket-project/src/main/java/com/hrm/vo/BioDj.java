package com.hrm.vo;

public class BioDj {
	private String zt;//状态，归档
	private String dwmc;
	private String dwdz;
	private String lxdh;
	private String djsj;
	private String zpbh;
	
	
	public BioDj() {
		super();
	}
	public BioDj(String zt, String dwmc, String dwdz, String lxdh, String djsj, String zpbh) {
		super();
		this.zt = zt;
		this.dwmc = dwmc;
		this.dwdz = dwdz;
		this.lxdh = lxdh;
		this.djsj = djsj;
		this.zpbh = zpbh;
	}
	public String getZt() {
		return zt;
	}
	public void setZt(String zt) {
		this.zt = zt;
	}
	public String getDwmc() {
		return dwmc;
	}
	public void setDwmc(String dwmc) {
		this.dwmc = dwmc;
	}
	public String getDwdz() {
		return dwdz;
	}
	public void setDwdz(String dwdz) {
		this.dwdz = dwdz;
	}
	public String getLxdh() {
		return lxdh;
	}
	public void setLxdh(String lxdh) {
		this.lxdh = lxdh;
	}
	public String getDjsj() {
		return djsj;
	}
	public void setDjsj(String djsj) {
		this.djsj = djsj;
	}
	public String getZpbh() {
		return zpbh;
	}
	public void setZpbh(String zpbh) {
		this.zpbh = zpbh;
	}
	@Override
	public String toString() {
		return "BioDj [zt=" + zt + ", dwmc=" + dwmc + ", dwdz=" + dwdz + ", lxdh=" + lxdh + ", djsj=" + djsj + ", zpbh="
				+ zpbh + "]";
	}
	
	
	

}

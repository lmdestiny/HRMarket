package com.hrm.vo;

public class Bio {
	//单位编号dwbh
    private String bio_id;
    //单位法人码dwfrm
    private String bio_no;
    //单位全称dwqc
    private String bio_name;
    //单位简称dwjc
    private String bio_shortname;
    //单位性质dwxz
    private String bio_orgtype;
    //单位经济类型dwjjlx
    private String cdg_regtype;
    //单位行业dwhy
    private String bio_industry;
    //注册省市街zcssj
    private String bio_rga_regioncode;
    //邮政编码yzbm
    private String bio_bua_postcode;
    //传真机号czjh
    private String bio_con_fax;
    //email
    private String bio_con_mail;
    //经营地址jydz
    private String bio_bua_address;

    
    public Bio() {
		super();
	}
    
	public Bio(String bio_no, String bio_name, String bio_shortname, String bio_orgtype, String cdg_regtype,
			String bio_industry, String bio_rga_regioncode, String bio_bua_postcode, String bio_con_fax,
			String bio_con_mail, String bio_bua_address) {
		super();
		this.bio_no = bio_no;
		this.bio_name = bio_name;
		this.bio_shortname = bio_shortname;
		this.bio_orgtype = bio_orgtype;
		this.cdg_regtype = cdg_regtype;
		this.bio_industry = bio_industry;
		this.bio_rga_regioncode = bio_rga_regioncode;
		this.bio_bua_postcode = bio_bua_postcode;
		this.bio_con_fax = bio_con_fax;
		this.bio_con_mail = bio_con_mail;
		this.bio_bua_address = bio_bua_address;
	}





	public String getBio_id() {
		return bio_id;
	}



	public void setBio_id(String bio_id) {
		this.bio_id = bio_id;
	}



	public String getBio_no() {
		return bio_no;
	}



	public void setBio_no(String bio_no) {
		this.bio_no = bio_no;
	}



	public String getBio_name() {
		return bio_name;
	}



	public void setBio_name(String bio_name) {
		this.bio_name = bio_name;
	}



	public String getBio_shortname() {
		return bio_shortname;
	}



	public void setBio_shortname(String bio_shortname) {
		this.bio_shortname = bio_shortname;
	}



	public String getBio_orgtype() {
		return bio_orgtype;
	}



	public void setBio_orgtype(String bio_orgtype) {
		this.bio_orgtype = bio_orgtype;
	}



	public String getCdg_regtype() {
		return cdg_regtype;
	}



	public void setCdg_regtype(String cdg_regtype) {
		this.cdg_regtype = cdg_regtype;
	}



	public String getBio_industry() {
		return bio_industry;
	}



	public void setBio_industry(String bio_industry) {
		this.bio_industry = bio_industry;
	}



	public String getBio_rga_regioncode() {
		return bio_rga_regioncode;
	}



	public void setBio_rga_regioncode(String bio_rga_regioncode) {
		this.bio_rga_regioncode = bio_rga_regioncode;
	}



	public String getBio_bua_postcode() {
		return bio_bua_postcode;
	}



	public void setBio_bua_postcode(String bio_bua_Postcode) {
		this.bio_bua_postcode = bio_bua_Postcode;
	}



	public String getBio_con_fax() {
		return bio_con_fax;
	}



	public void setBio_con_fax(String bio_con_fax) {
		this.bio_con_fax = bio_con_fax;
	}



	public String getBio_con_mail() {
		return bio_con_mail;
	}



	public void setBio_con_mail(String bio_con_mail) {
		this.bio_con_mail = bio_con_mail;
	}



	public String getBio_bua_address() {
		return bio_bua_address;
	}



	public void setBio_bua_address(String bio_bua_address) {
		this.bio_bua_address = bio_bua_address;
	}



	@Override
	public String toString() {
		return "Bio [bio_id=" + bio_id + ", bio_no=" + bio_no + ", bio_name=" + bio_name + ", bio_shortname="
				+ bio_shortname + ", bio_orgtype=" + bio_orgtype + ", cdg_regtype=" + cdg_regtype + ", bio_industry="
				+ bio_industry + ", bio_rga_regioncode=" + bio_rga_regioncode + ", bio_bua_postcode=" + bio_bua_postcode
				+ ", bio_con_fax=" + bio_con_fax + ", bio_con_mail=" + bio_con_mail + ", bio_bua_address="
				+ bio_bua_address + "]";
	}


	
    
    
}
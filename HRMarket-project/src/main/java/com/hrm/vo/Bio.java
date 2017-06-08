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
    private String bio_bua_Postcode;
    //传真机号czjh
    private String bio_con_fax;
    //email
    private String bio_con_mail;
    //经营地址jydz
    private String bio_bua_address;

    
    public Bio() {
		super();
	}
    
    
    
	public Bio(String bioId, String bioNo, String bioName, String bioShortname, String bioOrgtype, String cdgRegtype,
			String bioIndustry, String bioRgaRegioncode, String bioBuaPostcode, String bioConFax, String bioConMail,
			String bioBuaAddress) {
		super();
		this.bio_id = bioId;
		this.bio_no = bioNo;
		this.bio_name = bioName;
		this.bio_shortname = bioShortname;
		this.bio_orgtype = bioOrgtype;
		this.cdg_regtype = cdgRegtype;
		this.bio_industry = bioIndustry;
		this.bio_rga_regioncode = bioRgaRegioncode;
		this.bio_bua_Postcode = bioBuaPostcode;
		this.bio_con_fax = bioConFax;
		this.bio_con_mail = bioConMail;
		this.bio_bua_address = bioBuaAddress;
	}



	public String getBioId() {
        return bio_id;
    }

    public void setBioId(String bioId) {
        this.bio_id = bioId == null ? null : bioId.trim();
    }

    public String getBioNo() {
        return bio_no;
    }

    public void setBioNo(String bioNo) {
        this.bio_no = bioNo == null ? null : bioNo.trim();
    }

    public String getBioName() {
        return bio_name;
    }

    public void setBioName(String bioName) {
        this.bio_name = bioName == null ? null : bioName.trim();
    }

    public String getBioShortname() {
        return bio_shortname;
    }

    public void setBioShortname(String bioShortname) {
        this.bio_shortname = bioShortname == null ? null : bioShortname.trim();
    }

    public String getBioOrgtype() {
        return bio_orgtype;
    }

    public void setBioOrgtype(String bioOrgtype) {
        this.bio_orgtype = bioOrgtype == null ? null : bioOrgtype.trim();
    }

    public String getCdgRegtype() {
        return cdg_regtype;
    }

    public void setCdgRegtype(String cdgRegtype) {
        this.cdg_regtype = cdgRegtype == null ? null : cdgRegtype.trim();
    }

    public String getBioIndustry() {
        return bio_industry;
    }

    public void setBioIndustry(String bioIndustry) {
        this.bio_industry = bioIndustry == null ? null : bioIndustry.trim();
    }

    public String getBioRgaRegioncode() {
        return bio_rga_regioncode;
    }

    public void setBioRgaRegioncode(String bioRgaRegioncode) {
        this.bio_rga_regioncode = bioRgaRegioncode == null ? null : bioRgaRegioncode.trim();
    }

    public String getBioBuaPostcode() {
        return bio_bua_Postcode;
    }

    public void setBioBuaPostcode(String bioBuaPostcode) {
        this.bio_bua_Postcode = bioBuaPostcode == null ? null : bioBuaPostcode.trim();
    }

    public String getBioConFax() {
        return bio_con_fax;
    }

    public void setBioConFax(String bioConFax) {
        this.bio_con_fax = bioConFax == null ? null : bioConFax.trim();
    }

    public String getBioConMail() {
        return bio_con_mail;
    }

    public void setBioConMail(String bioConMail) {
        this.bio_con_mail = bioConMail == null ? null : bioConMail.trim();
    }

    public String getBioBuaAddress() {
        return bio_bua_address;
    }

    public void setBioBuaAddress(String bioBuaAddress) {
        this.bio_bua_address = bioBuaAddress == null ? null : bioBuaAddress.trim();
    }



	@Override
	public String toString() {
		return "Bio [bioId=" + bio_id + ", bioNo=" + bio_no + ", bioName=" + bio_name + ", bioShortname=" + bio_shortname
				+ ", bioOrgtype=" + bio_orgtype + ", cdgRegtype=" + cdg_regtype + ", bioIndustry=" + bio_industry
				+ ", bioRgaRegioncode=" + bio_rga_regioncode + ", bioBuaPostcode=" + bio_bua_Postcode + ", bioConFax="
				+ bio_con_fax + ", bioConMail=" + bio_con_mail + ", bioBuaAddress=" + bio_bua_address + "]";
	}
    
    
    
}
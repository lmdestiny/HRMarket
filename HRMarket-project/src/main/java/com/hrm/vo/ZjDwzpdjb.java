package com.hrm.vo;

public class ZjDwzpdjb {
	//招聘编号；
    private String zpbh;
    //单位编号
    private String dwbh;
    //单位联系人
    private String dwlxr;
    //联系人身份证号码；
    private String lxrsfzhm;
    //联系人手机
    private String lxrsj;
    //
    private String sfdj;
    
    private Integer djyxq;

    private String djsj;

    private String gdsj;

    public String getZpbh() {
        return zpbh;
    }

    public void setZpbh(String zpbh) {
        this.zpbh = zpbh == null ? null : zpbh.trim();
    }

    public String getDwbh() {
        return dwbh;
    }

    public void setDwbh(String dwbh) {
        this.dwbh = dwbh == null ? null : dwbh.trim();
    }

    public String getDwlxr() {
        return dwlxr;
    }

    public void setDwlxr(String dwlxr) {
        this.dwlxr = dwlxr == null ? null : dwlxr.trim();
    }

    public String getLxrsfzhm() {
        return lxrsfzhm;
    }

    public void setLxrsfzhm(String lxrsfzhm) {
        this.lxrsfzhm = lxrsfzhm == null ? null : lxrsfzhm.trim();
    }

    public String getLxrsj() {
        return lxrsj;
    }

    public void setLxrsj(String lxrsj) {
        this.lxrsj = lxrsj == null ? null : lxrsj.trim();
    }

    public String getSfdj() {
        return sfdj;
    }

    public void setSfdj(String sfdj) {
        this.sfdj = sfdj == null ? null : sfdj.trim();
    }

    public Integer getDjyxq() {
        return djyxq;
    }

    public void setDjyxq(Integer djyxq) {
        this.djyxq = djyxq;
    }

    public String getDjsj() {
        return djsj;
    }

    public void setDjsj(String djsj) {
        this.djsj = djsj == null ? null : djsj.trim();
    }

    public String getGdsj() {
        return gdsj;
    }

    public void setGdsj(String gdsj) {
        this.gdsj = gdsj == null ? null : gdsj.trim();
    }
}
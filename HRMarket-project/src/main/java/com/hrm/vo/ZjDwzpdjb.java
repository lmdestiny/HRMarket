package com.hrm.vo;

public class ZjDwzpdjb {
	//招聘编号；
    private String zpbh;
    //单位编号
    private String dwbh;
    //单位联系人/经办人
    private String dwlxr;
    //联系人身份证号码；
    private String lxrsfzhm;
    //联系人/经办人手机
    private String lxrsj;
    //是否冻结
    private String sfdj;
    //登记有效期
    private Integer djyxq;
    //登记时间
    private String djsj;
    //归档时间
    private String gdsj;

    
    public ZjDwzpdjb() {
		super();
	}

    
	public ZjDwzpdjb(String dwlxr, String lxrsfzhm, String lxrsj, String sfdj, Integer djyxq, String djsj,
			String gdsj) {
		super();
		this.dwlxr = dwlxr;
		this.lxrsfzhm = lxrsfzhm;
		this.lxrsj = lxrsj;
		this.sfdj = sfdj;
		this.djyxq = djyxq;
		this.djsj = djsj;
		this.gdsj = gdsj;
	}


	public ZjDwzpdjb(String dwbh, String dwlxr, String lxrsfzhm, String lxrsj, String sfdj, Integer djyxq, String djsj,
			String gdsj) {
		super();
		this.dwbh = dwbh;
		this.dwlxr = dwlxr;
		this.lxrsfzhm = lxrsfzhm;
		this.lxrsj = lxrsj;
		this.sfdj = sfdj;
		this.djyxq = djyxq;
		this.djsj = djsj;
		this.gdsj = gdsj;
	}


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


	@Override
	public String toString() {
		return "ZjDwzpdjb [zpbh=" + zpbh + ", dwbh=" + dwbh + ", dwlxr=" + dwlxr + ", lxrsfzhm=" + lxrsfzhm + ", lxrsj="
				+ lxrsj + ", sfdj=" + sfdj + ", djyxq=" + djyxq + ", djsj=" + djsj + ", gdsj=" + gdsj + "]";
	}
    
}
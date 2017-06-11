package com.hrm.vo;

public class ZjDwzpgzb {
	//招聘工种编号;
    private String zpgzbh;
    //招聘编号
    private String zpbh;
    //招聘工种
    private String zpgz;
    //招聘工种别名/招聘岗位名称
    private String zpgzbm;
    //岗位类别
    private String gwlb;
    //招聘总人数
    private String zrs;
    //招聘人数男
    private String zprsn;
    //招聘人数女
    private String zprsnv;
    //性别不限
    private String xbbx;
    //户籍性质
    private String hjxz;
    //开始时间
    private String kssj;
    //截止时间
    private String jssj;
    //最小年龄
    private String zxnl;
    //最大年龄
    private String zdnl;
    //文化程度
    private String whcd;
    //用工形式
    private String ygxs;
    //最低月薪
    private String zzyx;
    //最高月薪
    private String zgyx;
	//婚姻状况
    private String hyzk;
	//健康状况
    private String jkzk;
	//人员类别
    private String rylb;
	//sf是否毕业生
    private String sfbys;
	//招聘地区
    private String zpdq;
	//具有语种
    private String jyyz;
	//熟练程度
    private String slcd;
	//计算机等级
    private String jsjdj;
	//计算机熟练程度
    private String jsjslcd;
	//岗位描述
    private String gwms;
	//工作地点
    private String gzdd;
	//成功人数男
    private String cgrsn;
	//成功人数女
    private String cgrsnv;
	//等级有效期
    private String djyxq;
	//等级时间
    private String djsj;
	//归档时间
    private String gdsj;

    
    public ZjDwzpgzb() {
		super();
	}
	public ZjDwzpgzb(String zpbh, String zpgz, String zpgzbm, String gwlb, String zrs, String zprsn, String zprsnv,
			String xbbx, String hjxz, String kssj, String jssj, String zxnl, String zdnl, String whcd, String ygxs,
			String zzyx, String zgyx, String hyzk, String jkzk, String rylb, String sfbys, String zpdq, String jyyz,
			String slcd, String jsjdj, String jsjslcd, String gwms, String gzdd, String cgrsn, String cgrsnv,
			String djyxq, String djsj, String gdsj) {
		super();
		this.zpbh = zpbh;
		this.zpgz = zpgz;
		this.zpgzbm = zpgzbm;
		this.gwlb = gwlb;
		this.zrs = zrs;
		this.zprsn = zprsn;
		this.zprsnv = zprsnv;
		this.xbbx = xbbx;
		this.hjxz = hjxz;
		this.kssj = kssj;
		this.jssj = jssj;
		this.zxnl = zxnl;
		this.zdnl = zdnl;
		this.whcd = whcd;
		this.ygxs = ygxs;
		this.zzyx = zzyx;
		this.zgyx = zgyx;
		this.hyzk = hyzk;
		this.jkzk = jkzk;
		this.rylb = rylb;
		this.sfbys = sfbys;
		this.zpdq = zpdq;
		this.jyyz = jyyz;
		this.slcd = slcd;
		this.jsjdj = jsjdj;
		this.jsjslcd = jsjslcd;
		this.gwms = gwms;
		this.gzdd = gzdd;
		this.cgrsn = cgrsn;
		this.cgrsnv = cgrsnv;
		this.djyxq = djyxq;
		this.djsj = djsj;
		this.gdsj = gdsj;
	}
	public ZjDwzpgzb(String zpgz, String zpgzbm, String gwlb, String zrs, String zprsn, String zprsnv, String xbbx,
			String hjxz, String kssj, String jssj, String zxnl, String zdnl, String whcd, String ygxs, String zzyx,
			String zgyx, String hyzk, String jkzk, String rylb, String sfbys, String zpdq, String jyyz, String slcd,
			String jsjdj, String jsjslcd, String gwms, String gzdd, String cgrsn, String cgrsnv, String djyxq,
			String djsj, String gdsj) {
		super();
		this.zpgz = zpgz;
		this.zpgzbm = zpgzbm;
		this.gwlb = gwlb;
		this.zrs = zrs;
		this.zprsn = zprsn;
		this.zprsnv = zprsnv;
		this.xbbx = xbbx;
		this.hjxz = hjxz;
		this.kssj = kssj;
		this.jssj = jssj;
		this.zxnl = zxnl;
		this.zdnl = zdnl;
		this.whcd = whcd;
		this.ygxs = ygxs;
		this.zzyx = zzyx;
		this.zgyx = zgyx;
		this.hyzk = hyzk;
		this.jkzk = jkzk;
		this.rylb = rylb;
		this.sfbys = sfbys;
		this.zpdq = zpdq;
		this.jyyz = jyyz;
		this.slcd = slcd;
		this.jsjdj = jsjdj;
		this.jsjslcd = jsjslcd;
		this.gwms = gwms;
		this.gzdd = gzdd;
		this.cgrsn = cgrsn;
		this.cgrsnv = cgrsnv;
		this.djyxq = djyxq;
		this.djsj = djsj;
		this.gdsj = gdsj;
	}



	public String getZpgzbh() {
        return zpgzbh;
    }

    public void setZpgzbh(String zpgzbh) {
        this.zpgzbh = zpgzbh == null ? null : zpgzbh.trim();
    }

    public String getZpbh() {
        return zpbh;
    }

    public void setZpbh(String zpbh) {
        this.zpbh = zpbh == null ? null : zpbh.trim();
    }

    public String getZpgz() {
        return zpgz;
    }

    public void setZpgz(String zpgz) {
        this.zpgz = zpgz == null ? null : zpgz.trim();
    }

    public String getZpgzbm() {
        return zpgzbm;
    }

    public void setZpgzbm(String zpgzbm) {
        this.zpgzbm = zpgzbm == null ? null : zpgzbm.trim();
    }

    public String getGwlb() {
        return gwlb;
    }

    public void setGwlb(String gwlb) {
        this.gwlb = gwlb == null ? null : gwlb.trim();
    }

    public String getZrs() {
        return zrs;
    }

    public void setZrs(String zrs) {
        this.zrs = zrs == null ? null : zrs.trim();
    }

    public String getZprsn() {
        return zprsn;
    }

    public void setZprsn(String zprsn) {
        this.zprsn = zprsn == null ? null : zprsn.trim();
    }

    public String getZprsnv() {
        return zprsnv;
    }

    public void setZprsnv(String zprsnv) {
        this.zprsnv = zprsnv == null ? null : zprsnv.trim();
    }

    public String getXbbx() {
        return xbbx;
    }

    public void setXbbx(String xbbx) {
        this.xbbx = xbbx == null ? null : xbbx.trim();
    }

    public String getHjxz() {
        return hjxz;
    }

    public void setHjxz(String hjxz) {
        this.hjxz = hjxz == null ? null : hjxz.trim();
    }

    public String getKssj() {
        return kssj;
    }

    public void setKssj(String kssj) {
        this.kssj = kssj == null ? null : kssj.trim();
    }

    public String getJssj() {
        return jssj;
    }

    public void setJssj(String jssj) {
        this.jssj = jssj == null ? null : jssj.trim();
    }

    public String getZxnl() {
        return zxnl;
    }

    public void setZxnl(String zxnl) {
        this.zxnl = zxnl == null ? null : zxnl.trim();
    }

    public String getZdnl() {
        return zdnl;
    }

    public void setZdnl(String zdnl) {
        this.zdnl = zdnl == null ? null : zdnl.trim();
    }

    public String getWhcd() {
        return whcd;
    }

    public void setWhcd(String whcd) {
        this.whcd = whcd == null ? null : whcd.trim();
    }

    public String getYgxs() {
        return ygxs;
    }

    public void setYgxs(String ygxs) {
        this.ygxs = ygxs == null ? null : ygxs.trim();
    }

    public String getZzyx() {
        return zzyx;
    }

    public void setZzyx(String zzyx) {
        this.zzyx = zzyx == null ? null : zzyx.trim();
    }

    public String getZgyx() {
        return zgyx;
    }

    public void setZgyx(String zgyx) {
        this.zgyx = zgyx == null ? null : zgyx.trim();
    }

    public String getHyzk() {
        return hyzk;
    }

    public void setHyzk(String hyzk) {
        this.hyzk = hyzk == null ? null : hyzk.trim();
    }

    public String getJkzk() {
        return jkzk;
    }

    public void setJkzk(String jkzk) {
        this.jkzk = jkzk == null ? null : jkzk.trim();
    }

    public String getRylb() {
        return rylb;
    }

    public void setRylb(String rylb) {
        this.rylb = rylb == null ? null : rylb.trim();
    }

    public String getSfbys() {
        return sfbys;
    }

    public void setSfbys(String sfbys) {
        this.sfbys = sfbys == null ? null : sfbys.trim();
    }

    public String getZpdq() {
        return zpdq;
    }

    public void setZpdq(String zpdq) {
        this.zpdq = zpdq == null ? null : zpdq.trim();
    }

    public String getJyyz() {
        return jyyz;
    }

    public void setJyyz(String jyyz) {
        this.jyyz = jyyz == null ? null : jyyz.trim();
    }

    public String getSlcd() {
        return slcd;
    }

    public void setSlcd(String slcd) {
        this.slcd = slcd == null ? null : slcd.trim();
    }

    public String getJsjdj() {
        return jsjdj;
    }

    public void setJsjdj(String jsjdj) {
        this.jsjdj = jsjdj == null ? null : jsjdj.trim();
    }

    public String getJsjslcd() {
        return jsjslcd;
    }

    public void setJsjslcd(String jsjslcd) {
        this.jsjslcd = jsjslcd == null ? null : jsjslcd.trim();
    }

    public String getGwms() {
        return gwms;
    }

    public void setGwms(String gwms) {
        this.gwms = gwms == null ? null : gwms.trim();
    }

    public String getGzdd() {
        return gzdd;
    }

    public void setGzdd(String gzdd) {
        this.gzdd = gzdd == null ? null : gzdd.trim();
    }

    public String getCgrsn() {
        return cgrsn;
    }

    public void setCgrsn(String cgrsn) {
        this.cgrsn = cgrsn == null ? null : cgrsn.trim();
    }

    public String getCgrsnv() {
        return cgrsnv;
    }

    public void setCgrsnv(String cgrsnv) {
        this.cgrsnv = cgrsnv == null ? null : cgrsnv.trim();
    }

    public String getDjyxq() {
        return djyxq;
    }

    public void setDjyxq(String djyxq) {
        this.djyxq = djyxq == null ? null : djyxq.trim();
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
		return "ZjDwzpgzb [zpgzbh=" + zpgzbh + ", zpbh=" + zpbh + ", zpgz=" + zpgz + ", zpgzbm=" + zpgzbm + ", gwlb="
				+ gwlb + ", zrs=" + zrs + ", zprsn=" + zprsn + ", zprsnv=" + zprsnv + ", xbbx=" + xbbx + ", hjxz="
				+ hjxz + ", kssj=" + kssj + ", jssj=" + jssj + ", zxnl=" + zxnl + ", zdnl=" + zdnl + ", whcd=" + whcd
				+ ", ygxs=" + ygxs + ", zzyx=" + zzyx + ", zgyx=" + zgyx + ", hyzk=" + hyzk + ", jkzk=" + jkzk
				+ ", rylb=" + rylb + ", sfbys=" + sfbys + ", zpdq=" + zpdq + ", jyyz=" + jyyz + ", slcd=" + slcd
				+ ", jsjdj=" + jsjdj + ", jsjslcd=" + jsjslcd + ", gwms=" + gwms + ", gzdd=" + gzdd + ", cgrsn=" + cgrsn
				+ ", cgrsnv=" + cgrsnv + ", djyxq=" + djyxq + ", djsj=" + djsj + ", gdsj=" + gdsj + "]";
	}
    
    
}
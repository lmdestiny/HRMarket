package com.hrm.vo;
/**
 * 单位冻结解冻表
 * @author qst
 *
 */
public class ZjDwdjjdb {
	//单位冻结解冻编号
    private String dwdjjdbh;
    //招聘编号
    private String zpbh;
	//冻结原因
    private String djyy;
	//冻结时间
    private String djsj;
	//解冻原因
    private String jdyy;
	//解冻时间
    private String jdsj;
	//归档时间
    private String gdsj;

    public String getDwdjjdbh() {
        return dwdjjdbh;
    }

    public void setDwdjjdbh(String dwdjjdbh) {
        this.dwdjjdbh = dwdjjdbh == null ? null : dwdjjdbh.trim();
    }

    public String getZpbh() {
        return zpbh;
    }

    public void setZpbh(String zpbh) {
        this.zpbh = zpbh == null ? null : zpbh.trim();
    }

    public String getDjyy() {
        return djyy;
    }

    public void setDjyy(String djyy) {
        this.djyy = djyy == null ? null : djyy.trim();
    }

    public String getDjsj() {
        return djsj;
    }

    public void setDjsj(String djsj) {
        this.djsj = djsj == null ? null : djsj.trim();
    }

    public String getJdyy() {
        return jdyy;
    }

    public void setJdyy(String jdyy) {
        this.jdyy = jdyy == null ? null : jdyy.trim();
    }

    public String getJdsj() {
        return jdsj;
    }

    public void setJdsj(String jdsj) {
        this.jdsj = jdsj == null ? null : jdsj.trim();
    }

    public String getGdsj() {
        return gdsj;
    }

    public void setGdsj(String gdsj) {
        this.gdsj = gdsj == null ? null : gdsj.trim();
    }
}
package com.hrm.vo.model;

import java.util.ArrayList;
import java.util.List;

import com.hrm.vo.Bip;
import com.hrm.vo.BipForeignlanguage;
import com.hrm.vo.BipSkill;
import com.hrm.vo.ZjGrqzdjb;
import com.hrm.vo.ZjGrqzgzb;
/**
 * 用于用户注册的业务逻辑对象
 * @author wangbin
 *
 */
public class RegistModel{
	private Bip bip;
	private ZjGrqzdjb zjGrqzdjb;
	private List<ZjGrqzgzb> zjGrqzgzbs =new ArrayList<>();
	private List<BipForeignlanguage> bipForeignlanguags = new ArrayList<>();
	private List<BipSkill> bipSkills = new ArrayList<>();

	

	public Bip getBip(){
		return bip;
	}

	public void setBip(Bip bip){
		this.bip = bip;
	}

	public ZjGrqzdjb getZjGrqzdjb(){
		return zjGrqzdjb;
	}

	public void setZjGrqzdjb(ZjGrqzdjb zjGrqzdjb){
		this.zjGrqzdjb = zjGrqzdjb;
	}

	public List<ZjGrqzgzb> getZjGrqzgzbs(){
		return zjGrqzgzbs;
	}

	public void setZjGrqzgzbs(List<ZjGrqzgzb> zjGrqzgzbs){
		this.zjGrqzgzbs = zjGrqzgzbs;
	}

	public List<BipForeignlanguage> getBipForeignlanguags(){
		return bipForeignlanguags;
	}

	public void setBipForeignlanguags(List<BipForeignlanguage> bipForeignlanguags){
		this.bipForeignlanguags = bipForeignlanguags;
	}

	public List<BipSkill> getBipSkills(){
		return bipSkills;
	}

	public void setBipSkills(List<BipSkill> bipSkills){
		this.bipSkills = bipSkills;
	}

	@Override
	public String toString(){
		return "RegistModel [bip=" + bip + ", zjGrqzdjb=" + zjGrqzdjb
				+ ", zjGrqzgzbs=" + zjGrqzgzbs + ", bipForeignlanguags="
				+ bipForeignlanguags + ", bipSkills=" + bipSkills + "]";
	}

}

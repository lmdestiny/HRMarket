package com.hrm.vo;

public class Bip_foreignlanguage {
	private String	bip_fl_id	;
	private String	bip_id	;
	private String	bip_fl_years	;
	private String	bip_fl_jywy	;
	private String	bip_fl_wysm	;
	
	public Bip_foreignlanguage(String bipFlYears, String bipFlJywy,
			String bipFlWysm) {
		super();
		bip_fl_years = bipFlYears;
		bip_fl_jywy = bipFlJywy;
		bip_fl_wysm = bipFlWysm;
	}
	public Bip_foreignlanguage(String bipFlId, String bipId, String bipFlYears,
			String bipFlJywy, String bipFlWysm) {
		super();
		bip_fl_id = bipFlId;
		bip_id = bipId;
		bip_fl_years = bipFlYears;
		bip_fl_jywy = bipFlJywy;
		bip_fl_wysm = bipFlWysm;
	}
	public String getBip_fl_id() {
		return bip_fl_id;
	}
	public void setBip_fl_id(String bipFlId) {
		bip_fl_id = bipFlId;
	}
	public String getBip_id() {
		return bip_id;
	}
	public void setBip_id(String bipId) {
		bip_id = bipId;
	}
	public String getBip_fl_years() {
		return bip_fl_years;
	}
	public void setBip_fl_years(String bipFlYears) {
		bip_fl_years = bipFlYears;
	}
	public String getBip_fl_jywy() {
		return bip_fl_jywy;
	}
	public void setBip_fl_jywy(String bipFlJywy) {
		bip_fl_jywy = bipFlJywy;
	}
	public String getBip_fl_wysm() {
		return bip_fl_wysm;
	}
	public void setBip_fl_wysm(String bipFlWysm) {
		bip_fl_wysm = bipFlWysm;
	}
			
	
}

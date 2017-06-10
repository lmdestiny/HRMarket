package com.hrm.vo;

public class BipForeignlanguage {
	private String	bipFlId;
	private String	bipId;
	private String	bipFlYears;
	private String	bipFlJywy;
	private String	bipFlWysm;
	public String getBipFlId() {
		return bipFlId;
	}
	public void setBipFlId(String bipFlId) {
		this.bipFlId = bipFlId;
	}
	public String getBipId() {
		return bipId;
	}
	public void setBipId(String bipId) {
		this.bipId = bipId;
	}
	public String getBipFlYears() {
		return bipFlYears;
	}
	public void setBipFlYears(String bipFlYears) {
		this.bipFlYears = bipFlYears;
	}
	public String getBipFlJywy() {
		return bipFlJywy;
	}
	public void setBipFlJywy(String bipFlJywy) {
		this.bipFlJywy = bipFlJywy;
	}
	public String getBipFlWysm() {
		return bipFlWysm;
	}
	public void setBipFlWysm(String bipFlWysm) {
		this.bipFlWysm = bipFlWysm;
	}
	@Override
	public String toString() {
		return "BipForeignlanguage [bipFlId=" + bipFlId + ", bipId=" + bipId + ", bipFlYears=" + bipFlYears
				+ ", bipFlJywy=" + bipFlJywy + ", bipFlWysm=" + bipFlWysm + "]";
	}
	
	
}

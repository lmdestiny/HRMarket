package com.hrm.utils;

public class StaticDataConfigration {
	private static int dengjiyouxiaoqi=30;

	public static int getDengjiyouxiaoqi() {
		return dengjiyouxiaoqi;
	}

	public static void setDengjiyouxiaoqi(int dengjiyouxiaoqi) {
		StaticDataConfigration.dengjiyouxiaoqi = dengjiyouxiaoqi;
	}
}

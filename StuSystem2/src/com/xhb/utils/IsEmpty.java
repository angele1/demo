package com.xhb.utils;

public class IsEmpty {
	public static boolean IsEmpty(String str) {
		if("".equals(str)||str==null) {
			return true;
		}
		return false;
	}
	
	public static boolean notEmpty(String str) {
		if(!"".equals(str.trim())&&str!=null) {
			return true;
		}
		return false;
	}
}

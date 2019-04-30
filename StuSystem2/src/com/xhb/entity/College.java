package com.xhb.entity;

public class College {
	private String college_id;
	private String college_name;
	private String major;
	private String classes;
	
	public College() {
		super();
		// TODO Auto-generated constructor stub
	}
	public College(String college_id, String college_name, String major, String classes) {
		super();
		this.college_id = college_id;
		this.college_name = college_name;
		this.major = major;
		this.classes = classes;
	}
	public String getCollege_id() {
		return college_id;
	}
	public void setCollege_id(String college_id) {
		this.college_id = college_id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	@Override
	public String toString() {
		return "College [college_id=" + college_id + ", college_name=" + college_name + ", major=" + major
				+ ", classes=" + classes + "]";
	}
	
	
	
}

package com.xhb.entity;

public class Grade {
	private String stu_id;
	private String stu_name;
	private String course_name;
	private String grade;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String stu_id, String stu_name, String course_name, String grade) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.course_name = course_name;
		this.grade = grade;
	}
	public String getStu_id() {
		return stu_id;
	}
	public void setStu_id(String stu_id) {
		this.stu_id = stu_id;
	}
	public String getStu_name() {
		return stu_name;
	}
	public void setStu_name(String stu_name) {
		this.stu_name = stu_name;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grade [stu_id=" + stu_id + ", stu_name=" + stu_name + ", course_name=" + course_name + ", grade="
				+ grade + "]";
	}
	
	
}

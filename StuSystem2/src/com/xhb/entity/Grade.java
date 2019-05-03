package com.xhb.entity;

public class Grade {
	private String stu_id;
	private String stu_name;
	private String course_name;
	private String grade;
	private String course_id;
	private String exam;
	public Grade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Grade(String stu_id, String stu_name, String course_name, String grade,String course_id,String exam) {
		super();
		this.stu_id = stu_id;
		this.stu_name = stu_name;
		this.course_name = course_name;
		this.grade = grade;
		this.course_id = course_id;
		this.exam = exam;
	}
	public String getExam() {
		return exam;
	}
	public void setExam(String exam) {
		this.exam = exam;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
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
				+ grade + ", course_id=" + course_id + ", exam=" + exam + "]";
	}
	

	
	
}

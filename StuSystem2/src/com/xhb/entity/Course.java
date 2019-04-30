package com.xhb.entity;

public class Course {
	private String course_id;
	private String course_name;
	private String course_te;
	
	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Course(String course_id, String course_name, String course_te) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_te = course_te;
	}
	public String getCourse_id() {
		return course_id;
	}
	public void setCourse_id(String course_id) {
		this.course_id = course_id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_te() {
		return course_te;
	}
	public void setCourse_te(String course_te) {
		this.course_te = course_te;
	}
	@Override
	public String toString() {
		return "Course [course_id=" + course_id + ", course_name=" + course_name + ", course_te=" + course_te + "]";
	}
	
	
}

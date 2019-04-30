package com.xhb.entity;

public class Notice {
	private Integer notice_id;
	private String notice_content;
	private String notice_permission;
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Notice( String notice_content, String notice_permission) {
		super();
		//this.notice_id = notice_id;
		this.notice_content = notice_content;
		this.notice_permission = notice_permission;
	}
	public Integer getNotice_id() {
		return notice_id;
	}
	public void setNotice_id(Integer notice_id) {
		this.notice_id = notice_id;
	}
	public String getNotice_content() {
		return notice_content;
	}
	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}
	public String getNotice_permission() {
		return notice_permission;
	}
	public void setNotice_permission(String notice_permission) {
		this.notice_permission = notice_permission;
	}
	@Override
	public String toString() {
		return "Notice [notice_id=" + notice_id + ", notice_content=" + notice_content + ", notice_permission="
				+ notice_permission + "]";
	}
	
	
}

package com.xhb.entity;

public class User {
	private String id;
	private String password;
	private String real_name;
	private String sex;
	private String birthday;
	private String college;
	private String major;
	private String classes;
	private String phone;
	private String permission;
	private String contact;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String user, String password, String real_name, String sex, String birthday, String college,
			String major, String classes, String phone, String permission, String contact) {
		super();
		this.id = user;
		this.password = password;
		this.real_name = real_name;
		this.sex = sex;
		this.birthday = birthday;
		this.college = college;
		this.major = major;
		this.classes = classes;
		this.phone = phone;
		this.permission = permission;
		this.contact = contact;
	}
	public String getId() {
		return id;
	}
	public void setId(String user) {
		this.id = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getReal_name() {
		return real_name;
	}
	public void setReal_name(String real_name) {
		this.real_name = real_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	@Override
	public String toString() {
		return "User [user=" + id + ", password=" + password + ", real_name=" + real_name + ", sex=" + sex
				+ ", birthday=" + birthday + ", college=" + college + ", major=" + major + ", classes=" + classes
				+ ", phone=" + phone + ", permission=" + permission + ", contact=" + contact + "]";
	}
	
	
}

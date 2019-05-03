package com.xhb.entity;

public class TestQuestion {
	private String questionText;
	private String standardKey;
	private String selectKey;
	public TestQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestQuestion(String questionText, String standardKey) {
		super();
		this.questionText = questionText;
		this.standardKey = standardKey;
	}
	public String getQuestionText() {
		return questionText;
	}
	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}
	public String getStandardKey() {
		return standardKey;
	}
	public void setStandardKey(String standardKey) {
		this.standardKey = standardKey;
	}
	public String getSelectKey() {
		return selectKey;
	}
	public void setSelectKey(String selectKey) {
		this.selectKey = selectKey;
	}
	
	public boolean check() {
		if(this.selectKey.equals(this.standardKey)) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "TestQuestion [questionText=" + questionText + ", standardKey=" + standardKey + ", selectKey="
				+ selectKey + "]";
	}
	
	
}

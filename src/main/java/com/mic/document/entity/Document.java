package com.mic.document.entity;

public class Document {
	
	private String href;
	private String title;
	private String summary;
	
	public Document(String href, String title, String summary) {
		super();
		this.title = title;
		this.summary = summary;
		this.href = href;
	}
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}




}

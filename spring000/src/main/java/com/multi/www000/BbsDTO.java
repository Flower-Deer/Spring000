package com.multi.www000;

public class BbsDTO {
	private String id;
	private String title;
	private String content;
	private String apple;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getApple() {
		return apple;
	}
	public void setApple(String apple) {
		this.apple = apple;
	}
	
	@Override
	public String toString() {
		return "BbsDTO [id=" + id + ", title=" + title + ", content=" + content + ", apple=" + apple + "]";
	}
	
}

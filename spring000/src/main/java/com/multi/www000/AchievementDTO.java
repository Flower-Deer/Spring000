package com.multi.www000;

public class AchievementDTO {
	private int id;
	private String classes;
	private String name;
	private String grade;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClasses() {
		return classes;
	}
	public void setClasses(String classes) {
		this.classes = classes;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "AchievementDTO [id=" + id + ", classes=" + classes + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
}

package com.fx.hmwac.domain;

import java.util.Date;

public class DataLoadBean {
	private String id;
	private String flodName;
    private int num;
    private String path;
    private String author;
    private Date saveTime;
	public String getFlodName() {
		return flodName;
	}
	public void setFlodName(String flodName) {
		this.flodName = flodName;
	}
	public int getNum() {
		return num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Date getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
	@Override
	public String toString() {
		return "DataLoadBean [id=" + id + ", flodName=" + flodName + ", num=" + num + ", path="
				+ path + ", author=" + author + ", saveTime=" + saveTime + "]";
	}
	
}

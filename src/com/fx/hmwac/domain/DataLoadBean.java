package com.fx.hmwac.domain;

import java.util.Date;
import java.util.List;

public class DataLoadBean {
	private String id;
	private String flodName;
    private List<PictureDetail> files;
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
	public List<PictureDetail> getFiles() {
		return files;
	}
	public void setFiles(List<PictureDetail> files) {
		this.files = files;
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
		return "DataLoadBean [id=" + id + ", flodName=" + flodName + ", files=" + files + ", num=" + num + ", path="
				+ path + ", author=" + author + ", saveTime=" + saveTime + "]";
	}
	
}

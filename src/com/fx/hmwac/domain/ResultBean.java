package com.fx.hmwac.domain;

import java.util.Date;

public class ResultBean {
	private String id;
	private String dataId;
	private String dataName;
	private int goodNum;
	private int badNum;
	private String imgPath;
	private String xmlPath;
	private String detectorPath;
	private String author;
	private Date saveTime;
	private int status;
	private String modelName;
	private String modelId;
	
	public ResultBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ResultBean(String id, String dataId, String dataName, int goodNum, int badNum, String imgPath,
			String xmlPath, String detectorPath, String author, Date saveTime, String modelName, String modelId) {
		super();
		this.id = id;
		this.dataId = dataId;
		this.dataName = dataName;
		this.goodNum = goodNum;
		this.badNum = badNum;
		this.imgPath = imgPath;
		this.xmlPath = xmlPath;
		this.detectorPath = detectorPath;
		this.author = author;
		this.saveTime = saveTime;
		this.modelName = modelName;
		this.modelId = modelId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public int getBadNum() {
		return badNum;
	}
	public void setBadNum(int badNum) {
		this.badNum = badNum;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getXmlPath() {
		return xmlPath;
	}
	public void setXmlPath(String xmlPath) {
		this.xmlPath = xmlPath;
	}
	public String getDetectorPath() {
		return detectorPath;
	}
	public void setDetectorPath(String detectorPath) {
		this.detectorPath = detectorPath;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	@Override
	public String toString() {
		return "ResultBean [id=" + id + ", dataId=" + dataId + ", dataName=" + dataName + ", goodNum=" + goodNum
				+ ", badNum=" + badNum + ", imgPath=" + imgPath + ", xmlPath=" + xmlPath + ", detectorPath="
				+ detectorPath + ", author=" + author + ", saveTime=" + saveTime + ", status=" + status + ", modelName="
				+ modelName + ", modelId=" + modelId + "]";
	}
	
	
}

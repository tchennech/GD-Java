package com.fx.hmwac.domain;

import java.util.List;

public class PredictResultBean {
	private String id;
	private String detectorPath;
	private String resultPath;
	private List<SingleResultBean> pictures;
	private int badNum = 0;
	private int goodNum = 0;
	public int getBadNum() {
		return badNum;
	}
	public void setBadNum(int badNum) {
		this.badNum = badNum;
	}
	public int getGoodNum() {
		return goodNum;
	}
	public void setGoodNum(int goodNum) {
		this.goodNum = goodNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDetectorPath() {
		return detectorPath;
	}
	public void setDetectorPath(String detectorPath) {
		this.detectorPath = detectorPath;
	}
	public String getResultPath() {
		return resultPath;
	}
	public void setResultPath(String resultPath) {
		this.resultPath = resultPath;
	}
	
	public List<SingleResultBean> getPictures() {
		return pictures;
	}
	public void setPictures(List<SingleResultBean> pictures) {
		this.pictures = pictures;
		this.goodNum=0;
		this.badNum=0;
		for(SingleResultBean pic : pictures) {
			this.goodNum+=pic.getGoodNum();
			this.badNum+=pic.getBadNum();
		}
	}
	@Override
	public String toString() {
		return "PredictResultBean [id=" + id + ", detectorPath=" + detectorPath + ", resultPath=" + resultPath
				+ ", pictures=" + pictures + ", badNum=" + badNum + ", goodNum=" + goodNum + "]";
	}
	
}

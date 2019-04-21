package com.fx.hmwac.domain;

import java.util.List;

public class PredictResultBean {
	private String id;
	private String detectorPath;
	private String resultPath;
	private List<SingleResultBean> pictures;
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
	}
	@Override
	public String toString() {
		return "PredictResultBean [id=" + id + ", detectorPath=" + detectorPath + ", resultPath=" + resultPath
				+ ", pictures=" + pictures + "]";
	}
	
}

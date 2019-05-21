package com.fx.hmwac.domain;

import java.util.Date;

public class ModelBean {
	private String id;
	private String name;
	private String dataId;
    private String author;
    private String dataName;
    private Date saveTime;
    private double trainAccuracy;
    private double testAccuracy;
    private double trainLoss;
    private double testLoss;
    private String path;
    private int totalEpochs;
	public String getId() {
		return id;
	}
	public Date getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}
	
	public String getDataName() {
		return dataName;
	}
	public void setDataName(String dataName) {
		this.dataName = dataName;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getTrainAccuracy() {
		return trainAccuracy;
	}
	public void setTrainAccuracy(double trainAccuracy) {
		this.trainAccuracy = trainAccuracy;
	}
	public double getTestAccuracy() {
		return testAccuracy;
	}
	public void setTestAccuracy(double testAccuracy) {
		this.testAccuracy = testAccuracy;
	}
	public double getTrainLoss() {
		return trainLoss;
	}
	public void setTrainLoss(double trainLoss) {
		this.trainLoss = trainLoss;
	}
	public double getTestLoss() {
		return testLoss;
	}
	public void setTestLoss(int testLoss) {
		this.testLoss = testLoss;
	}
	public int getTotalEpochs() {
		return totalEpochs;
	}
	public void setTotalEpochs(int totalEpochs) {
		this.totalEpochs = totalEpochs;
	}
	@Override
	public String toString() {
		return "ModelBean [id=" + id + ", name=" + name + ", dataId=" + dataId + ", author=" + author + ", saveTime="
				+ saveTime + ", dataName=" + dataName + ", trainAccuracy=" + trainAccuracy + ", testAccuracy="
				+ testAccuracy + ", trainLoss=" + trainLoss + ", testLoss=" + testLoss + ", path=" + path
				+ ", totalEpochs=" + totalEpochs + "]";
	}
    
}

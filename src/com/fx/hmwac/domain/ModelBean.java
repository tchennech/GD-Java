package com.fx.hmwac.domain;

import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ModelBean {
	private String id;
	private String name;
	private String dataId;
    private String author;
    private String saveTime;
    private String dataName;
    private int trainAccuracy;
    private int testAccuracy;
    private int trainLoss;
    private int testLoss;
    private int totalEpochs;
	public String getId() {
		return id;
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
	public int getTrainAccuracy() {
		return trainAccuracy;
	}
	public void setTrainAccuracy(int trainAccuracy) {
		this.trainAccuracy = trainAccuracy;
	}
	public int getTestAccuracy() {
		return testAccuracy;
	}
	public void setTestAccuracy(int testAccuracy) {
		this.testAccuracy = testAccuracy;
	}
	public int getTrainLoss() {
		return trainLoss;
	}
	public void setTrainLoss(int trainLoss) {
		this.trainLoss = trainLoss;
	}
	public int getTestLoss() {
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
		return "TrainModelBean [id=" + id + ", name=" + name + ", dataId=" + dataId + ", author=" + author
				+ ", trainAccuracy=" + trainAccuracy + ", testAccuracy=" + testAccuracy + ", trainLoss=" + trainLoss
				+ ", testLoss=" + testLoss + ", totalEpochs=" + totalEpochs + "]";
	}
    
}

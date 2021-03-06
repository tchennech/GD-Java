package com.fx.hmwac.domain;

public class TrainModelBean {

	private String id;
	private String name;
    private int imgSize1;
    private int imgSize2;
    private String author;
    private double learnRate;
    private int batchSize;
    private int totalEpochs;
    private double weightDecay;
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
	public int getImgSize1() {
		return imgSize1;
	}
	public void setImgSize1(int imgSize1) {
		this.imgSize1 = imgSize1;
	}
	public int getImgSize2() {
		return imgSize2;
	}
	public void setImgSize2(int imgSize2) {
		this.imgSize2 = imgSize2;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public double getLearnRate() {
		return learnRate;
	}
	public void setLearnRate(double learnRate) {
		this.learnRate = learnRate;
	}
	public int getBatchSize() {
		return batchSize;
	}
	public void setBatchSize(int batchSize) {
		this.batchSize = batchSize;
	}
	public int getTotalEpochs() {
		return totalEpochs;
	}
	public void setTotalEpochs(int totalEpochs) {
		this.totalEpochs = totalEpochs;
	}
	public double getWeightDecay() {
		return weightDecay;
	}
	public void setWeightDecay(double weightDecay) {
		this.weightDecay = weightDecay;
	}
	@Override
	public String toString() {
		return "TrainModelBean [id=" + id + ", name=" + name + ", imgSize1=" + imgSize1 + ", imgSize2=" + imgSize2
				+ ", author=" + author + ", learnRate=" + learnRate + ", batchSize=" + batchSize + ", totalEpochs="
				+ totalEpochs + ", weightDecay=" + weightDecay + "]";
	}
	
    
}

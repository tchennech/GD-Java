package com.fx.hmwac.domain;

import java.util.Arrays;

public class SingleResultBean {
	private String name;
	private int[] typeNum = {0, 0, 0, 0, 0, 0, 0, 0};
	private int num;
	private int badNum = 0;
	private int goodNum = 0;
	public SingleResultBean(String name, int[] typeNum, int num) {
		super();
		this.name = name;
		this.typeNum = typeNum;
		this.num = num;
		for(int i=0; i<4; i++) {
			goodNum += typeNum[i];
		}
		badNum = num-goodNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int[] getTypeNum() {
		return typeNum;
	}
	public void setTypeNum(int[] typeNum) {
		this.typeNum = typeNum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "SingleResultBean [name=" + name + ", typeNum=" + Arrays.toString(typeNum) + ", num=" + num + "]";
	}
	
	
}

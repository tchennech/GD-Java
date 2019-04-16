package com.fx.hmwac.domain;

public class PredictBean {
	private String modelId;
	private String dataId;
	public String getModelId() {
		return modelId;
	}
	public void setModelId(String modelId) {
		this.modelId = modelId;
	}
	public String getDataId() {
		return dataId;
	}
	public void setDataId(String dataId) {
		this.dataId = dataId;
	}
	@Override
	public String toString() {
		return "PredictBean [modelId=" + modelId + ", dataId=" + dataId + "]";
	}   
}

package com.fx.hmwac.domain;

public class PictureDetail {
	private String name;
    private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "PictureDetail [name=" + name + ", url=" + url + "]";
	}
}

package com.wangting.cms.entity;

/**
 * @author wangting
 * @time 2019年10月29日
 */
public class Slide {

	private int id;
	private String title;
	private String picture;
	private String url;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Slide [id=" + id + ", title=" + title + ", picture=" + picture + ", url=" + url + "]";
	}
	
	
	
}

package com.smartcity.bean;

public class VideoModel {
	private int image;
	private String introduce;
	private int img;
	private String title;
	private int number;

	public VideoModel(int image, String introduce, int img, String title, int number) {
		this.image = image;
		this.introduce = introduce;
		this.img = img;
		this.title = title;
		this.number = number;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public int getImg() {
		return img;
	}

	public void setImg(int img) {
		this.img = img;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}
}

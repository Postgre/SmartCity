package com.smartcity.bean;

public class CircleFragment_Model {

	private int imageView;
	private String name;
	private String text;
	private String id;
	private String people;
	private String number;
	private int num;
	private int  nums;
	private int kan;
	private int zan;
	private int miao;
	private int vip;
	private String title,introduce,date;
	public CircleFragment_Model(int imageView) {
		// TODO Auto-generated constructor stub
		this.imageView = imageView;
	}
	
	public CircleFragment_Model(int imageView, String name,int vip) {
		super();
		this.imageView = imageView;
		this.name = name;
		this.vip = vip;
	}
	public CircleFragment_Model(int imageView,int zan,String name) {
		// TODO Auto-generated constructor stub
		this.imageView = imageView;
		this.zan = zan;
		this.name = name;
	}
	public CircleFragment_Model(int imageView, String name,String text,int vip,int num) {
		// TODO Auto-generated constructor stub
		this.imageView = imageView;
		this.name = name;
		this.text = text;
		this.vip = vip;
		this.num = num;
	}
	public CircleFragment_Model(int imageView, String name,int vip, String id, String people,String number) {
		super();
		this.imageView = imageView;
		this.name = name;
		this.vip = vip;
		this.id = id;
		this.number = number;
		this.people = people;
	}
	public CircleFragment_Model(int imageView, int zan,String name, String title, String time) {
		super();
		this.imageView = imageView;
		this.name = name;
		this.zan = zan;
		this.title = title;
		this.people = time;
	}
	public CircleFragment_Model(int imageView, String name, int num, int nums,int kan,
			int zan,int miao) {
		super();
		this.imageView = imageView;
		this.name = name;
		this.num = num;
		this.nums = nums;
		this.kan = kan;
		this.zan = zan;
		this.miao = miao;
	}
	public CircleFragment_Model(int imageView,String date, String name, int num, int nums,int kan,
			int zan,int miao) {
		super();
		this.imageView = imageView;
		this.date = date;
		this.name = name;
		this.num = num;
		this.nums = nums;
		this.kan = kan;
		this.zan = zan;
		this.miao = miao;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public CircleFragment_Model(int imageView, int vip, String title,String introduce,
	String name,int num, int nums,int kan,int zan,int miao) {
		super();
		this.imageView = imageView;
		this.vip = vip;
		this.title = title;
		this.introduce = introduce;
		this.name = name;
		this.num = num;
		this.nums = nums;
		this.kan = kan;
		this.zan = zan;
		this.miao = miao;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public int getKan() {
		return kan;
	}
	public void setKan(int kan) {
		this.kan = kan;
	}
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getZan() {
		return zan;
	}
	public void setZan(int zan) {
		this.zan = zan;
	}
	public int getMiao() {
		return miao;
	}
	public void setMiao(int miao) {
		this.miao = miao;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public int getNums() {
		return nums;
	}
	public void setNums(int nums) {
		this.nums = nums;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getImageView() {
		return imageView;
	}

	public void setImageView(int imageView) {
		this.imageView = imageView;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}
}

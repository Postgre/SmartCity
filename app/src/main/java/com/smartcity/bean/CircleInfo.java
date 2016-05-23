package com.smartcity.bean;

public class CircleInfo{
	private String groupid;

	private String id;

	private String leaderid;

	private String qun;

	private String usernum;

	public CircleInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CircleInfo(String groupid, String id, String leaderid, String qun,
			String usernum) {
		super();
		this.groupid = groupid;
		this.id = id;
		this.leaderid = leaderid;
		this.qun = qun;
		this.usernum = usernum;
	}

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLeaderid() {
		return leaderid;
	}

	public void setLeaderid(String leaderid) {
		this.leaderid = leaderid;
	}

	public String getQun() {
		return qun;
	}

	public void setQun(String qun) {
		this.qun = qun;
	}

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}
	
	
	
}

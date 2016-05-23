package com.smartcity.bean;

public class CircleListInfo {
	private String addusername;

	private CircleInfo classs ;

	private String companyinfo;

	private String grouplog;

	private String groupname;

	private String grouptype;

	private String id;

	private int ingroup;

	private String playnum;

	private String usernum;

	public CircleListInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAddusername() {
		return addusername;
	}

	public void setAddusername(String addusername) {
		this.addusername = addusername;
	}

	public CircleInfo getCircle() {
		return classs;
	}

	public void setCircle(CircleInfo classs) {
		this.classs = classs;
	}

	public String getCompanyinfo() {
		return companyinfo;
	}

	public void setCompanyinfo(String companyinfo) {
		this.companyinfo = companyinfo;
	}

	public String getGrouplog() {
		return grouplog;
	}

	public void setGrouplog(String grouplog) {
		this.grouplog = grouplog;
	}

	public String getGroupname() {
		return groupname;
	}

	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}

	public String getGrouptype() {
		return grouptype;
	}

	public void setGrouptype(String grouptype) {
		this.grouptype = grouptype;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getIngroup() {
		return ingroup;
	}

	public void setIngroup(int ingroup) {
		this.ingroup = ingroup;
	}

	public String getPlaynum() {
		return playnum;
	}

	public void setPlaynum(String playnum) {
		this.playnum = playnum;
	}

	public String getUsernum() {
		return usernum;
	}

	public void setUsernum(String usernum) {
		this.usernum = usernum;
	}

	public CircleListInfo(String addusername, CircleInfo classs,
			String companyinfo, String grouplog, String groupname,
			String grouptype, String id, int ingroup, String playnum,
			String usernum) {
		super();
		this.addusername = addusername;
		this.classs = classs;
		this.companyinfo = companyinfo;
		this.grouplog = grouplog;
		this.groupname = groupname;
		this.grouptype = grouptype;
		this.id = id;
		this.ingroup = ingroup;
		this.playnum = playnum;
		this.usernum = usernum;
	}
	
	
	
}

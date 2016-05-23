package com.smartcity.http.model;

import java.io.Serializable;
import java.util.List;

public class CityModel implements Serializable{
	private String name;
	private String cityId;
	private List<DistrictModel> districtList;

	public CityModel(String name, String cityId, List<DistrictModel> districtList) {
		this.name = name;
		this.cityId = cityId;
		this.districtList = districtList;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

	public void setDistrictList(List<DistrictModel> districtList) {
		this.districtList = districtList;
	}

	public CityModel() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getCityId() {
		return cityId;
	}

	public List<DistrictModel> getDistrictList() {
		return districtList;
	}

	@Override
	public String toString() {
		return "CityModel [name=" + name + ", districtList=" + districtList
				+ "]";
	}
	
}

package org.TechHub.Model;

public class CityModel {
	int cityid;
	public int getCityid() {
		return cityid;
	}
	public void setCityid(int cityid) {
		this.cityid = cityid;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	String cityname;
	public CityModel()
	{
		
	}
	public CityModel(int cityid,String cityname)
	{
		this.cityid=cityid;
		this.cityname=cityname;
	}

}

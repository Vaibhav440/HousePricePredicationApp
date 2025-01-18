package org.TechHub.Model;

public class DistModel {
	private int distId;
	public int getDistId() {
		return distId;
	}
	public void setDistId(int distId) {
		this.distId = distId;
	}
	public String getDistName() {
		return distName;
	}
	public void setDistName(String distName) {
		this.distName = distName;
	}
	private String distName;
	
	public DistModel(int distId,String distName)
	{
		this.distId=distId;
		this.distName=distName;
	}
}

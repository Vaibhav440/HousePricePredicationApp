package org.TechHub.Model;

public class wardModel {
  int wardid;
  String wardname;
	public int getWardid() {
		return wardid;
	}
	public void setWardid(int wardid) {
		this.wardid = wardid;
	}
	public String getWardname() {
		return wardname;
	}
	public void setWardname(String wardname) {
		this.wardname = wardname;
	}
	
	public wardModel()
	{
		
	}
	public wardModel(int wardid,String wardname)
	{
		this.wardid=wardid;
		this.wardname=wardname;
	}
  
}

package org.TechHub.Model;

public class AminitiesModel
{
   int amid;
   public int getAmid() {
	return amid;
}
public void setAmid(int amid) {
	this.amid = amid;
}
public String getAminitiesname() {
	return aminitiesname;
}
public void setAminitiesname(String aminitiesname) {
	this.aminitiesname = aminitiesname;
}
String aminitiesname;
   public AminitiesModel()
   {
	   
   }
   public AminitiesModel(int amid,String aminitiesname)
   {
	   this.amid=amid;
	   this.aminitiesname=aminitiesname;
   }
	
}

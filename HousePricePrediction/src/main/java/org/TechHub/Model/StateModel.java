package org.TechHub.Model;

public class StateModel
{
	  private int stateid;
	  private String stateName;
	  public int getStateid() 
	  {
		return stateid;
	  }
	  public void setStateid(int stateid) 
	  {
		this.stateid = stateid;
	  }
	  public String getStateName() 
	  {
		return stateName;
	  }
	  public void setStateName(String stateName) 
	  {
		this.stateName = stateName;
	
	  }
	  public String toString() {
	        return "State Name: " + stateName;
	    }
	  public StateModel()
	  {
		  
	  }
	  public StateModel(int id,String name)
	  {
		  this.stateid=id;
		  this.stateName=name;
		  
	  }
}

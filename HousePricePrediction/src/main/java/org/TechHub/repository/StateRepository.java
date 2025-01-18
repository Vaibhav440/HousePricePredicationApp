package org.TechHub.repository;

import java.util.List;
import java.util.Optional;

import org.TechHub.Model.AminitiesModel;
import org.TechHub.Model.CityModel;
import org.TechHub.Model.DistModel;
import org.TechHub.Model.PropertyModel;
import org.TechHub.Model.StateModel;
import org.TechHub.Model.wardModel;

public interface StateRepository {

	public boolean isAddNewState(StateModel model);
	public Optional<List<StateModel>> viewAllState();
	public StateModel getStateByName(String StateName1);
	public boolean isDeleteStateByName(String StateName2);
	public boolean isUpdateStateByName(String  StateName3);
	public boolean isAssociateDistTpState(String statename,String Distname);
	public List<DistModel> viewAllDist(String statename);
	public boolean isDeleteDistByName(String DistName);
	public boolean isUpdateDistByName(String DistName,String NewDistName);
	public boolean isAddNewCityUnderDistState(String statename,String distname,String cityname);
	public List<CityModel> viewAllCityassociateToDist(String distname);
	public boolean isDeletecityByName(String cityname);
	public boolean isUpdatedcityByName(String cityname,String newcityname);
	public boolean AddNewWard(String cityname,String wardname,int pincode);
	List<wardModel> viewAllWards(String cityname);
	public boolean isDeleteWardByName(String wardname);
	public boolean isUpdateWardByName(String wardname,String newwardname);
	public boolean isAddNewaminitie(AminitiesModel model);
	public boolean isAddNewProperty(PropertyModel model,String wardname,String aminityname,int aaprice);
}

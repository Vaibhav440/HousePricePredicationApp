package org.TechHub.service;

import java.util.List;
import java.util.Optional;

import org.TechHub.Model.AminitiesModel;
import org.TechHub.Model.CityModel;
import org.TechHub.Model.DistModel;
import org.TechHub.Model.PropertyModel;
import org.TechHub.Model.StateModel;
import org.TechHub.Model.wardModel;
import org.TechHub.repository.StateRepository;
import org.TechHub.repository.StateRepositoryImpl;

public class StateServImpl  implements StateService{
	
	StateRepository stRepo = new StateRepositoryImpl();


	public boolean isAddNewState(StateModel model) {
		return stRepo.isAddNewState(model);
	}

	public Optional<List<StateModel>> viewAllState() {

		return stRepo.viewAllState();
	}

	@Override
	public StateModel getStateByName(String StateName1) {

		return stRepo.getStateByName(StateName1);
	}

	@Override
	public boolean isDeleteStateByName(String StateName2) {

		return stRepo.isDeleteStateByName(StateName2);
	}

	@Override
	public boolean isUpdateStateByName(String StateName3) {

		return stRepo.isUpdateStateByName(StateName3);
	}

	@Override
	public boolean isAssociateDistTpState(String statename, String Distname) {

		return stRepo.isAssociateDistTpState(statename, Distname);
	}


	@Override
	public List<DistModel> viewAllDist(String statename) {
		
		return stRepo.viewAllDist(statename);
	}

	@Override
	public boolean isDeleteDistByName(String DistName) {
		
		return stRepo.isDeleteDistByName(DistName);
	}

	@Override
	public boolean isUpdateDistByName(String DistName,String NewDistName) {
		return stRepo.isUpdateDistByName(DistName,NewDistName);
	}

	@Override
	public boolean isAddNewCityUnderDistState(String statename, String distname, String cityname) {
		return stRepo.isAddNewCityUnderDistState(statename, distname, cityname);
	}

	@Override
	public List<CityModel> viewAllCityassociateToDist(String distname) {
		
		return stRepo.viewAllCityassociateToDist(distname);
	}

	@Override
	public boolean isDeletecityByName(String cityname) {
		
		return stRepo.isDeletecityByName(cityname);
	}

	@Override
	public boolean isUpdatedcityByName(String cityname,String newcityname) {
		return stRepo.isUpdatedcityByName(cityname,newcityname);
	}

	@Override
	public boolean AddNewWard(String cityname, String wardname,int pincode) {
		
		return stRepo.AddNewWard(cityname, wardname,pincode);
	}

	@Override
	public List<wardModel> viewAllWards(String cityname) {
		
		return stRepo.viewAllWards(cityname);
	}

	@Override
	public boolean isDeleteWardByName(String wardname) {
		return stRepo.isDeleteWardByName(wardname);
	}

	@Override
	public boolean isUpdateWardByName(String wardname,String newwardname) {
		return stRepo.isUpdateWardByName(wardname, newwardname);
		
	}

	@Override
	public boolean isAddNewaminitie(AminitiesModel model) {
		return stRepo.isAddNewaminitie(model);
	}

	@Override
	public boolean isAddNewProperty(PropertyModel model,String wardname,String aminityname,int aaprice) {
		return stRepo.isAddNewProperty(model, wardname,aminityname,aaprice);
	}

}

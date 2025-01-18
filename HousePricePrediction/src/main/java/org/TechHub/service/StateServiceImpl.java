package org.TechHub.service;

import java.util.List;
import java.util.Optional;

import org.TechHub.Model.DistModel;
import org.TechHub.Model.StateModel;
import org.TechHub.repository.StateRepository;
import org.TechHub.repository.StateRepositoryImpl;

public class StateServiceImpl implements StateService {

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
		// TODO Auto-generated method stub
		return null;
	}

	

}

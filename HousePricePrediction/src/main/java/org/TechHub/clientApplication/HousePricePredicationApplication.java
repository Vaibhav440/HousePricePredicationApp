package org.TechHub.clientApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.TechHub.Model.AminitiesModel;
import org.TechHub.Model.CityModel;
import org.TechHub.Model.DistModel;
import org.TechHub.Model.PropertyModel;
import org.TechHub.Model.StateModel;
import org.TechHub.Model.wardModel;
import org.TechHub.service.StateServImpl;
import org.TechHub.service.StateService;



public class HousePricePredicationApplication {

	public static void main(String[] args) {
		
		StateService stateService=new StateServImpl();
		
		do
		{
			Scanner xyz=new Scanner(System.in);
			System.out.println("1:Add New State");
			System.out.println("2.View All States");
			System.out.println("3:Enter State Name");
			System.out.println("4:Delete state by Name");
			System.out.println("5:Update state by Name");
			System.out.println("6:Enter New Dist");
			System.out.println("7:View All Dist Associate to Dist");
			System.out.println("8:Delete Dist by Name");
			System.out.println("9:Update Dist By Name");
			System.out.println("10:Enter new city");
			System.out.println("11:View All cities associate by dist");
			System.out.println("12:delete city by name");
			System.out.println("13:Update city by name");
			System.out.println("14:Enter new ward");
			System.out.println("15:View All wards assiciated with city");
			System.out.println("16:delete ward by name");
			System.out.println("17:update ward by name");
			System.out.println("18.Insert aminities");
			System.out.println("19:Enter property");
			System.out.println("Enter Your Choice");
			int choice=xyz.nextInt();
			
			switch(choice)
			{
		     	case 1:
		     		 System.out.println("Enter Name Of State:");
		     		 xyz.nextLine();
		     		 String stateName=xyz.nextLine();
		     		 StateModel model=new StateModel(0,stateName);
		     		 boolean b=stateService.isAddNewState(model);
		     		 if(b)
		     		 {
		     			 System.out.println("New State Added !");
		     		 }
		     		 else {
						System.out.println("No new State Added");
					}
		     	    
		     		break;
		     	case 2:
		     		Optional<List<StateModel>> o =stateService.viewAllState();
		     		if(o.isPresent())
		     		{
		     			o.get().forEach((state)->System.out.println(state.getStateid()+"\t"+state.getStateName()));
		     		}
		     		else {
						System.out.println("There is no date present in state table");
					}
		     		break;
		     	
		     	case 3:
		     		System.out.println("Enter state name");
		     		xyz.nextLine();
		     		String stateName1=xyz.nextLine();
		     		StateModel model2=stateService.getStateByName(stateName1);
		     		if(model2!=null)
		     		{
		     			System.out.println(model2.getStateid()+"\t"+model2.getStateName());
		     		}
		     		else {
						System.out.println("State not found!");
					}
		     		break;
		     	
		     	case 4:
		     		System.out.println("Enter state name");
		     		xyz.nextLine();
		     		String stateName2=xyz.nextLine();
		     		boolean b1=stateService.isDeleteStateByName(stateName2);
		     		if(b1)
		     		{
		     		System.out.println("State Deleted !");
		     		}
		     		else {
						System.out.println("No");
					}
		     		
		     		break;
		     		
		     	case 5:
		     		System.out.println("Enter state name");
		     		xyz.nextLine();
		     		String stateName3=xyz.nextLine();
		     		boolean b2=stateService.isUpdateStateByName(stateName3);
		     		if(b2)
		     		{
		     		System.out.println("State Name Updated");
		     		}
		     		else {
						System.out.println("No");
					}
		     		
		     		break;
		     	case 6:
		     		System.out.println("Enter state name");
		     		xyz.nextLine();
		     		String stateName4=xyz.nextLine();
		     		System.out.println("Enter distname");
		     		String distname=xyz.nextLine();
		     		b=stateService.isAssociateDistTpState(stateName4, distname);
		     		if(b)
		     		{
		     			System.out.println("Dist Added under state");
		     		}
		     		else {
						System.out.println("There is some error");
					}
		     		
		     		break;
		     		
		     	case 7:
		     		System.out.println("Enter state name");
		     		xyz.nextLine();
		     		String statename5=xyz.nextLine();
		     		List<DistModel> viewAllDist=stateService.viewAllDist(statename5);
		     		if(viewAllDist!=null)
		     		{
		     			for(DistModel a:viewAllDist)
		     			{
		     				System.out.println(a.getDistId()+"\t"+a.getDistName());
		     			}
		     		}
		     		break;
		     	case 8:
		     		System.out.println("Enter the Dist Name");
		     		xyz.nextLine();
		     		String distname1=xyz.nextLine();
		     		boolean b3=stateService.isDeleteDistByName(distname1);
		     		if(b3)
		     		{
		     			System.out.println("Dist Deleted!");
		     		}
		     		else {
						System.out.println("Dist Not Deleted!");
					}
		     		break;
		     	case 9:
		     		System.out.println("Enter the Dist Name");
		     		xyz.nextLine();
		     		String distname2=xyz.nextLine();
		     		System.out.println("Enter updated name");
		     		String distname3=xyz.nextLine();
		     		boolean b4=stateService.isUpdateDistByName(distname2,distname3);
		     		if(b4)
		     		{
		     			System.out.println("Dist Updated!");
		     		}
		     		else {
						System.out.println("Dist Not Updated!");
					}
		     		break;
		     	case 10:
		     		System.out.println("Enter state");
		     		xyz.nextLine();
		     		String statename6=xyz.nextLine();
		     		System.out.println("Enter Dist");
		     		String distname4=xyz.nextLine();
		     		System.out.println("Enter city name");
		     		String cityname=xyz.nextLine();
		     		
		     		boolean b5=stateService.isAddNewCityUnderDistState(statename6, distname4, cityname);
		     		if(b5)
		     		{
		     			System.out.println("City Added");
		     		}
		     		else {
						System.out.println("City Not added");
					}
		     	case 11:
		     		System.out.println("Enter Dist name to find associate citys");
		     		xyz.nextLine();
		     		String distname6=xyz.nextLine();
		     		List<CityModel> viewAllCityModels=stateService.viewAllCityassociateToDist(distname6);
		     		if(viewAllCityModels!=null)
		     		{
		     			for(CityModel x:viewAllCityModels)
		     			{
		     				System.out.println(x.getCityid()+"\t"+x.getCityname());
		     			}
		     		}
		     		break;
		     		
		     	case 12:
		     		System.out.println("Enter name of city to delete");
		     		xyz.nextLine();
		     		String cityname1=xyz.nextLine();
		     		boolean b6=stateService.isDeletecityByName(cityname1);
		     		if(b6)
		     		{
		     			System.out.println("City deleted");
		     		}
		     		else {
						System.out.println("City Not deleted!");
					}
		     		break;
		     		
		     	case 13:
		     		System.out.println("Enter name of city to update");
		     		xyz.nextLine();
		     		String cityname2=xyz.nextLine();
		     		System.out.println("Enter new name");
		     		String cityname3=xyz.nextLine();
		     		boolean b7=stateService.isUpdatedcityByName(cityname2,cityname3);
		     		if(b7)
		     		{
		     			System.out.println("City updated");
		     		}
		     		else {
						System.out.println("City Not updated!");
					}
		     		break;
		     	case 14:
		     		System.out.println("Enter name of city");
		     		xyz.nextLine();
		     		String cityname4=xyz.nextLine();
		     		System.out.println("Enter ward name");
		     		String wardname=xyz.nextLine();
		     		System.out.println("Enter pin code");
		     		int pincode=xyz.nextInt();
		     		boolean b8=stateService.AddNewWard(cityname4,wardname,pincode);
		     		if(b8)
		     		{
		     			System.out.println("Ward Added");
		     		}
		     		else {
						System.out.println("Ward not added");
					}
		     		break;
		     	case 15:
		     		System.out.println("Enter name of city");
		     		xyz.nextLine();
		     		String cityname5=xyz.nextLine();
		     		List<wardModel> vieward=stateService.viewAllWards(cityname5);
		     		if(vieward!=null)
		     		{
		     			for(wardModel x:vieward)
		     			{
		     				System.out.println(x.getWardid()+"\t"+x.getWardname());
		     			}
		     		}
		     		else {
						System.out.println("There is some problem");
					}
		     		break;
		     	case 16:
		     		System.out.println("Enter name of ward");
		     		xyz.nextLine();
		     		String wardname1=xyz.nextLine();
		     		boolean b9=stateService.isDeleteWardByName(wardname1);
		     		if(b9)
		     		{
		     			System.out.println("ward deleted");
		     		}
		     		else {
						System.out.println("There is some probelm");
					}
		     		break;
		     	case 17:
		     		System.out.println("Enter name of ward");
		     		xyz.nextLine();
		     		String wardname2=xyz.nextLine();
		     		System.out.println("Enter new ward name of ward");
		     		String wardname3=xyz.nextLine();
		     		boolean b10=stateService.isUpdateWardByName(wardname2,wardname3);
		     		if(b10)
		     		{
		     			System.out.println("ward updated");
		     		}
		     		else {
						System.out.println("There is some probelm");
					}
		     		break;
		     	default:
		     		System.out.println("Enter correct choice");
		     		
		     	case 18:
		     		 System.out.println("Insert Aminity name");
		     		 xyz.nextLine();
		     		 String aminityname=xyz.nextLine();
		     		 AminitiesModel model1=new AminitiesModel(0,aminityname);
		     		 boolean b11=stateService.isAddNewaminitie(model1);
		     		 if(b11)
		     		 {
		     			 System.out.println("Aminities added");
		     		 }
		     		 else {
						System.out.println("Aminities not added");
					}
		     		 break;
		     		 
		     	case 19:
		     		  System.out.println("Enter the wardname");
		     		  xyz.nextLine();
		     		  String wardname4=xyz.nextLine();
		     		  System.out.println("Enter the amities name");
		     		  String aminityname1=xyz.nextLine();
		     		  System.out.println("Entre the amitie price");
		     		  int aaprice=xyz.nextInt();
		     		  System.out.println("Enter the name of property");
		     		  xyz.nextLine();
		     		  String propname=xyz.nextLine();
		     		  System.out.println("Enter the address of prop");
		     		  String address=xyz.nextLine();
		     		  System.out.println("Enter the price of Prop");
		     		  int pprice=xyz.nextInt();
		     		  System.out.println("Enter the area of property");
		     		  int area=xyz.nextInt();
		     		  PropertyModel model3=new PropertyModel('0',propname,address,pprice,area);
		     		  
		     		  boolean b13=stateService.isAddNewProperty(model3, wardname4, aminityname1, aaprice);
		     		  if(b13)
		     		  {
		     			  System.out.println("Property added");
		     		  }
		     		  else {
						System.out.println("Not added");
					}
		     		  break;
		     		  
		     		  
		     		
			}
			
			
		}while(true);

	}

}

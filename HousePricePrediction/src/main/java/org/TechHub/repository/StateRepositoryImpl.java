package org.TechHub.repository;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import javax.xml.stream.util.EventReaderDelegate;

import org.TechHub.Model.AminitiesModel;
import org.TechHub.Model.CityModel;
import org.TechHub.Model.DistModel;
import org.TechHub.Model.PropertyModel;
import org.TechHub.Model.StateModel;
import org.TechHub.Model.wardModel;

import com.google.protobuf.Value;
import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class StateRepositoryImpl extends DBSTATE  implements StateRepository{

	List<StateModel> viewList=new ArrayList<StateModel>();
	List<DistModel> viewDistModels=new ArrayList<DistModel>();
	List<CityModel> viewAllCity=new ArrayList<CityModel>(); 
	List<wardModel>viewWard=new ArrayList<wardModel>();
	public boolean isAddNewState(StateModel model) 
	{
		try 
		{
			
		stmt=conn.prepareStatement("insert into statemaster values('0',?)");
		stmt.setString(1,model.getStateName());
		int value=stmt.executeUpdate();
		return (value>0)?true:null;
		}
		catch (Exception e) 
		{
			System.out.println("Exception is"+e);
			return false;
		}
		
	}

	
	public Optional<List<StateModel>> viewAllState() 
	{
		try 
		{
		   stmt=conn.prepareStatement("select * from statemaster");
		   rs=stmt.executeQuery();
		   while(rs.next())
		   {
			   StateModel model=new StateModel(rs.getInt(1),rs.getString(2));
			   viewList.add(model);
		   }
		   return viewList.size()>0?Optional.ofNullable(viewList):null;
		} catch (Exception e) 
		{
			System.out.println("Error is"+e);
			return null;
		}
	
	}


	@Override
	public StateModel getStateByName(String StateName1) 
	{
		try 
		{
		  stmt=conn.prepareStatement("select * from statemaster where statename=?");
		  stmt.setString(1, StateName1);
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			 return new StateModel(rs.getInt(1),rs.getString(2));
		  }
		  else {
			return null;
		}
		} catch (Exception e) {
			System.out.println("Error"+e);
			return null;

		}
		
		
	}


	@Override
	public boolean isDeleteStateByName(String StateName2) 
	{
		try 
		{
		  stmt=conn.prepareStatement("select * from statemaster where statename=?");
		  stmt.setString(1, StateName2);
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			 StateModel model= new StateModel(rs.getInt(1),rs.getString(2));
			 stmt=conn.prepareStatement("delete from statemaster where stateid=?");
			 stmt.setInt(1,model.getStateid());
			 int value2=stmt.executeUpdate();
			 return (value2>0)?true:null;
		  }
		  
		} catch (Exception e) {
			System.out.println("Error"+e);
			
		}
		return false;
	}


	
	public boolean isUpdateStateByName(String StateName3)
	{
		try 
		{
		  stmt=conn.prepareStatement("select * from statemaster where statename=?");
		  stmt.setString(1, StateName3);
		  rs=stmt.executeQuery();
		  if(rs.next())
		  {
			  StateModel model= new StateModel(rs.getInt(1),rs.getString(2));
			  Scanner sobj=new Scanner(System.in);
			  System.out.println("Enter new State name");
			  String statename=sobj.nextLine();
			  stmt=conn.prepareStatement("update statemaster set statename=? where stateid=?");
			  stmt.setString(1, statename);
			  stmt.setInt(2, model.getStateid());
			  int value3=stmt.executeUpdate();
			  return (value3>0)?true:null;
		  } 
		} catch (Exception e) {
			System.out.println("Error"+e);
		}
		return false;
	}


	@Override
	public boolean isAssociateDistTpState(String statename, String Distname) {
		try
		{
			cstmt=conn.prepareCall("{call saveDist(?,?)}");
			cstmt.setString(1,statename);
			cstmt.setString(2, Distname);
			boolean b=cstmt.execute();
			return !b;
			
		} catch (Exception e) {
			System.out.println("Error is"+e);
			return false;
		}
	}


	@Override
	public List<DistModel> viewAllDist(String statename) {
		try 
		{
			cstmt=conn.prepareCall("{call GetDist(?)}");
			cstmt.setString(1, statename);
			rs=cstmt.executeQuery();
			while(rs.next())
			{
				DistModel distModel=new DistModel(rs.getInt(1),rs.getString(2));
			     viewDistModels.add(distModel);
			}
			return viewDistModels;
			
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return null;
	}


	@Override
	public boolean isDeleteDistByName(String DistName) {
		try 
		{
			stmt=conn.prepareStatement("select distid from distmaster where distname=?");
			stmt.setString(1, DistName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("delete from distmaster where distid=?");
				stmt.setInt(1, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		
		} catch (Exception e) {
			System.out.println("Error is"+e);
			
		}
		return false;
	}


	@Override
	public boolean isUpdateDistByName(String DistName,String NewDistName) {
		try 
		{
			stmt=conn.prepareStatement("select distid from distmaster where distname=?");
			stmt.setString(1, DistName);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("update  distmaster set distname=? where distid=?");
				stmt.setString(1, NewDistName);
				stmt.setInt(2,rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		
		} catch (Exception e) {
			System.out.println("Error is"+e);
			
		}
		return false;
	}


	@Override
	public boolean isAddNewCityUnderDistState(String statename, String distname, String cityname) {
		try 
		{
			cstmt=conn.prepareCall("{call saveCity2(?,?,?)}");
			cstmt.setString(1, statename);
			cstmt.setString(2, distname);
			cstmt.setString(3, cityname);
		    boolean b=cstmt.execute();
		    return !b;
			
		}
		catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return false;
	}


	@Override
	public List<CityModel> viewAllCityassociateToDist(String distname) {
		try 
		{
			stmt=conn.prepareStatement("select cityid from citydistjoin where distid=(select distid from distmaster where distname=?)");
			stmt.setString(1, distname);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				int cityId = rs.getInt(1);
				stmt=conn.prepareStatement("select * from citymaster where cityid=?");
				stmt.setInt(1, cityId);
				rs=stmt.executeQuery();
				while(rs.next())
				{
					CityModel model =new CityModel(rs.getInt(1),rs.getString(2));
					viewAllCity.add(model);
				}
				return viewAllCity;
			}
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return null;
	}


	@Override
	public boolean isDeletecityByName(String cityname) {
		try 
		{
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, cityname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("delete from citymaster where cityid=?");
				stmt.setInt(1, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return false;
	}


	@Override
	public boolean isUpdatedcityByName(String cityname,String newcityname) 
	{
		try 
		{
			stmt=conn.prepareStatement("select cityid from citymaster where cityname=?");
			stmt.setString(1, cityname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("update  citymaster set cityname=? where cityid=?");
				stmt.setString(1, newcityname);
				stmt.setInt(2,rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}	
		}
		catch(Exception e) 
		{
			System.out.println("Error is"+e);
		}
		return false;
	}


	@Override
	public boolean AddNewWard(String cityname, String wardname,int pincode) {
		try 
		{
			cstmt=conn.prepareCall("{call saveWard1(?,?,?)}");
			cstmt.setString(1, wardname);
			cstmt.setString(2, cityname);
			cstmt.setInt(3, pincode);
		  boolean b=cstmt.execute();
		  return !b;
		} catch (Exception e) {
			System.out.println("Error+"+e);
		}
		return false;
	}


	@Override
	public List<wardModel> viewAllWards(String cityname) 
	{
		try 
		{
			
			cstmt=conn.prepareCall("{call callWard(?)}");
			cstmt.setString(1, cityname);
			rs=cstmt.executeQuery();
			while(rs.next())
			{
				wardModel model=new wardModel(rs.getInt(1),rs.getString(2));
				viewWard.add(model);
			}
			return viewWard;
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return null;
	}


	@Override
	public boolean isDeleteWardByName(String wardname) {
		try 
		{
			stmt=conn.prepareStatement("select wardid from wardmaster where wardname=?");
			stmt.setString(1, wardname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("delete from wardmaster where wardid=?");
				stmt.setInt(1, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return false;
	}


	@Override
	public boolean isUpdateWardByName(String wardname, String newwardname) {
		try 
		{
			stmt=conn.prepareStatement("select wardid from wardmaster where wardname=?");
			stmt.setString(1, wardname);
			rs=stmt.executeQuery();
			if(rs.next())
			{
				stmt=conn.prepareStatement("update wardmaster set wardname=? where wardid=?");
				stmt.setString(1, newwardname);
				stmt.setInt(2, rs.getInt(1));
				int value=stmt.executeUpdate();
				return value>0?true:null;
			}
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return false;
	}


	@Override
	public boolean isAddNewaminitie(AminitiesModel model) {
		try 
		{
			System.out.println(model.getAminitiesname());
			stmt=conn.prepareStatement("insert into amities values('0',?)");
			stmt.setString(1, model.getAminitiesname());
			int Value=stmt.executeUpdate();
			return (Value>0)?true:null;
		} catch (Exception e) {
			System.out.println("Error is"+e);
		}
		return false;
	}


	@Override
	public boolean isAddNewProperty(PropertyModel model,String wardname,String aminityname,int aaprice) {
	
		try 
		{
			cstmt=conn.prepareCall("{call propJoin3(?,?,?,?,?,?,?)}");
			cstmt.setString(1, model.getName());
			cstmt.setString(2, model.getAddress());
			cstmt.setInt(3, model.getPrice());
			cstmt.setString(4, wardname);
			cstmt.setInt(5, model.getArea());
			cstmt.setString(6, aminityname);
			cstmt.setInt(7, aaprice);
			
		    boolean b=cstmt.execute();
		    return !b;
			
		} catch (Exception e) {
			System.out.println("Error is "+e);
		}
		return false;
	}


	

	
		
}
	
	

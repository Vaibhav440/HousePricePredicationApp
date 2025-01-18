package org.TechHub.Model;

public class PropertyModel {
	int id;
	String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getArea() {
		return area;
	}
	public void setArea(int area) {
		this.area = area;
	}
	String address;
	int price;
	int area;
	
	public PropertyModel()
	{
		
	}
	public PropertyModel(int id,String name,String address,int price,int area)
	{
		this.id=id;
		this.name=name;
		this.address=address;
		this.price=price;
		this.area=area;
	}
}

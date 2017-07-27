package com.vehiclerest.jersey;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "vehicle")
public class Vehicle {

	private int Id;
	private int Year;
	private String Make;
	private String Model;

	public Vehicle(){}
	
	public Vehicle(int Id, int Year, String Make, String Model){
		this.Id = Id;
		this.Year = Year;
		this.Make = Make;
		this.Model = Model;
	}
	
	@XmlElement( name = "Id")
	public void setId(int Id) {
		this.Id = Id;
	}
	public int getId() {
		return Id;
	}
	
	@XmlElement( name = "Year")
	public void setYear(int Year) {
		this.Year = Year;
	}
	public int getYear() {
		return Year;
	}
	
	@XmlElement( name = "Make")
	public void setMake(String Make) {
		this.Make = Make;
	}
	public String getMake() {
		return Make;
	}
	
	@XmlElement( name = "Model")
	public void setModel(String Model) {
		this.Model = Model;
	}
	public String getModel() {
		return Model;
	}
}
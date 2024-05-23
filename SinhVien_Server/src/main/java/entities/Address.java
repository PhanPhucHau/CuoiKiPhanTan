package entities;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


public class Address implements Serializable{
	
	private String street;
	private String city;
	private String sate;
	private int postCode;
	
	public Address() {

	}

	public Address(String street, String city, String sate, int postCode) {
		this.street = street;
		this.city = city;
		this.sate = sate;
		this.postCode = postCode;
	}
	

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSate() {
		return sate;
	}

	public void setSate(String sate) {
		this.sate = sate;
	}

	public int getPostCode() {
		return postCode;
	}

	public void setPostCode(int postCode) {
		this.postCode = postCode;
	}

	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", sate=" + sate + ", postCode=" + postCode + "]";
	}
	
	
	
	
	
	
	

}

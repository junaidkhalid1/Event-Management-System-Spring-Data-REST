package fr.junaid.eventmanagement.entities;

import java.util.Objects;

import javax.persistence.Entity;

@Entity
public class Venue extends AbstractEntity {

	private String name;
	private String streetAdress;
	private String streetAdress2;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getStreetAdress() {
		return streetAdress;
	}
	
	public void setStreetAdress(String streetAdress) {
		this.streetAdress = streetAdress;
	}
	
	public String getStreetAdress2() {
		return streetAdress2;
	}
	
	public void setStreetAdress2(String streetAdress2) {
		this.streetAdress2 = streetAdress2;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}
	
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	
	@Override
	public boolean equals(Object obj) {
		return Objects.equals(id, ((Venue) obj).id );
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

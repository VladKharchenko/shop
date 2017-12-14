package edu.karazin.shop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class UserData {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String city;
	
	public UserData(){
	}
	
	@Override
	public String toString() {
		return "UserData [id=" + id + ", name=" + name + ", city=" + city + "]";
	}

	public UserData(String name, String city){
		this.name = name;
		this.city = city;
	}
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}

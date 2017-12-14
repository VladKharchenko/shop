package edu.karazin.shop.web.form;

import edu.karazin.shop.model.Role;
import edu.karazin.shop.model.User;
import edu.karazin.shop.model.UserData;

public class UserForm extends LoginForm {
	private Role role;
	
	private String name;
	private String city;
	
	public UserForm() {
	}

	public UserForm(Role role) {
		this.role = role;
	}

	public UserForm(String name, String city, String login, String password, Role role) {
		super(login, password);
		this.role = role;
		this.city = city;
		this.name = name;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User convertToUser() {
		return new User(new UserData(name, city), getLogin(), getPassword(), getRole());
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
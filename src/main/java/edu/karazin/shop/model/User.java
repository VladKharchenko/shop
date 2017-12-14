package edu.karazin.shop.model;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue
	private Long id;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="data_id")
	private UserData data;
	
	private String login;

	private String password;

	@Enumerated(EnumType.STRING)
	private Role role;

	public User() {
	}

	public User(UserData data, String login, String password, Role role) {
		this.data = data;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public UserData getData() {
		return data;
	}

	public void setData(UserData data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", data=" + data + ", login=" + login + ", password=" + password + ", role=" + role
				+ "]";
	}
}
package com.lexivo.lexivo.model;

import jakarta.persistence.*;

import java.util.Calendar;

@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	@Column(length = 60, unique = true, nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column(columnDefinition = "CHAR(10)")
	private String joinDate;

	public User() {
	}

	public User(String id, String username, String password, String joinDate) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.joinDate = joinDate;
	}

	public String getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	@Override
	public String toString() {
		return "User{" +
				"id='" + id + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", joinDate='" + joinDate + '\'' +
				'}';
	}

	private String setDate() {
		Calendar calendar = Calendar.getInstance();
		int day = calendar.get(Calendar.DATE);
		int year = calendar.get(Calendar.YEAR);
		String month = String.valueOf(calendar.get(Calendar.MONTH) + 1);
		month = month.length() == 1 ? "0" + month : month;
		return day + "-" + month + "-" + year;
	}

	@PrePersist
	protected void onCreate() {
		if (joinDate == null)
			joinDate = setDate();
	}
}

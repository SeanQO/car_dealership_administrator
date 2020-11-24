package model;

import java.io.Serializable;

public class Person implements Serializable{
	private static final long serialVersionUID = 1;
	
	private String name;
	private String lastname;
	private String email;
	private long id;
	private int phoneNumber;
	
	public Person(String name, String lastname, String email, long id, int phoneNumber) {
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.id = id;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}
	
}

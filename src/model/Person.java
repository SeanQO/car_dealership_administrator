package model;

import java.io.Serializable;

public class Person  implements Comparable<Person>, Serializable{
	private static final long serialVersionUID = 1;
	
	private String name;
	private String lastName;
	private String email;
	private long id;
	private long phoneNumber;
	
	public Person(String name, String lastName, String email, long id, long phoneNumber) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.id = id;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public long getId() {
		return id;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public int compareTo(Person p) {
		int difference;
		if(this.lastName.equals(p.lastName)) {
			difference = this.name.compareTo(p.name);
		}else {
			difference = this.lastName.compareTo(p.lastName);
		}
		return difference;
	}
}

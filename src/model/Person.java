package model;

import java.io.Serializable;

public class Person  implements Comparable<Person>, Serializable{
	private static final long serialVersionUID = 1;
	
	private String name;
	private String lastname;
	private String email;
	private long id;
	private long phoneNumber;
	
	public Person(String name, String lastName, String email, long id, long phoneNumber) {
		this.name = name;
		this.lastname = lastName;
		this.email = email;
		this.id = id;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastname;
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
		if(this.lastname.equals(p.lastname)) {
			difference = this.name.compareTo(p.name);
		}else {
			difference = this.lastname.compareTo(p.lastname);
		}
		return difference;
	}
}

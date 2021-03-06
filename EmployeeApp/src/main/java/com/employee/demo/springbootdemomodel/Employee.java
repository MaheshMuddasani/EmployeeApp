package com.employee.demo.springbootdemomodel;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Set;
//dao interface which means mark the class as a persistent java class
@Entity
@Table(name = "employee")
public class Employee implements Serializable {

	/**
	 *
	 */


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
 
	@Column(name = "firstname")
	@NotBlank
	private String firstName;
 
	@Column(name = "lastname")
	@NotBlank
	private String lastName;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<TimeTable> timeTable;
	
	@OneToMany(cascade=CascadeType.ALL)
	private Set<TimeOff> timeOff;
 
	protected Employee() {
	}
 
	public long getId() {
		return id;
	}
 
	public void setId(long id) {
		this.id = id;
	}

 
	public String getFirstName() {
		return firstName;
	}

 
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}
 
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
 
	public Employee(String firstName, String lastName,Set<TimeOff> timeOff, Set<TimeTable> timeTable) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.timeOff= timeOff;
		this.timeTable=timeTable;
	}
 
	
	public Set<TimeTable> getTimeTable() {
		return timeTable;
	}

	public void setTimeTable(Set<TimeTable> timeTable) {
		this.timeTable = timeTable;
	}

	public Set<TimeOff> getTimeOff() {
		return timeOff;
	}

	public void setTimeOff(Set<TimeOff> timeOff) {
		this.timeOff = timeOff;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, firstName, lastName);
	}
}
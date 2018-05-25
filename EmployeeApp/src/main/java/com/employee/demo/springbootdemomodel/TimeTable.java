package com.employee.demo.springbootdemomodel;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Time_Table")
public class TimeTable implements Serializable {


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "begin_Time")
	@NotBlank
	private String begin;
	
	@Column(name = "end_Time")
	@NotBlank
	private String end;
	
	@Column(name = "begin_break")
	@NotBlank
	private String begin_break;
	
	@Column(name = "end_break")
	@NotBlank
	private String end_break;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBegin() {
		return begin;
	}

	public void setBegin(String begin) {
		this.begin = begin;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getBegin_break() {
		return begin_break;
	}

	public void setBegin_break(String begin_break) {
		this.begin_break = begin_break;
	}

	public String getEnd_break() {
		return end_break;
	}

	public void setEnd_break(String end_break) {
		this.end_break = end_break;
	}


}

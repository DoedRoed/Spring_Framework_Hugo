package com.yrgo.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CUSTOMER_CALL")
public class Call {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int callId;

	private Date timeAndDate;

	private String notes;

	public Call(String notes){
		// this defaults to a timestamp of "now"
		this (new java.util.Date(), notes);
	}

	public Call(Date timestamp, String notes){
		// this defaults to a timestamp of "now"
		this.timeAndDate = timestamp;
		this.notes = notes;
	}

	public String toString()	{
		return this.timeAndDate + " : " + this.notes;
	}

	public Date getTimeAndDate() {
		return timeAndDate;
	}

	public void setTimeAndDate(Date timeAndDate) {
		this.timeAndDate = timeAndDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Call() {}
}

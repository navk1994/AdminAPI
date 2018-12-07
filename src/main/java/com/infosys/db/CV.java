package com.infosys.db;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CV {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int cvID;
	private int userID;
	private String cvPath;
	
	public int getCvID() {
		return cvID;
	}
	public void setCvID(int cvID) {
		this.cvID = cvID;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public String getCvPath() {
		return cvPath;
	}
	public void setCvPath(String cvPath) {
		this.cvPath = cvPath;
	}
	
	
	
}

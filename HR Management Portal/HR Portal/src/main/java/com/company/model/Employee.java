package com.company.model;

public class Employee {

	private String userName="";
	
	private String department="";
	
	private String employeeID="";
	
	private String manager="";
	
	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	private String nickName="";
	
	private String designation="";
	
	private String mailId="";
	
	private String phone="";
	

	public Employee() {
		
	}

	

	public Employee(String userName, String department, String employeeID,
			String manager, String nickName, String designation, String mailId,
			String phone) {
		super();
		this.userName = userName;
		this.department = department;
		this.employeeID = employeeID;
		this.manager = manager;
		this.nickName = nickName;
		this.designation = designation;
		this.mailId = mailId;
		this.phone = phone;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public void setEmployeeID(String employeeID) {
		this.employeeID = employeeID;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
}

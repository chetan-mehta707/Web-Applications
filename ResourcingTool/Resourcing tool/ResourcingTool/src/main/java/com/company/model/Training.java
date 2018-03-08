package com.company.model;

import java.util.List;

public class Training {
	
	private List<String> dates=null;
	
	private String month="";
	
	private String quarter="";
	
	private String type="";
	
	private String programName="";	

	public Training(List<String> dates, String month, String quarter,
			String type, String programName) {
		super();
		this.dates = dates;
		this.month = month;
		this.quarter = quarter;
		this.type = type;
		this.programName = programName;
	}
	
	public Training() {
		super();
	}

	public List<String> getDates() {
		return dates;
	}

	public void setDates(List<String> dates) {
		this.dates = dates;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProgramName() {
		return programName;
	}

	public void setProgramName(String programName) {
		this.programName = programName;
	}	
	
}

package dev.joshua_coombs.models;

import java.sql.Timestamp;

public class ReimbursementForm {
	private int reimbursementId;
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private Timestamp dateAndTime;
	private String location;
	private String description;
	private int cost;
	private String gradingFormat;
	private String eventType;
	private String grade;
	private String justification;
	private int reimbursementAmount;
	private String reimbursementStatus;
	
	public ReimbursementForm() {
		super();
	}
	
	public ReimbursementForm(int reimbursementId, int employeeId, String employeeFirstName, String employeeLastName,
			Timestamp dateAndTime, String location, String description, int cost, String gradingFormat,
			String eventType, String grade, String justification, int reimbursementAmount, 
			String reimbursementStatus) {
		super();
		this.reimbursementId = reimbursementId;
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.dateAndTime = dateAndTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.grade = grade;
		this.justification = justification;
		this.reimbursementAmount = reimbursementAmount;
		this.reimbursementStatus = reimbursementStatus;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public int getReimbursementId() {
		return reimbursementId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public int getCost() {
		return cost;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public String getEventType() {
		return eventType;
	}
	
	public String getGrade() {
		return grade;
	}

	public String getJustification() {
		return justification;
	}
	
	public int getReimbursementAmount() {
		return reimbursementAmount;
	}

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementForm [reimbursementId=" + reimbursementId + ", employeeId=" + employeeId
				+ ", employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName
				+ ", dateAndTime=" + dateAndTime + ", location=" + location + ", description=" + description + ", cost="
				+ cost + ", gradingFormat=" + gradingFormat + ", eventType=" + eventType + ", grade=" + grade
				+ ", justification=" + justification + ", reimbursementAmount=" + reimbursementAmount
				+ ", reimbursementStatus=" + reimbursementStatus + "]";
	}

	
}

package dev.joshua_coombs.models;

import java.sql.Timestamp;

public class ReimbursementForm {
	private int employeeId;
	private int reimbursementId;
	private String employeeFirstName;
	private String employeeLastName;
	private Timestamp dateAndTime;
	private String location;
	private String description;
	private int cost;
	private String gradingFormat;
	private String eventType;
	private String justification;
	private int reimbursementAmount;
	private String reimbursementStatus;
	
	public ReimbursementForm() {
		super();
	}
	
	public ReimbursementForm(int employeeId, int reimbursementId, String employeeFirstName, String employeeLastName,
			Timestamp dateAndTime, String location, String description, int cost, String gradingFormat,
			String eventType, String justification, int reimbursementAmount, 
			String reimbursementStatus) {
		super();
		this.employeeId = employeeId;
		this.reimbursementId = reimbursementId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.dateAndTime = dateAndTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
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

	public String getJustification() {
		return justification;
	}
	
	public int getReimbursementAmount() {
		return reimbursementAmount;
	}
	
	public void setReimbursementAmount(int newAmount) {
		this.reimbursementAmount = newAmount;
	}

	public String getReimbursementStatus() {
		return reimbursementStatus;
	}
	
	public void setReimbursementStatus(String newStatus) {
		this.reimbursementStatus = newStatus;
	}

	@Override
	public String toString() {
		return "ReimbursementForm [employeeId=" + employeeId + ", reimbursementId=" + reimbursementId
				+ ", employeeFirstName=" + employeeFirstName + ", employeeLastName=" + employeeLastName
				+ ", dateAndTime=" + dateAndTime + ", location=" + location + ", description=" + description + ", cost="
				+ cost + ", gradingFormat=" + gradingFormat + ", eventType=" + eventType + ", justification="
				+ justification + ", reimbursementAmount=" + reimbursementAmount + ", reimbursementStatus=" + reimbursementStatus + "]";
	}
}

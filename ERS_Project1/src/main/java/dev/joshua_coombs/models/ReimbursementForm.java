package dev.joshua_coombs.models;

import java.time.LocalDateTime;

public class ReimbursementForm {
	private int employeeId;
	private String employeeFirstName;
	private String employeeLastName;
	private LocalDateTime dateAndTime;
	private String location;
	private String description;
	private double cost;
	private GradingFormat gradingFormat;
	private EventType eventType;
	private String justification;
	
	public ReimbursementForm() {
		super();
	}
	
	public ReimbursementForm(int employeeId, String employeeFirstName, String employeeLastName,
			LocalDateTime dateAndTime, String location, String description, double cost, 
			GradingFormat gradingFormat, EventType eventType, String justification) {
		this.employeeId = employeeId;
		this.employeeFirstName = employeeFirstName;
		this.employeeLastName = employeeLastName;
		this.dateAndTime = dateAndTime;
		this.location = location;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.eventType = eventType;
		this.justification = justification;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public String getEmployeeLastName() {
		return employeeLastName;
	}

	public LocalDateTime getDateAndTime() {
		return dateAndTime;
	}

	public String getLocation() {
		return location;
	}

	public String getDescription() {
		return description;
	}

	public double getCost() {
		return cost;
	}

	public GradingFormat getGradingFormat() {
		return gradingFormat;
	}

	public EventType getEventType() {
		return eventType;
	}

	public String getJustification() {
		return justification;
	}

	@Override
	public String toString() {
		return "ReimbursementForm [employeeId=" + employeeId + ", employeeFirstName=" + employeeFirstName
				+ ", employeeLastName=" + employeeLastName + ", dateAndTime=" + dateAndTime + ", location=" + location
				+ ", description=" + description + ", cost=" + cost + ", gradingFormat=" + gradingFormat
				+ ", eventType=" + eventType + ", justification=" + justification + "]";
	}
	
	
}
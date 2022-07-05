package dev.joshua_coombs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RFormPage {
	private WebDriver realHumanBeing;
	public RFormPage(WebDriver realHumanBeing) {
		this.realHumanBeing = realHumanBeing;
		PageFactory.initElements(realHumanBeing, this);
	}
	
	@FindBy(id = "eventType")
	public WebElement eventType;
	
	@FindBy(id = "gradeFormat")
	public WebElement gradeFormat;
}

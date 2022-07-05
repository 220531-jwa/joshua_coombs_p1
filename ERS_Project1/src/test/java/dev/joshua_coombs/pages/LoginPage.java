package dev.joshua_coombs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver realHumanBeing;
	public LoginPage(WebDriver realHumanBeing) {
		this.realHumanBeing = realHumanBeing;
		PageFactory.initElements(realHumanBeing, this);
	}
	
	@FindBy(id = "uName")
	public WebElement usernameInput;
	
	@FindBy(id = "pWord")
	public WebElement passwordInput;
	
	@FindBy(id = "eLogin")
	public WebElement eLoginButton;
	
	@FindBy(id = "fmLogin")
	public WebElement fmLoginButton;
}

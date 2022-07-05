package dev.joshua_coombs.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.joshua_coombs.pages.LoginPage;
import dev.joshua_coombs.runner.LoginRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EmpStepImpl {
	public static WebDriver realHumanBeing = LoginRunner.realHumanBeing;
	public static LoginPage loginPage = LoginRunner.loginPage;
	
	@Given("an Employee is on the LoginPage")
	public void an_employee_is_on_the_login_page() {
		realHumanBeing.get("http://localhost:8090/loginPage.html");
	}

	@When("the Employee enters their {string} and {string} and clicks the login button")
	public void the_employee_enters_their_and_and_clicks_the_login_button(String username, String password) {
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.eLoginButton.click();
	}

	@Then("the Employee will go to the EmployeePortal")
	public void the_employee_will_go_to_the_employee_portal() {
		new WebDriverWait(realHumanBeing, Duration.ofSeconds(7))
		.until(ExpectedConditions.titleIs("Employee Portal"));
		assertEquals("Employee Portal", realHumanBeing.getTitle());
	}
}

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

public class FMStepImpl {
	public static WebDriver realHumanBeing = LoginRunner.realHumanBeing;
	public static LoginPage loginPage = LoginRunner.loginPage;
	
	@Given("the FinanceManager is on the LoginPage")
	public void the_finance_manager_is_on_the_login_page() {
		realHumanBeing.get("http://localhost:8090/loginPage.html");
	}

	@When("the FinanceManager enters their {string} and {string} and clicks the login button")
	public void the_finance_manager_enters_their_and_and_clicks_the_login_button(String username, String password) {
		loginPage.usernameInput.sendKeys(username);
		loginPage.passwordInput.sendKeys(password);
		loginPage.fmLoginButton.click();
	}

	@Then("the FinanceManager will go to either the FinanceManagerPortal")
	public void the_finance_manager_will_go_to_either_the_finance_manager_portal() {
		new WebDriverWait(realHumanBeing, Duration.ofSeconds(7))
		.until(ExpectedConditions.titleIs("Finance Manager Portal"));
		assertEquals("Finance Manager Portal", realHumanBeing.getTitle());
	}
}

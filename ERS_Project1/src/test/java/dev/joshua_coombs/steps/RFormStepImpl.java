package dev.joshua_coombs.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.joshua_coombs.pages.RFormPage;
import dev.joshua_coombs.runner.RFormRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RFormStepImpl {
	public static WebDriver realHumanBeing = RFormRunner.realHumanBeing;
	public static RFormPage rfPage = RFormRunner.rfPage;
	
	@Given("an Employee has succesfully logged in and makes a NewRequest")
	public void an_employee_has_succesfully_logged_in_and_makes_a_new_request() {
		realHumanBeing.get("http://localhost:8090/employeePortalPage.html");
		new WebDriverWait(realHumanBeing, Duration.ofSeconds(7))
			.until(ExpectedConditions.titleIs("Employee Portal"));
		realHumanBeing.findElement(By.linkText("New Request")).click();
	}

	@When("they click the drop down menu for EventType")
	public void they_click_the_drop_down_menu_for_event_type() {
		new WebDriverWait(realHumanBeing, Duration.ofSeconds(7))
		.until(ExpectedConditions.elementToBeClickable(rfPage.eventType));
	}

	@Then("they select an EventType")
	public void they_select_an_event_type() {
	    Select event = new Select(rfPage.eventType);
	    event.selectByIndex(3);
	    assertEquals(event.getFirstSelectedOption(), "Certification");
	}
	
	@When("they click the drop down menu for GradeFormat")
	public void they_click_the_drop_down_menu_for_grade_format() {
		new WebDriverWait(realHumanBeing, Duration.ofSeconds(7))
		.until(ExpectedConditions.elementToBeClickable(rfPage.gradeFormat));
	}

	@Then("they select a GradeFormat")
	public void they_select_a_grade_format() {
		Select format = new Select(rfPage.gradeFormat);
	    format.selectByIndex(0);
	    assertEquals(format.getFirstSelectedOption(), "Letter Grade");
	}
}

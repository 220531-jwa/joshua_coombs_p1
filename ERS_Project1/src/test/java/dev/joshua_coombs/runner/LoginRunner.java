package dev.joshua_coombs.runner;

import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.joshua_coombs.pages.LoginPage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@Suite
public class LoginRunner {
	public static WebDriver realHumanBeing;
	public static LoginPage loginPage;
	
	@BeforeAll
	public static void setup() {
		File firefox = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
		realHumanBeing = new FirefoxDriver();
		loginPage = new LoginPage(realHumanBeing);
	}
	
	@AfterAll
	public static void teardown() {
		realHumanBeing.quit();
	}
}

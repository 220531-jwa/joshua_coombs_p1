package dev.joshua_coombs.runner;

import java.io.File;

import org.junit.platform.suite.api.Suite;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.joshua_coombs.pages.*;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

public class RFormRunner {
	public static WebDriver realHumanBeing;
	public static RFormPage rfPage;
	
	@BeforeAll
	public static void setup() {
		File firefox = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", firefox.getAbsolutePath());
		realHumanBeing = new FirefoxDriver();
		rfPage = new RFormPage(realHumanBeing);
	}
	
	@AfterAll
	public static void teardown() {
		realHumanBeing.quit();
	}
}

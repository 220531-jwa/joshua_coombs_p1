package dev.joshua_coombs.runner;

import java.io.File;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import dev.joshua_coombs.pages.ERSPage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"dev.joshua_coombs.steps"})
public class ERSRunner {
	public static WebDriver realHumanBeing;
	public static ERSPage ersPage;
	
	@BeforeAll
	public static void setup() {
		File firefox = new File("src/test/resources/geckodriver.exe");
		System.setProperty("webdriver.firefox.driver", firefox.getAbsolutePath());
		realHumanBeing = new FirefoxDriver();
		ersPage = new ERSPage(realHumanBeing);
	}
	
	@AfterAll
	public static void teardown() {
		realHumanBeing.quit();
	}
}

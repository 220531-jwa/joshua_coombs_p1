package dev.joshua_coombs.runner;

import java.io.File;


import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.joshua_coombs.pages.ERSPage;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.AfterAll;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources"}, glue = {"com.revature.steps"})
public class ERSRunner {
	public static WebDriver realHumanBeing;
	public static ERSPage ersPage;
}

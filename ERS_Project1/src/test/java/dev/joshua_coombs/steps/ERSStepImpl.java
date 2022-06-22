package dev.joshua_coombs.steps;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import dev.joshua_coombs.pages.ERSPage;
import dev.joshua_coombs.runner.ERSRunner;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ERSStepImpl {
	public static WebDriver realHumanBeing = ERSRunner.realHumanBeing;
	public static ERSPage ersPage = ERSRunner.ersPage;
}

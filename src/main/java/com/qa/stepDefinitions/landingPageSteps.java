package com.qa.stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.qa.common.components;
import com.qa.pageObjects.landingPage;
import com.qa.utility.setUp;
import com.qa.utility.util;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class landingPageSteps 
{
	Properties prop=setUp.envSetUp();
	util Util=new util();
	components Components=new components();
	WebDriver driver;
	
	
	@Before()
	public void launchApp()
	{
		driver=Util.launchBrowser();
	}

	@Given("^I am on the landing page$")
	public void launchLandingPage()
	{
    	Components.loadApp(prop.getProperty("appUrl"));

	}
	@Then("^I should see the \\\"([^\\\"]*)\\\" title$")
	public void validateTitle(String url) throws IOException 
	{
		Components.CompareTitle(url);
		System.out.println(Components.getTestData("contactUs", "EmailAddress"));
	}
	@Then("^I should navigate to contactUs from$")
	public void navigateToContactUs()
	{
		landingPage LandingPage=new landingPage(driver);
		LandingPage.ClickContactUs();
	}
	@After()
	public void killApp()
	{
		Util.killBrowser();
	}
	
}

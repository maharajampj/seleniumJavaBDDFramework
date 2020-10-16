package com.qa.web.stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.qa.common.webComponents;
import com.qa.common.readData;
import com.qa.pageObjects.contactUsPage;
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
	webComponents Components=new webComponents();
	readData data=new readData();
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
	@Given("^I have the data$")
	public void printTestData() throws IOException, ParseException, ClassNotFoundException, SQLException
	{
		//System.out.println(data.getExcelTestData("contactUs", "EmailAddress"));
		//System.out.println(data.getJSONTestData("dependencies"));
		//System.out.println(data.getCSVTestData("Name"));
		//data.getDBTestData();
	}
	@Then("^I should see the \\\"([^\\\"]*)\\\" title$")
	public void validateTitle(String title) throws IOException, ParseException 
	{
		Components.CompareTitle(title);

	}
	@Then("^I should navigate to contactUs from$")
	public void navigateToContactUs()
	{
		landingPage LandingPage=new landingPage(driver);
		LandingPage.ClickContactUs();
		Components.switchWindow("WebDriver | Contact U");
	}
	@Then("^user should be able to submit the form$")
	public void validateSuccessForm()
	{
		contactUsPage ContactUsPage=new contactUsPage(driver);
		ContactUsPage.submitContactForm("submit");
		ContactUsPage.ValidateSuccessSubmission();
	}

	@After()
	public void killApp()
	{
		Util.killBrowser();
	}
	
}

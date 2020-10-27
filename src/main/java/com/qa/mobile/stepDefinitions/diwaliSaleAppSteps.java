package com.qa.mobile.stepDefinitions;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import java.util.Properties;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;

import com.qa.common.webComponents;
import com.qa.mobile.pageObjects.landingPage;
import com.qa.common.readData;
import com.qa.utility.setUp;
import com.qa.utility.util;
import com.qa.web.pageObjects.contactUsPage;


import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class diwaliSaleAppSteps 
{
	Properties prop=setUp.envSetUp();
	util Util=new util();
	webComponents Components=new webComponents();
	readData data=new readData();
	AndroidDriver<AndroidElement> androidDriver;
	
	
	@Before()
	public void launchDevice() throws MalformedURLException
	{
		androidDriver=Util.launchDevice();
	}

	@Given("^I am on the device$")
	public void OpenAPP()
	{
		
	}
	@Then("^I should see app loaded$")
	public void validateApp()
	{
		
	}

	@Then("^I should move to Register Page$")
	public void clickRegister() throws InterruptedException
	{
		landingPage landingpage=new landingPage(androidDriver);
		landingpage.clickRegister();
	}
	@Then("I should fill {string} and {string} and {string} and {string}")
	public void registerForm(String name, String email, String password, String phno)
	{
		landingPage landingpage=new landingPage(androidDriver);
		landingpage.submitRegistration(name, email, password, phno);

	}
	@After()
	public void killApp()
	{
		//Util.killDevice();
	}
	
}

package com.qa.mobile.stepDefinitions;

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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class demoAppSteps 
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

	@After()
	public void killApp()
	{
		Util.killDevice();
	}
	
}

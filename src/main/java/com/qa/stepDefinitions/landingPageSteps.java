package com.qa.stepDefinitions;

import java.util.Properties;

import com.qa.common.components;
import com.qa.utility.setUp;
import com.qa.utility.util;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class landingPageSteps 
{
	Properties prop=setUp.envSetUp();
	util Util=new util();
	components Components=new components();
	@Before()
	public void launchApp()
	{
		Util.launchBrowser(prop.getProperty("browser"));
	}

	@Given("^I am on the landing page$")
	public void launchLandingPage()
	{
		Components.loadApp(prop.getProperty("appUrl"));

	}
	@Then("^$I should see the \"([^\\\"]*)\" title")
	public void validateTitle(String url) 
	{
		Components.CompareUrl(url);
	}
	
}

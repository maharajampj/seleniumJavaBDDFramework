package com.qa.mobile.stepDefinitions;

import java.net.MalformedURLException;
import java.util.Properties;

import com.qa.common.readData;
import com.qa.common.webComponents;
import com.qa.mobile.pageObjects.storelandingPage;
import com.qa.services.appiumService;
import com.qa.utility.setUp;
import com.qa.utility.util;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class demoAPKSteps
{
	Properties prop=setUp.envSetUp();
	util Util=new util();
	webComponents Components=new webComponents();
	readData data=new readData();
	AndroidDriver<AndroidElement> androidDriver;
	appiumService appium=new appiumService();
	
	
	@Before()
	public void launchDevice() throws MalformedURLException
	{
		appium.startAppiumServer();
		androidDriver=Util.launchDevice();
	}

	@Given("^I am on the App$")
	public void OpenAPP()
	{
		
	}

	@After()
	public void killApp()
	{
		
		Util.killDevice();
		appium.stopAppiumServer();
	}
}

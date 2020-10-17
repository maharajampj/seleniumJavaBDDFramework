package com.test;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class getpProperties extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=base.main();
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		System.out.println(driver.findElementsByAndroidUIAutomator("new uiSelector().clickable(true)").size());
	

	}

}

package com.qa.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.qa.utility.util;

import io.appium.java_client.android.AndroidElement;

public class mobileComponents extends util
{
	mobileUi ui = new mobileUi();

	public void scrollToElement(AndroidElement element)
	{
		if (ui.isDisplayed(element))
		{
			androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView("+element+"));");
		}
	}

	public void loadApp(String bunndleId) 
	{
		androidDriver.activateApp(bunndleId);
		
	}

	
}

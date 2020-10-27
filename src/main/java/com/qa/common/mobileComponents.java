package com.qa.common;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import com.qa.utility.util;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class mobileComponents extends util {
	mobileUi ui = new mobileUi();

	public void scrollToElement(AndroidElement element) {
		if (ui.isDisplayed(element)) {
			androidDriver.findElementByAndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(" + element + "));");
		}
	}

	public void loadApp(String bunndleId) {
		androidDriver.activateApp(bunndleId);

	}

	public void dragAndDrop(AndroidElement source, AndroidElement dest) {
		TouchAction t = new TouchAction(androidDriver);
		t.longPress(longPressOptions().withElement(element(source))).moveTo(element(dest)).release().perform();
	}

	public void longPress(AndroidElement element) {
		TouchAction t = new TouchAction(androidDriver);
		// t.tap(tapOptions().withElement(element(people))).perform();
		t.longPress(longPressOptions().withElement(element(element)).withDuration(ofSeconds(3))).release().perform();
	}
	
	public void scrollTillText(String text)
	{
		androidDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"));");

	}
	public void swipeTill(AndroidElement source, AndroidElement dest)
	{
		TouchAction t=new TouchAction(androidDriver);
		t.longPress(longPressOptions().withElement(element(source)).withDuration(ofSeconds(2))).moveTo(element(dest)).release().perform();
		
	}
}

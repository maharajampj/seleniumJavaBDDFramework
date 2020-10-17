package com.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.TouchAction;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import static java.time.Duration.ofSeconds;

public class longPress extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=main();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Expandable Lists\")").click();
		driver.findElementByXPath("//android.widget.TextView[@content-desc='1. Custom Adapter']").click();
        WebElement people=driver.findElementByAndroidUIAutomator("text(\"People Names\")");
        TouchAction t =new TouchAction(driver);
       // t.tap(tapOptions().withElement(element(people))).perform();
        t.longPress(longPressOptions().withElement(element(people)).withDuration(ofSeconds(3))).release().perform();
        System.out.println(driver.findElementByAndroidUIAutomator("text(\"Sample menu\")").getText());
        System.out.println(driver.isDeviceLocked());
        System.out.println(driver.getCurrentPackage());
        System.out.println(driver.getAutomationName());
      //  System.out.println(driver.getBatteryInfo().getLevel());


        driver.closeApp();

	}

}

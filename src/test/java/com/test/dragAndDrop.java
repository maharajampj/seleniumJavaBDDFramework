package com.test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class dragAndDrop extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=base.main();
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Drag and Drop\")").click();
		WebElement source=driver.findElementsByClassName("android.view.View").get(0);
		WebElement dest=driver.findElementsByClassName("android.view.View").get(1);
		TouchAction t = new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(source))).moveTo(element(dest)).release().perform();
		//t.longPress(element(source)).moveTo(element(dest)).release().perform();
		//System.out.println(driver.findElementByXPath("(//*[@class='android.widget.TextView'])[1]").getText());
		//driver.closeApp();
	

	}

}

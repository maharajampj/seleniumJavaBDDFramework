package testCases;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class calc extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=base.main();
		
		driver.findElementByAndroidUIAutomator("text(\"9\")").click();
		driver.findElementByAndroidUIAutomator("text(\"×\")").click();
		driver.findElementByAndroidUIAutomator("text(\"3\")").click();
		driver.findElementByAndroidUIAutomator("text(\"=\")").click();
		System.out.println(driver.findElementByXPath("//*[@elementId='3']").getText());
		
	

	}

}

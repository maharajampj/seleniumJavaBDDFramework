package com.test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class test 
{

	public static void main(String[] args) throws MalformedURLException
	{
		File f=new File("src");
		File appPath=new File(f,"\\main\\resources\\apps\\Test.apk");
		URL url=new URL("http:127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "G10GLMD540109003");
	
		
		//cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		AndroidDriver<AndroidElement> ad = new AndroidDriver<>(url,cap);
	
	}
}

package com.qa.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class util {
	public static String resourceDriverPath = null;
	public static String resouceExcelTestDataPath = null;
	public static String resourceJSONTestDataPath = null;
	public static String resourceCSVTestDataPath=null;
	public static WebDriver driver;
	public static AndroidDriver<AndroidElement> androidDriver ;
	Properties prop = setUp.envSetUp();

	public util() {
		resourceDriverPath = System.getProperty("user.dir") + "//src//main//resources//drivers//";
		resouceExcelTestDataPath = System.getProperty("user.dir") + "//TestData//Data.xlsx";
		resourceJSONTestDataPath=System.getProperty("user.dir") + "//TestData//Data.json";
		resourceCSVTestDataPath=System.getProperty("user.dir") + "//TestData//Data.csv";
	}

	public WebDriver launchBrowser() 
	{		
		String browser=prop.getProperty("browser");
		String emulator=prop.getProperty("emulator");
		String platform=prop.getProperty("platform");
		
		if(platform.equals("desktop"))
		{
		switch (browser) 
		{
		case "chrome":
		    System.setProperty("webdriver.chrome.driver",resourceDriverPath+"chromedriver.exe");
		    ChromeOptions chromeOptions = new ChromeOptions();
			if(emulator!=null)
			{
				
				int width=Integer.parseInt(prop.getProperty("device_width"));
				int height=Integer.parseInt(prop.getProperty("device_height"));
				int pixelRatio=Integer.parseInt(prop.getProperty("device_pixelRatio"));
				String userAgent=prop.getProperty("device_userAgent");
				try {
			
				if(!emulator.equalsIgnoreCase("Custom"))
				{
				Map<String, Object> mobileEmulation = new HashMap<>();
			    mobileEmulation.put("deviceName", emulator);
			    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			    driver=new ChromeDriver(chromeOptions);
			    driver.manage().window().maximize();
				}
				else if(emulator.equalsIgnoreCase("Custom"))
				{
				    Map<String, Object> deviceMetrics = new HashMap<>();
					Map<String, Object> mobileEmulation = new HashMap<>();
					
				    deviceMetrics.put("width", width);
				    deviceMetrics.put("height", height);
				    deviceMetrics.put("pixelRatio", pixelRatio);
				    mobileEmulation.put("deviceMetrics", deviceMetrics);
				    mobileEmulation.put("user-agent", userAgent);
				    
				    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
 				    driver = new ChromeDriver(chromeOptions);
				    driver.manage().window().maximize();
					
				}
				else
				{
					System.out.println("Emulator not found");
				}
				}
				catch(InvalidArgumentException e)
				{
					System.out.println("Invalid Device Name "+e.getMessage());
				}

			}
			else if(emulator==null)
			{
			    driver=new ChromeDriver();
			    driver.manage().window().maximize();
			}
			break;

		   default:
			System.out.println("Browser not found");
			break;
		}
		}
			return driver;
		}

	public AndroidDriver launchDevice() throws MalformedURLException
	{
		String platform=prop.getProperty("platform");
		String serverUrl=prop.getProperty("serverUrl");
		String deviceVersion=prop.getProperty("deviceVersion");
		String deviceName=prop.getProperty("deviceName");
		String automationName=prop.getProperty("automationName");
		String appPackage=prop.getProperty("appPackage");
		String appActivity=prop.getProperty("appActivity");
		if(platform.equals("mobile"))
		{
			URL url=new URL(serverUrl);
			DesiredCapabilities cap=new DesiredCapabilities();
			cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, deviceVersion);
			cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
			cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automationName);
			cap.setCapability("appPackage", appPackage);
			cap.setCapability("appActivity", appActivity);
			androidDriver = new AndroidDriver<>(url,cap);
			
		}
		return androidDriver;
	}
	public void killDevice()
	{
		androidDriver.closeApp();
	}
	public void killBrowser() 
	{
		driver.quit();
	}

}

package com.qa.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class util 
{
	public static String resourceDriverPath=null;
	public WebDriver driver;
	
	public util()
	{
		resourceDriverPath=System.getProperty("user.dir"+"src//main//resources//drivers");
	}
	
	public void launchBrowser(String browserType)
	{
		switch (browserType) 
		{
		case "chrome":
			    System.setProperty("webdriver.chrome.driver",resourceDriverPath+"chromedriver.exe");
			    driver=new ChromeDriver();
			    driver.manage().window().maximize();
			break;

		default:
			System.out.println("Browser not found");
			break;
		}
		
	}
	
	
	

}

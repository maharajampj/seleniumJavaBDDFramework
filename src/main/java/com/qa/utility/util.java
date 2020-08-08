package com.qa.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class util {
	public static String resourceDriverPath = null;
	public static String resouceTestDataPath = null;
	public static WebDriver driver;
	Properties prop = setUp.envSetUp();

	public util() {
		resourceDriverPath = System.getProperty("user.dir") + "//src//main//resources//drivers//";
		resouceTestDataPath = System.getProperty("user.dir") + "//TestData//Data.xlsx";
	}

	public WebDriver launchBrowser()
	{		String browser=prop.getProperty("browser");
		String emulator=prop.getProperty("emulator");
		String width=prop.getProperty("device_width");
		String height=prop.getProperty("device_height");

		switch (browser) 
		{
		case "chrome":
		    System.setProperty("webdriver.chrome.driver",resourceDriverPath+"chromedriver.exe");
		    ChromeOptions chromeOptions = new ChromeOptions();
			if(emulator!=null)
			{
				if(!emulator.equals("Custom"))
				{
				Map<String, Object> mobileEmulation = new HashMap<>();
			    mobileEmulation.put("deviceName", emulator);
			    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
			    driver=new ChromeDriver(chromeOptions);
			    driver.manage().window().maximize();
				}
				else if(emulator.equals("Custom"))
				{
				    Map<String, Object> deviceMetrics = new HashMap<>();
					Map<String, Object> mobileEmulation = new HashMap<>();
				    deviceMetrics.put("width", width);
				    deviceMetrics.put("height", height);
				    deviceMetrics.put("user-agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1");
				    mobileEmulation.put("deviceMetrics", deviceMetrics);
				    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
 				    driver = new ChromeDriver(chromeOptions);
				    driver.manage().window().maximize();
					
				}
				else
				{
					System.out.println("Emulator not found");
				}

			}
			else if(emulator==null)
			{
			    driver=new ChromeDriver(chromeOptions);
			    driver.manage().window().maximize();
			}
			break;

		   default:
			System.out.println("Browser not found");
			break;
		}
			return driver;
		}

	public void killBrowser() {
		driver.quit();
	}

}

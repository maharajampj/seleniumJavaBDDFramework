package testCases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class base 
{

	public static AndroidDriver<AndroidElement> main() throws MalformedURLException
	{
		File f=new File("src");
		File appPath=new File(f,"\\main\\resources\\apps\\Test.apk");
		URL url=new URL("http:127.0.0.1:4723/wd/hub");
		DesiredCapabilities cap=new DesiredCapabilities();
		//cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		//cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "4.4.2");
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		//cap.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
		cap.setCapability("appPackage", "com.androidsample.generalstore");
		cap.setCapability("appActivity", "com.androidsample.generalstore.SplashActivity");
		//cap.setCapability("appPackage", "com.android.calculator2");
		//cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(url,cap);
		return driver;
	
	}
}
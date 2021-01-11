package testCases;

import java.net.MalformedURLException;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class click extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=base.main();
		
		driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();
		driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();
		driver.findElementById("android:id/checkbox").click();
		driver.findElementByXPath("(//android.widget.RelativeLayout)[2]").click();
		driver.findElementByClassName("android.widget.EditText").sendKeys("Maha");
		driver.findElementsByClassName("android.widget.Button").get(1).click();

	}

}

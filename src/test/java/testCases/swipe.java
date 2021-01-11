package testCases;

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


public class swipe extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=base.main();
		
		driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
		driver.findElementByAndroidUIAutomator("text(\"Date Widgets\")").click();
		driver.findElementByAccessibilityId("2. Inline").click();
		WebElement element1=driver.findElementByXPath("//*[@text='12']");
		WebElement element2=driver.findElementByXPath("//*[@text='1']");
		TouchAction t=new TouchAction(driver);
		t.longPress(longPressOptions().withElement(element(element1)).withDuration(ofSeconds(2))).moveTo(element(element2)).release().perform();
		driver.closeApp();

	}

}

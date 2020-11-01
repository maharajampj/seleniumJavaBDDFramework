package testCases;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.TapOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;


public class miscellaneous extends base{

	public static void main(String[] args) throws MalformedURLException 
	{
		AndroidDriver<AndroidElement> driver=base.main();
		
	System.out.println(driver.currentActivity());
	System.out.println(driver.getContext());
	System.out.println(driver.getOrientation());
	System.out.println(driver.isDeviceLocked());
	driver.findElementByAndroidUIAutomator("text(\"Views\")").click();
	//driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_DOWN));
	//driver.pressKey(new KeyEvent(AndroidKey.BRIGHTNESS_DOWN));
	driver.pressKey(new KeyEvent(AndroidKey.BACK));
	
	

	}

}

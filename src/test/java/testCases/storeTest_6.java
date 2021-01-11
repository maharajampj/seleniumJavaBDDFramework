package testCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;



public class storeTest_6 extends base {
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AndroidDriver<AndroidElement> driver = base.main();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Hello");

		driver.hideKeyboard();

		driver.findElement(By.xpath("//*[@text='Female']")).click();

		driver.findElement(By.id("android:id/text1")).click();

		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));");

		// driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new
		// UiSelector().scrollable(true).instance(0)).scrollIntoView(new
		// UiSelector().textMatches(\"" + containedText + "\").instance(0))"));

		driver.findElement(By.xpath("//*[@text='Argentina']")).click();

		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

		
       driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
       driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
       driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

		WebElement checkbox=driver.findElement(By.className("android.widget.CheckBox"));
		TouchAction tc=new TouchAction(driver);
		tc.tap(tapOptions().withElement(element(checkbox))).perform();
		
		WebElement terms=driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		tc.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		WebElement close=driver.findElement(By.id("android:id/button1"));
		tc.tap(tapOptions().withElement(element(close))).perform();
		driver.findElement(By.className("android.widget.Button")).click();
		
		Thread.sleep(5000);
		for(String context:driver.getContextHandles())
		{
			System.out.println(context);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Hello World");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
	}
}

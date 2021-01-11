package testCases;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class storeTest_4 extends base {
	public static void main(String[] args) throws MalformedURLException {
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

		
       String amount1=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText().substring(1);
       String amount2=driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText().substring(1);
       
       double itemtotal=Double.parseDouble(amount1)+Double.parseDouble(amount2);
		
       String billtotal=driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText().substring(1);
       
       System.out.println(itemtotal+"  "+billtotal);
		

		

	}
}

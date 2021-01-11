package com.qa.mobile.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.common.mobileComponents;
import com.qa.common.mobileUi;
import com.qa.common.webUi;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Then;

public class storelandingPage 
{

	 AndroidDriver<AndroidElement> androidDriver ;
     mobileUi ui =new mobileUi();
     mobileComponents mobile=new mobileComponents();
     
	public storelandingPage(AndroidDriver<AndroidElement> androiddriver) 
	{
		this.androidDriver=androiddriver;
		PageFactory.initElements(androiddriver, this);
	}
	
	AndroidElement name=androidDriver.findElement(By.id("com.androidsample.generalstore:id/nameField"));
	AndroidElement female=androidDriver.findElement(By.xpath("//*[@text='Female']"));
	AndroidElement dropdown=androidDriver.findElement(By.id("android:id/text1"));
	AndroidElement argentina=androidDriver.findElement(By.xpath("//*[@text='Argentina']"));
	AndroidElement letShop=androidDriver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop"));
	
	public void shoppingFormSubmission()
	{
		ui.sendKeys(name, "Maha");
		ui.click(female);
		ui.click(dropdown);
		mobile.scrollTillText("Argentina");
		ui.click(argentina);
		ui.click(letShop);
		
		
	}
	
	


}

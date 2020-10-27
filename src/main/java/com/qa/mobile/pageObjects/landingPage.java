package com.qa.mobile.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.common.mobileUi;
import com.qa.common.webUi;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.Then;

public class landingPage 
{

	 AndroidDriver<AndroidElement> androidDriver ;
     mobileUi ui =new mobileUi();
     
	public landingPage(AndroidDriver<AndroidElement> androiddriver) 
	{
		this.androidDriver=androiddriver;
		PageFactory.initElements(androiddriver, this);
	}
	
	
	public  WebElement Register=androidDriver.findElementByXPath("//*[@text='Register']");
	public  WebElement name=androidDriver.findElementByXPath("(//*[@class='android.widget.EditText'])[0]");
	public  WebElement email=androidDriver.findElementByXPath("(//*[@class='android.widget.EditText'])[1]");
	public  WebElement password=androidDriver.findElementByXPath("(//*[@class='android.widget.EditText'])[2]");
	public  WebElement phno=androidDriver.findElementByXPath("(//*[@class='android.widget.EditText'])[3]");
	public WebElement submit=androidDriver.findElementByXPath("//*[@class='android.widget.Button']");
	
	public void clickRegister()
	{
		ui.click(Register);
	}
	
	public void submitRegistration(String username,String useremail,String userpassword,String userphno)
	{
		ui.sendKeys(name, username);
		ui.sendKeys(email, useremail);
		ui.sendKeys(password, userpassword);
		ui.sendKeys(phno, userphno);
		ui.click(submit);
	}


}

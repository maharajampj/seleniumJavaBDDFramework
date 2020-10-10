package com.qa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.common.ui;

public class landingPage 
{

	 WebDriver driver ;
     ui ui =new ui();
     
	public landingPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//a[@id='contact-us']")
	public  WebElement contactUsBtn;
	
	public void ClickContactUs() 
	{
		ui.click(contactUsBtn);
		
		
	}


}

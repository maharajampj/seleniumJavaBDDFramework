package com.qa.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.common.ui;

public class contactUsPage 
{
	 WebDriver driver;
      ui ui =new ui();
      
	public contactUsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ul[@class='navbar-nav side-navbar']")
	public  WebElement sideNavBar;

}

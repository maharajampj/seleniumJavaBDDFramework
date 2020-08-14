package com.qa.pageObjects;

import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;
import com.qa.common.ui;

public class contactUsPage 
{
	 WebDriver driver;
      ui ui =new ui();
      Faker faker=new Faker();
      
	public contactUsPage(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//ul[@class='navbar-nav side-navbar']")
	public  WebElement sideNavBar;
	@FindBy(id = "contact-us")
	public  WebElement contactUsBtn;
	@FindBy(name = "first_name")
	public  WebElement firstName;
	@FindBy(name = "last_name")
	public  WebElement lastName;
	@FindBy(name = "email")
	public  WebElement email;
	@FindBy(name = "message")
	public  WebElement message;
	@FindBy(xpath = "//input[@value='RESET']")
	public  WebElement resetBtn;
	@FindBy(xpath = "//input[@value='SUBMIT']")
	public  WebElement submitBtn;
	@FindBy(id = "contact_reply")
	public  WebElement thankYou;
	@FindBy(xpath = "(/html/body/text())[3]")
	public  WebElement invalidEmailError;
	
	

	public void submitContactForm(String action)
	{
		ui.sendKeys(firstName, faker.name().firstName());
		ui.sendKeys(lastName, faker.name().lastName());
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
		ui.sendKeys(email, saltStr+"@mail.com");
		ui.sendKeys(message, faker.address().fullAddress());
		if(action.equalsIgnoreCase("submit"))
		{
			ui.click(submitBtn);
		}
		else if(action.equalsIgnoreCase("reset"))
		{
			ui.click(resetBtn);
		}
		else
		{
			System.out.println("Wrong ACTION performed");
		}
	}
	public void ValidateSuccessSubmission()
	{
	
		Assert.assertTrue(ui.isDisplayed(thankYou));
	}
	public void ValidateinvalidEmailSubmission()
	{
	if(!ui.getText(invalidEmailError).contains("Invalid email address"))
	{
		Assert.fail("Email Error Message is Wrong");
	}
	}
}

package com.qa.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.imageio.ImageIO;
import javax.swing.tree.RowMapper;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.utility.util;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class webComponents extends util 
{
	webUi ui = new webUi();

	public void scrollToElement(WebElement element)
	{
		if (ui.isDisplayed(element)) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	}

	public void loadApp(String url) 
	{
		driver.get(url);
	}

	public void CompareUrl(String url) {
		Assert.assertEquals(driver.getCurrentUrl(), url, "The URL is not matching");
	}

	public void CompareTitle(String title) {

		if (driver.getTitle().contains(title)) 
		{
			System.out.println("Title matches :"+title);
		}
		else
		{
			Assert.fail("Title is not matching");
		}

	}
	
	public void switchLastWindow()
	{
		List<String> windows=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(windows.get(windows.size()-1));
		//driver.switchTo().window(windows.get(0));
	}
	public void switchWindow(String title)
	{
		boolean flag=false;
		List<String> windows=new ArrayList<String>(driver.getWindowHandles());
		for(String window:windows)
		{
			driver.switchTo().window(window);
			if(driver.getTitle().equals(title))
			{
				flag=true;
				break;
			}

		}
		if(flag)
		{
			System.out.println("No Such Window Exits : "+title);
		}
		
	}

	public void pressEnter() {
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void pressTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public void pressDownArrow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	public void pressLeftArrow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}

	public void openDuplicateTab() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F6);
		robot.keyRelease(KeyEvent.VK_F6);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public void closeTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_W);
	}

	public void openNewTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}

	public void performBackspace() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	public void pageRefresh() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
	}

	public void pageZoomOut(int noOfTimes) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < noOfTimes; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public void pageZoomIn(int noOfTimes) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < noOfTimes; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_ADD);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public static void pasteFromClipboard() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
	public void compareImage(String path) throws IOException
	{
		Screenshot img1=new AShot().takeScreenshot(driver);
		System.out.println(System.getProperty("user.dir"));
		ImageIO.write(img1.getImage(), "png", new File(System.getProperty("user.dir")+"\\src\\main\\resources\\imageReference\\sc1.jpeg"));
		//BufferedImage img2=ImageIO.read(new File(System.getProperty("user.dir")+"main\\resources\\imageReference\\sc1.jpeg"));
		//ImageDiffer imageDiff=new ImageDiffer();
		
	}
	
}

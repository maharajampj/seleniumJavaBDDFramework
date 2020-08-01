package com.qa.common;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.tree.RowMapper;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.utility.util;

public class components extends util
{
	ui ui=new ui();
	

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
	public void CompareUrl(String url)
	{
		Assert.assertEquals(driver.getCurrentUrl(), url, "The URL is not matching");
	}
	public void CompareTitle(String title)
	{

		Set<String> windows=driver.getWindowHandles();
		for(String window:windows)
		{
			driver.switchTo().window(window);
			if(driver.getTitle().contains(title))
			{
			  System.out.println("Title matches");
			}
		}

		
	}
	public List<String> getTestData(String sheetName,String coloumnName) throws IOException
	{
		    List<String> list=new ArrayList<String>();
		    FileInputStream file = new FileInputStream(new File(resouceTestDataPath));
	        XSSFWorkbook workbook = new XSSFWorkbook(file);
	        XSSFSheet sheet = workbook.getSheet(sheetName);
	        XSSFRow row = sheet.getRow(0);
	        int minColIx = row.getFirstCellNum(); 
	        int maxColIx = row.getLastCellNum(); 
	        int minRowIx=sheet.getFirstRowNum();
	        int maxRowIx=sheet.getLastRowNum();
	        
	        for(int colIx=minColIx; colIx<=maxColIx; colIx++) 
	        { 
	        	   XSSFCell cell = row.getCell(colIx); 
	        	if (cell != null) 
	        	{
	        	   if(cell.getStringCellValue().trim().equals(coloumnName))
	        	   {
	        		   int cellId=cell.getColumnIndex();
					
					 for(int rowIx=minRowIx+1;rowIx<=maxRowIx;rowIx++) 
					 {
						 XSSFCell cell1=sheet.getRow(rowIx).getCell(cellId);
						 list.add(cell1.getStringCellValue());
					  
					 }
					 
					 
	        	   }
	        	}
	        	 
	        }
	        workbook.close();
	        return list;
	}
	public void pressEnter() 
	{
		try
		{
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

	public void pressTab() throws AWTException  {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
	}

	public  void pressDownArrow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
	}

	public  void pressLeftArrow() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_LEFT);
		robot.keyRelease(KeyEvent.VK_LEFT);
	}

	public  void openDuplicateTab() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F6);
		robot.keyRelease(KeyEvent.VK_F6);
		robot.keyPress(KeyEvent.VK_ALT);
		robot.keyPress(KeyEvent.VK_ENTER);
	}

	public  void closeTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_W);
	}

	public  void openNewTab() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
	}

	public  void performBackspace() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);
	}

	public  void pageRefresh() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_F5);
		robot.keyRelease(KeyEvent.VK_F5);
	}

	public  void pageZoomOut(int noOfTimes) throws AWTException {
		Robot robot = new Robot();
		for (int i = 0; i < noOfTimes; i++) {
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_SUBTRACT);
			robot.keyRelease(KeyEvent.VK_CONTROL);
		}
	}

	public  void pageZoomIn(int noOfTimes) throws AWTException {
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
}

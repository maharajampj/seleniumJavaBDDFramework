package com.qa.common;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;

public class webUi {
	public boolean isDisplayed(WebElement element) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {

		}
		return flag;
	}

	public boolean isEnabled(WebElement element) {
		boolean flag = false;
		try {
			flag = element.isEnabled();
		} catch (Exception e) {

		}
		return flag;
	}

	public boolean isSelected(WebElement element) {
		boolean flag = false;
		try {
			flag = element.isSelected();
		} catch (Exception e) {

		}
		return flag;
	}

	public void click(WebElement element) {
		if (isDisplayed(element)) {
			element.click();
		}
	}

	public void sendKeys(WebElement element, String txt) {
		if (isDisplayed(element)) {
			element.sendKeys(txt);
		}
	}

	public void submit(WebElement element) {
		if (isDisplayed(element)) {
			element.submit();
		}
	}

	public String getTagName(WebElement element) {
		String temp = null;

		if (isDisplayed(element)) {
			temp = element.getTagName();
		}
		return temp;
	}

	public String getText(WebElement element) {
		String temp = null;

		if (isDisplayed(element)) {
			temp = element.getText();
		}
		return temp;

	}

	public List<String> getTexts(List<WebElement> elements) {
		ArrayList<String> temp = new ArrayList<String>();

		for (WebElement element : elements) {
			temp.add(getText(element));
		}
		
		return temp;
	}

}

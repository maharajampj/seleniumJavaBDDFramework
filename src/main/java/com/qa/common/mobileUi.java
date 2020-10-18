package com.qa.common;

import java.util.ArrayList;
import java.util.List;

import io.appium.java_client.android.AndroidElement;

public class mobileUi 
{
	public boolean isDisplayed(AndroidElement element) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {

		}
		return flag;
	}

	public boolean isEnabled(AndroidElement element) {
		boolean flag = false;
		try {
			flag = element.isEnabled();
		} catch (Exception e) {

		}
		return flag;
	}

	public boolean isSelected(AndroidElement element) {
		boolean flag = false;
		try {
			flag = element.isSelected();
		} catch (Exception e) {

		}
		return flag;
	}

	public void click(AndroidElement element) {
		if (isDisplayed(element)) {
			element.click();
		}
	}

	public void sendKeys(AndroidElement element, String txt) {
		if (isDisplayed(element)) {
			element.sendKeys(txt);
		}
	}

	public void submit(AndroidElement element) {
		if (isDisplayed(element)) {
			element.submit();
		}
	}

	public String getTagName(AndroidElement element) {
		String temp = null;

		if (isDisplayed(element)) {
			temp = element.getTagName();
		}
		return temp;
	}

	public String getText(AndroidElement element) {
		String temp = null;

		if (isDisplayed(element)) {
			temp = element.getText();
		}
		return temp;

	}

	public List<String> getTexts(List<AndroidElement> elements) {
		ArrayList<String> temp = new ArrayList<String>();

		for (AndroidElement element : elements) {
			temp.add(getText(element));
		}
		
		return temp;
	}

}

package com.crmpro.pages;

import org.apache.commons.math3.analysis.function.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.generics.Baseclass;

public class Homepage extends Loginpage {
	
	public Homepage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@onclick='addHomeBoxPanel();']")
	private static WebElement AddBox;
	
	public void ClickOnAddBox()
	{
		AddBox.click();
	}
}

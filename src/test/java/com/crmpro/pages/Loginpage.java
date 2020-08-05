package com.crmpro.pages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.remote.server.handler.interactions.touch.Scroll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmpro.generics.Baseclass;

public class Loginpage extends Baseclass {

	//WebDriver driver;
//	public Loginpage()
//	{
//		PageFactory.initElements(driver, this);
//	}
	
	public Loginpage()
	{
		//this.driver = driver;
		super();
	}
	
	@FindBy(xpath="//input[@type='text']")
	public static WebElement user_name;
	
	@FindBy(xpath="//input[@type='password']")
	public static WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	public static WebElement Login_btn;
	
	public void login(String username, String passwd) throws IOException
	{	
		user_name.sendKeys(username);
		password.sendKeys(passwd);
	}
	
	public void clickLogin()
	{	
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Login_btn);        
	}
	
	public String ValidateLoginPageTitle()
	{
		return driver.getTitle();		
	}
	
}

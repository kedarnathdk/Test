package com.crmpro.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.crmpro.generics.Baseclass;
import com.crmpro.pages.Loginpage;

public class Loginpagetest extends Baseclass {
	
		Loginpage logpage = new Loginpage();
	 Loginpage lp = PageFactory.initElements(driver, Loginpage.class);
	public Loginpagetest()
	{	
		super();
		this.driver = driver;
		
	}
	
	@Test(priority=0)
	public void Verifylogin() throws IOException
	{	
		Precondition();
		System.out.println("driver = " + driver);
		logpage.login(propFile.getProperty("username"), propFile.getProperty("password"));
		//logpage.login("Batchautomation", "Test@12345");
		lp.clickLogin();
}	

	@Test
	public void Verifylogin1() 
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Batchautomation");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement Login_btn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Login_btn);   
	}
//	@Test(priority=1, enabled=true)
//	public void verifyLoginPageTitle()
//	{
//	try
//	{
//		String title = lp.ValidateLoginPageTitle();
//		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
//		//return title;
//	}
//	catch(NullPointerException e)
//	{
//		e.printStackTrace();
//	}
	
	

/*	@AfterMethod
	public void tearUp()
	{
		driver.quit();
	}*/
	}


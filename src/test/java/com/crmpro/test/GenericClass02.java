package com.crmpro.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.crmpro.generics.Baseclass;

public class GenericClass02 extends Baseclass{
	 
	@Test(priority=0)
	public void verify_contact_creation() throws InterruptedException, IOException
	{	
		ExtentHtmlReporter extent_Report = new ExtentHtmlReporter("./ExtentReport/FreeCRMPro.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(extent_Report);
		ExtentTest logger=extent.createTest("Verify_Contact_Creation");
		logger.log(Status.INFO, "Processing smoothly");
		logger.log(Status.PASS, "Testcase Passed");
		logger.pass("passed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\hp").build());
		extent.flush();
				
		Precondition();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Batchautomation");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement Login_btn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Login_btn);  
        Thread.sleep(5000);
		ExtentTest logger1=extent.createTest("Verify_Contact_Creation");
		logger1.log(Status.FAIL, "Processing smoothly");
		//logger1.log(Status.PASS, "Testcase Passed");
		logger1.fail("Failed", MediaEntityBuilder.createScreenCaptureFromPath("C:\\Users\\hp").build());
		extent.flush();
				
		
        driver.switchTo().frame("mainpanel");
		WebElement contacts=driver.findElement(By.xpath("//a[@title='Contacts'] | //a[contains(text(), 'Contacts')]"));
		contacts.click();
		List<WebElement> all_Checkboxes=driver.findElements(By.xpath("//input[@name='contact_id' and @type='checkbox']"));
		int size = all_Checkboxes.size();
		System.out.println(size);
		for(int i=0; i<=size-1; i++)
		{
			WebElement a=all_Checkboxes.get(i);
			String s=a.getAttribute("value");
			System.out.println(s);
			driver.findElement(By.xpath("/"));
		}
	}

}

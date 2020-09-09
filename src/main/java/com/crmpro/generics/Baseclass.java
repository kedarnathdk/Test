package com.crmpro.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.log4testng.Logger;

public class Baseclass implements Constants
{
		public static WebDriver driver;
		public static Properties propFile;	
		public static Logger logger = Logger.getLogger(Class.class.getClass());
		public String a;
		
		public void Precondition()
		{
		try
		{
			propFile = new Properties();
			FileInputStream fis = new FileInputStream("F:\\JAVA\\FreeCRMPro\\src\\main\\java"
					+ "\\com\\freecrm\\config\\config.properties");
			propFile.load(fis);
			PropertyConfigurator.configure("F:\\JAVA\\FreeCRMPro\\src\\main\\java\\com\\freecrm\\config\\log4j.properties");
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Exception catched");
			e.printStackTrace();
		}
		catch(IOException e)
		{
			System.out.println("Exception catched");
			e.printStackTrace();
		}
		
			
			String browser = propFile.getProperty("browser").toLowerCase();	
			
			if(browser.equals("chrome"))
			{
				System.setProperty(CHROME_KEY, CHROME_VALUE);
				driver = new ChromeDriver();
			}
			else if(browser.equals("firefox"))
			{
				System.setProperty(FIREFOX_KEY, FIREFOX_VALUE);
				driver = new FirefoxDriver();
			}
			else
				logger.info("No Browser available");
			
			
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			
			driver.get(propFile.getProperty("url"));
		
	
	}


}

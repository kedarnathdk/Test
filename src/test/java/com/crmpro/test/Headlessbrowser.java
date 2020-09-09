package com.crmpro.test;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Headlessbrowser{
	
	public static void main(String[] args) {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\FreeCRMPro\\Drivers\\chromedriver.exe");
		
		ChromeOptions options = new ChromeOptions();
		//options.addArguments("window-size=1400,800");
		//options.addArguments("headless");
//		options.setExperimentalOption("excludeSwitches",
//			    Arrays.asList("disable-popup-blocking"));
		options.addArguments("--disable-popup-blocking");
		driver = new ChromeDriver(options);
		driver.get("https://www.naukri.com/");
		System.out.println(driver.getTitle());
		
		
		
	}

	
}

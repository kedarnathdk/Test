package com.crmpro.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import junit.framework.Assert;

public class Verifytableinascendingorder {
	
	WebDriver driver;
	
	public void verifyascendingorder()
	{
		
		ArrayList actuallist = new ArrayList();
		List<WebElement> al= driver.findElements(By.xpath(""));
		
		for(WebElement ele:al)
		{
			String value = ele.getText();
			actuallist.add(value);
	}
		ArrayList al1 = new ArrayList();
		
		al1.addAll(actuallist);
		
		Collections.sort(al1);
		
		Assert.assertEquals(actuallist, al1);

}
}

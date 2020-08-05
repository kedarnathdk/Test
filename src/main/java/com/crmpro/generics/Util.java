package com.crmpro.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Util extends Baseclass{
	
	//WebDriver driver;
	
	public void action(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		//added
	}
}

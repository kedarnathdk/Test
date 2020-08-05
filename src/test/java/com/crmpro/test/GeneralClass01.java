package com.crmpro.test;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crmpro.generics.Baseclass;

public class GeneralClass01 extends Baseclass {
	


	@BeforeMethod
	public void setup()

	{
		Precondition();
	}
	
//	@Test
//	public void login()
//	{
//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Batchautomation");
//		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
//		//driver.findElement(By.xpath("//input[@type='submit']")).click();
//		WebElement Login_btn = driver.findElement(By.xpath("//input[@type='submit']"));
//        js.executeScript("arguments[0].click();", Login_btn);
//		
//	}
	@Test(priority=1)
	public void Verifylogin1() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Batchautomation");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Test@12345");
		//driver.findElement(By.xpath("//input[@type='submit']")).click();
		WebElement Login_btn = driver.findElement(By.xpath("//input[@type='submit']"));
		JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", Login_btn);  
        int total_frames= driver.findElements(By.tagName("frame")).size();  
        System.out.println("Total frames =" + total_frames);
//        driver.switchTo().frame(1);
//        Thread.sleep(4000);
        WebElement frameelement=driver.findElement(By.xpath("//frame[@name='mainpanel']"));
        driver.switchTo().frame(frameelement);
       WebElement Addbox = driver.findElement(By.xpath("//div[@id='navMenu']//following-sibling::li[1]//a[contains(text(), 'Add Boxes»')]"));
       Addbox.click();
//       WebElement dropdown01 = driver.findElement(By.id("box_id"));
//       Select s= new Select(dropdown01);
//       s.selectByVisibleText("Tag List");

       WebElement Addbutton=driver.findElement(By.xpath("//input[@title='Add New Box']"));
       js.executeScript("arguments[0].click();", Addbutton);
       
       List<WebElement> dropdown = driver.findElements(By.id("box_id"));
       for(WebElement options:dropdown)
      {
    	  if(options.getText().equals("This Week Overview"))
    		  options.click(); 
    	  
      }     
	}

	@Test(priority=2, enabled=true)
	public void Create_New_Contact() throws InterruptedException
	{
		Verifylogin1();
		 WebElement Contacts = driver.findElement(By.xpath("//a[@title='Contacts']"));	  
		 Actions act = new Actions(driver);
	     act.moveToElement(Contacts).build().perform();
	     WebDriverWait wait = new WebDriverWait(driver, 10);
	     WebElement ele1 =  driver.findElement(By.xpath("//a[@title='New Contact']"));
	     //wait.until(ExpectedConditions.visibilityOf(ele1));
	     Thread.sleep(3000);
	     ele1.click();
	     WebElement Title_dropdown = driver.findElement(By.xpath("//select[@name='title' and @class='select']"));
	     Select s = new Select(Title_dropdown);
	     s.selectByVisibleText("Dr.");
//	    List<WebElement> Title_dropdown1 = driver.findElements(By.xpath("//select[@name='title' and @class='select']"));
//	    for(WebElement options1:Title_dropdown1) 
//	    {
//	    	if(options1.getText().equals("Miss"))
//	    		options1.click();	    	
//	    }
	    
	    driver.findElement(By.name("first_name")).sendKeys("Kedar");
	    driver.findElement(By.name("surname")).sendKeys("D K");
	    driver.findElement(By.name("image_file")).sendKeys("C:\\Users\\hp\\Desktop\\SantoshKumarKamila[3_1].docx");
	    Thread.sleep(5000);
	    WebElement Save_button=driver.findElement(By.xpath("//tr//following-sibling::td[1]//input[@type='submit' and @value='Save']"));
	    WebElement Company_lookup=driver.findElement(By.xpath("//tr[8]//td[2]//input[4]"));
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].click();", Company_lookup);
	   // Company_lookup.click();
	   //Alert a = driver.switchTo().alert();
	   String parent_Window= driver.getWindowHandle();
	  Set<String> all_Windows= driver.getWindowHandles();
	  
	  System.out.println(all_Windows.size());
	  
	  for(String child:all_Windows)
	  {
		  if(!parent_Window.equalsIgnoreCase(child))
		  {	
			   driver.switchTo().window(child);
			   driver.findElement(By.name("search")).sendKeys("TCS");
			   driver.findElement(By.xpath("//input[@type='submit']")).click();
			   Thread.sleep(3000);
			   driver.findElement(By.xpath("//a[contains(text(), 'Tcs')]")).click();
			  // driver.close();
			   break;
		  }
		  System.out.println("Frame is"+child);
	  }	  
	  driver.switchTo().window(parent_Window);
	  Thread.sleep(3000);
	  //driver.navigate().refresh();

	  List<WebElement> radio_Buttons = driver.findElements(By.xpath("//input[@type='radio']"));
	  int size = radio_Buttons.size();
	  System.out.println(size);

	  for(int i=0; i<size; i++)
	  {
		  WebElement r1=radio_Buttons.get(i);
		  String s1 = r1.getAttribute("Value");
		  System.out.println("VAlue of radio button is "+s1);
		  
		  if(s1.equalsIgnoreCase("n"))
		  {
			  r1.click();
		  }
		  
	  }
	  //driver.findElement(By.xpath("//input[@name='receive_email'][2]")).click();
	  Save_button.click();	
	  
	}

}
	


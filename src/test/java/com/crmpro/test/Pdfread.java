package com.crmpro.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.openqa.selenium.WebDriver;

public class Pdfread {
	
	public static void main(String[] args) throws FileNotFoundException {
	WebDriver driver;
/*		System.setProperty("webdriver.chrome.driver", "F:\\JAVA\\FreeCRMPro\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("file:///D:/Pen%20drive/Kedar2/PF%20PASSBOOKS/IKYA%20PASSBOOK.pdf");
		String currentUrl = driver.getCurrentUrl();
		
		URL url = new URL(currentUrl);
		
		InputStream is = url.openStream();
		
		BufferedInputStream bis = new BufferedInputStream(is);
		
		PDDocument document;
		
		document = PDDocument.load(bis);
		String pdfcount = new PDFTextStripper().getText(document);
		System.out.println(pdfcount);*/
		String filename = "./evening_arati.pdf";
		Pdfread read = new Pdfread();
		read.PDFreader1(filename);
		ArrayList list = new ArrayList();
		list.
		
		HashMap<Object, Object> map = new HashMap<Object, Object>();
		map.
		
		
		
		
		
		
		
	}

	
	public void PDFreader1(String filepath) throws FileNotFoundException
	{
		
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		
		PDDocument doc = null;
		
		try
		{
			doc = PDDocument.load(fis);
			String output = new PDFTextStripper().getText(doc);
			System.out.println(output);
		
		}
		catch(Exception e)
		{
			e.printStackTrace();		
		}
	}

}

package com.crmpro.test;

import org.testng.annotations.Test;

import com.crmpro.generics.Baseclass;
import com.crmpro.pages.Homepage;

public class HomepageTest extends Loginpagetest {

	Homepage hmepage = new Homepage();
	
	public HomepageTest()
	{
		super();
	}
	
	@Test
	public void VerifyClickOnAddBox()
	{
		hmepage.ClickOnAddBox();
	}
	
}

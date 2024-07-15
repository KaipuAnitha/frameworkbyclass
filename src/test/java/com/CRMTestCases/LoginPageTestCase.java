package com.CRMTestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTestCase extends BaseClass
{
	
	public WebDriver driver;
	
	@BeforeClass
	public void pageSetUp()
	{
	 hp.getStatusOfLink();
	}
	
  @Test
  public void validateLogin() 
  {
	  lp.doLogin("jeevansh@gmail.com", "abcd");
	  Assert.assertTrue(driver.getCurrentUrl().contains("customers"),"Test fail..Login failed");
	  System.out.println("Test pass..Login completed");
  }
}

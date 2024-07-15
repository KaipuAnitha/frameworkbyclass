package com.CRMTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTestCase extends BaseClass
{
	public WebDriver driver;
	
	
  @Test(priority=1)
  public void verifyUrl()
{
  String link =  hp.getAppUrl();
  Assert.assertTrue(link.contains("crm"),"Test fail...url not matched");
  System.out.println("Tess pass...url matched");
	   
  }
  
  @Test(priority=2)
  public void verifyTitle()
{
  String actTitle =  hp.getAppTitle();
  Assert.assertTrue(actTitle.contains("Customer"),"Test fail...Title not matched");
  System.out.println("Tess pass..Title matched");
	   
  }
  
  @Test(priority=3)
  public void validateSignInLink()
{
  String nextPageLink=hp.getStatusOfLink();
  Assert.assertTrue(nextPageLink.contains("login"),"Test fail...user not navigated to Login page");
  System.out.println("Test pass... user navigated to login page");
	   
  }
}

package com.CRmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage 
{
	private WebDriver driver;
	
	

	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators
	By link= By.id("SignIn");
	
	//methods
	public String  getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	
	public String  getAppTitle()
	{
		return driver.getTitle();
	}
	
	public String getStatusOfLink()
	{
		driver.findElement(link).click();
		return driver.getCurrentUrl();
	}

}

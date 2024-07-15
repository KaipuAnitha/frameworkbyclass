package com.CRmPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public  class LoginPageClass 
{
	private WebDriver driver;
	
	public LoginPageClass(WebDriver driver) 
	{
		this.driver=driver;
	}
	
	//locator
	By email=By.id("email-id");
	By password =By.id("password");
	By btn=By.id("submit-id");
	
	//methods
	public String doLogin(String un,String psw)
	{
		driver.findElement(email).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(btn).click();
		return driver.getCurrentUrl();
	}

}

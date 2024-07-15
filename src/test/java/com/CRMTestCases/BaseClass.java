package com.CRMTestCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.CRmPages.HomePage;
import com.CRmPages.LoginPageClass;



public class BaseClass 
{
	public WebDriver driver;
	public HomePage hp;
	public LoginPageClass lp;
	
	
	@BeforeTest
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationplayground.com/crm/");
		
		hp = new HomePage(driver);
		lp = new LoginPageClass(driver);
		
	}
	

}

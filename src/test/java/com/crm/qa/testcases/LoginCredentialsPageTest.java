package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;

public class LoginCredentialsPageTest extends TestBase{

	LoginCredentialsPage logincredential;
	HomePage homePage;
	LoginPage loginPage;
	
	public LoginCredentialsPageTest()
	{
		super();
	}	
	
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage=new LoginPage();
		logincredential=loginPage.validateLoginLink();
		
	}
	
	@Test(priority=1)
	
	public void validateLoginCredentialsPageTitleTest()
	{
		String s=logincredential.validateLoginCredentialsPageTitle();
		Assert.assertEquals(s, "Cogmento CRM","Title not matched");
	}
	
	@Test(priority=2)
	public void validateLoginCredentialsTest() throws InterruptedException
	{
		
		homePage=logincredential.validateLoginCredentials(prop.getProperty("username"),prop.getProperty("password")); 
		Thread.sleep(5000);
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
}

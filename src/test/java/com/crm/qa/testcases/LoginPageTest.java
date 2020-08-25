package com.crm.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.SignUpPage;


public class LoginPageTest extends TestBase{

	LoginPage loginPage; //make object of LoginPage class to access its methods
	LoginCredentialsPage logincredential;
	SignUpPage signup;
	
	public LoginPageTest() throws IOException{
			super();
	}
	
	@BeforeMethod
	public void setup() throws IOException
	{
		initialization();
		loginPage=new LoginPage();
		logincredential=new LoginCredentialsPage();
		signup =new SignUpPage();
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Free CRM software can boost your sales by 30%");
	
	}
	
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginPage.validateCRMLogo();
		Assert.assertTrue(flag);
	}
		
	@Test(priority=3)
	public void validateLoginLinkTest()
	{
		logincredential=loginPage.validateLoginLink();
			
	}
	
	@Test(priority=4)
	public void validateSignUpLink() 
	{
		signup=loginPage.validateSignUpLink();
		
		
	}
		
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}

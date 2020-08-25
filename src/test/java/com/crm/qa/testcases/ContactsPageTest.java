package com.crm.qa.testcases;

//import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	LoginCredentialsPage logincredential;
	HomePage homePage;
	ContactsPage contacts;
	
	public ContactsPageTest ()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
{
	initialization();
	loginPage=new LoginPage();
	logincredential=loginPage.validateLoginLink();
	homePage=logincredential.validateLoginCredentials(prop.getProperty("username"),prop.getProperty("password"));
    contacts=homePage.validateContactsLink();
	
	
}
	@Test(priority=1)
	public void validateContactsLabelTest()
	{
		Assert.assertTrue(contacts.validateContactsLabel(),"Conatcts label is missing");
		
	}
	@Test(priority=2)
	public void validateCreateNewContact() throws InterruptedException
	{
		contacts.validateNewContactClick();
		contacts.createNewContact("Tom", "Jhonson","PTC","tom@gmail.com");
	/*	contacts.createNewContact("Tony", "Jhon","AMAZON","tony@gmail.com");
		contacts.createNewContact("Tim", "Jason","EBAY","tim@gmail.com");*/
	}
		
	@AfterMethod
	public void tearDown() 
	{
	driver.quit();
	}
}

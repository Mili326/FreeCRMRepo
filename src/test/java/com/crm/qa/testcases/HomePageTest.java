package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CalendarPage;
import com.crm.qa.pages.CompaniesPage;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginCredentialsPage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase{

	
	LoginPage loginPage;
	LoginCredentialsPage logincredential;
	HomePage homePage;
	ContactsPage contacts;
	CompaniesPage companies;
	DealsPage deals;
	TasksPage tasks;
	CalendarPage calendar;
	
	public HomePageTest()
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
	    contacts=new ContactsPage();
	    companies=new CompaniesPage();
	    deals=new DealsPage();
	    tasks=new TasksPage();
	    calendar =new CalendarPage();
	}
	
	@Test(priority=1)
	public void validateUserLabelTest() throws InterruptedException
	{
	    boolean label=	homePage.validateUserLabel();
	    Assert.assertTrue(label, "User name is not displayed");
	   
	}
	@Test(priority=2)
	public void validatecalendarLinkTest()
	{
		calendar=homePage.validatecalendarLink();
	}
	
	@Test(priority=3)
	public void validateContactsLinkTest() throws InterruptedException
	{
		contacts=homePage.validateContactsLink();
		
	}
	@Test(priority=4)
	public void validateCompaniesLinkTest() throws InterruptedException
	{
		companies=homePage.validateCompaniesLink();
		Thread.sleep(1000);
		
	}
	@Test(priority=5)
	public void validateDealsLinkTest() throws InterruptedException
	{
		deals=homePage.validateDealsLink();
		Thread.sleep(1000);
		
	}
	@Test(priority=6)
	public void validateTasksLinkTest() throws InterruptedException
	{
		tasks=homePage.validateTasksLink();
		Thread.sleep(1000);
	}
	@AfterMethod
	public void tearDown()
	{
		//driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
		driver.quit();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

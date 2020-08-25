package com.crm.qa.pages;

//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	//PageFactory -OR(Object repository)
	
	@FindBy(xpath="//span[@class='user-display']")
	@CacheLookup
	WebElement usernameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Calendar')]")
	WebElement calendarLink;
	
	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	
	@FindBy(xpath="//span[contains(text(),'Companies')]")
	WebElement companiesLink;
	
	@FindBy(xpath="//span[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initialize Pagefactory webelements
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean validateUserLabel()
	{
		 return usernameLabel.isDisplayed();
		
	}
	
	public CalendarPage validatecalendarLink()
	{
		 calendarLink.click();
		 return new  CalendarPage();
	}
	public ContactsPage validateContactsLink() {
	/*	JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",contactsLink);*/
				contactsLink.click();
		 return new ContactsPage();
	}
	
	
	public CompaniesPage validateCompaniesLink() {
		companiesLink.click();
		return new CompaniesPage();
	}
	
	public DealsPage validateDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage validateTasksLink() {
		tasksLink.click();
		return new TasksPage();
}
}

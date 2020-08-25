package com.crm.qa.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	//PageFactory -OR(Object repository)
	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//*[(text()='New')]")
	WebElement	newContact;
	
	@FindBy(xpath="//input[@name='first_name']")//(name="first_name")
	WebElement firstName;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastName;
	
	@FindBy(xpath="//div[@name='company']//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath="//input[@name='value' and @placeholder='Email address']")
	WebElement email;
	
	@FindBy(xpath="//button[@class='ui linkedin button']")
	WebElement saveButton;
	
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public boolean validateContactsLabel()
	{
		return contactsLabel.isDisplayed();
		
	}
	
	public void validateNewContactClick()
	{
		newContact.click();
	}
	
	
	public void createNewContact(String ftName, String ltName, String cmpnyName, String eml) throws InterruptedException {
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		company.sendKeys(cmpnyName);
		Thread.sleep(1000);
		email.sendKeys(eml);
		
		/*Select select=new Select(driver.findElement(By.xpath("//div[@name='category']//div[@class='visible menu transition']")));
		select.selectByVisibleText(category);*/
		
		saveButton.click();
		
	}
	
	
	
}

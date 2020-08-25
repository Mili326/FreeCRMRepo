package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginCredentialsPage extends TestBase{

	//PageFactory -OR(Object repository)
	
	@FindBy(xpath="//input[@type='text']")
	WebElement email;
	
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']")
	WebElement loginBtn;
	
	//Initialize the above WebElements
	public LoginCredentialsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	//Actions
	public String validateLoginCredentialsPageTitle() {
		
		return driver.getTitle();
	}

	
	public HomePage validateLoginCredentials(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
		
	}


		

		
		

	
}


package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//PageFactory -OR(Object repository)
	
	//CRM Logo Image
	@FindBy(xpath="//img[@class='img-responsive']")
	WebElement crmLogo;
	
	//LOGIN Link
	@FindBy(xpath="//a[contains(text(),'Log In')]")
	WebElement loginLink;
	
	//SignUp link
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUpLink;
	
	//About Link
/*	@FindBy(xpath="//a[contains(text(),'About')]")
	WebElement aboutLink;
	
	//CRM link
	@FindBy(xpath="//a[contains(text(),'CRM')]")
	WebElement crmLink;
	
	//Apps link
	@FindBy(xpath="//a[contains(text(),'Apps')]")
	WebElement appsLink;
	
	//Compare Link
	@FindBy(xpath="//a[contains(text(),'Compare')]")
	WebElement compareLink;
	*/
	//Pricing link
	@FindBy(xpath="//a[contains(text(),'Pricing')]")
	WebElement pricingLink;
	
	@FindBy(xpath="//a[contains(text(),'Features')]")
	WebElement featuresLink;
	
	@FindBy(xpath="//a[contains(text(),'Customers')]")
	WebElement customersLink;
	
	@FindBy(xpath="//a[contains(text(),'Support')]")
	WebElement supportLink;
	
	
	//ItuneLink
	@FindBy(xpath="//img[@title,'free crm app for itunes']")
	WebElement ituneImg;
	
	//AndroidApp link
	@FindBy(xpath="//img[@title ,'app for freecrm android']")
	WebElement androidAppImg;
	
	
	//Initializing the page objects
	public LoginPage()
	{
		PageFactory.initElements(driver,this);//this refers to curent class 
	}
	
	
	//Actions
	public String validateLoginPageTitle()   //Validate Login page title
	{
		return driver.getTitle();
	}
	
	public boolean validateCRMLogo()      //Validate CRM Logo image is displayed
	{
		return crmLogo.isDisplayed();
	}

	public LoginCredentialsPage validateLoginLink()   //Validate Login Link is clickable
	{
	
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", loginLink);
		
		
	/*	Actions act =  new Actions(driver);
		act.moveToElement(loginLink).click().build().perform();
		//loginLink.click(); */
		return new LoginCredentialsPage();
	}
	 
	public SignUpPage validateSignUpLink()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver; 
		js.executeScript("arguments[0].click();", SignUpLink);
		
		
		
	/*	Actions act =  new Actions(driver);
		act.moveToElement(SignUpLink).click().build().perform();
		//SignUpLink.click(); */
		return new SignUpPage();
	}
	
/*	public AboutPage validateAboutLink()
	{
		aboutLink.click();
		return new AboutPage();
	}
	
	public CRMPage validateCRMLink()
	{
		crmLink.click();
		return new CRMPage();
	}
	
	public AppsPage validateAppsLink()
	{
		appsLink.click();
		return new AppsPage();
		
	}
	
	public ComparePage validateCompareLink()
	{
		compareLink.click();
		return new ComparePage();
		
	} */
	
	public PricingPage validatePricingLink()
	{
		pricingLink.click();
		return new PricingPage();
	}
	
	
}


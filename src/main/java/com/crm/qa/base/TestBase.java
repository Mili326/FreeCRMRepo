package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventlistener;
	
	public TestBase()
	{
		
		//load properties file,catch exception if properties file not found 
		try {
			prop=new Properties(); 
			FileInputStream ip=new FileInputStream("C:/Users/Mrinalini/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
			prop.load(ip); ///reads property list from input byte stream
				
		}catch(FileNotFoundException e) //attempt to open a file denoted by specified filepath has failed
		{e.printStackTrace();
		}catch(IOException e) //general class of exceptions produced by failed or interrupted I/O operations
		{e.printStackTrace();
		}
	}
	
	//Initialize the browser ,open the CRM URL
	public void initialization()
	{
		String browserName=prop.getProperty("browser");//getting the browser name from config properties file
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Users/Mrinalini/eclipse-workspace/FreeCRMTest/Drivers/chromedriver.exe");
			  driver = new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{System.setProperty("webdriver.gecko.driver", "C:/Users/Mrinalini/eclipse-workspace/FreeCRMTest/Drivers/geckodriver.exe");
		  driver = new FirefoxDriver();
			
		}
		
		e_driver=new EventFiringWebDriver(driver);
		//Now create object of EventlistenerHandler to register it with EventFireingWebDriver
		eventlistener=new WebEventListener();
		e_driver.register(eventlistener);
		driver=e_driver;		
		
		
		
		
		driver.manage().window().maximize();    //maximize the window
		driver.manage().deleteAllCookies();     //delete all cookies
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //Sets the amount of time to wait for a page load to complete before throwing an error
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);//Specifies the amount of time the driver should wait when searching for an element
		
		
		
		driver.get(prop.getProperty("url"));
		
	}
	

		
	
	
	
	
	
	
	
	
	
	
	
	
	
}

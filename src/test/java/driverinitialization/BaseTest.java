package driverinitialization;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class BaseTest {
	
	
	@BeforeMethod
	@Parameters({"browserName"})
	public void setUp(String bowserName)
	{
		if(bowserName.equalsIgnoreCase("chrome"))
		{
			System.out.println("Going under chrome");
		System.setProperty("webdriver.chrome.driver", "");
		ThreadLocalDriver.setDriver(new ChromeDriver());
		ThreadLocalDriver.getDriver().get("http://google.com");
		}
		else if(bowserName.equalsIgnoreCase("firefox"))
		{
			System.out.println("Going under firefox");
			System.setProperty("webdriver.gecko.driver", "");
			ThreadLocalDriver.setDriver(new FirefoxDriver());
			ThreadLocalDriver.getDriver().get("http://google.com");
		}
		
		
	}
	@AfterMethod
	 public synchronized void teardown()
	{
		ThreadLocalDriver.getDriver().quit();
	}

}

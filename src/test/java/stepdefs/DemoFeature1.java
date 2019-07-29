package stepdefs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverinitialization.ThreadLocalDriver;
import pagefactory.GoogleHomepagePO;
import utilities.Constants;
import utilities.UtilDemo;
public class DemoFeature1 extends ThreadLocalDriver{
	
	static int row = 1;
	
	@Before
	public void initializaObjects()
	{
		
		System.out.println("Count Value is: "+row);
		row++;
		System.out.println("This is cucumber Before annotation");
		getDriver().manage().window().maximize();
	}
	
	
	@Given("^this is given one \"([^\"]*)\"$")
	public void thisIsGivenOne(String url) throws Throwable {
	   
		getDriver().get(url);
	}


	@When("^this is when one$")
	public void this_is_when_one() throws Throwable {
	   
		Thread.sleep(5000);
	}

	@Then("^this is then one$")
	public void this_is_then_one() throws Throwable {
	   
	}


	 @After
	    public synchronized void teardown () {
	     //   teardown();
	        System.out.println("teardown'a girdi!");
	    }	
	
	
}

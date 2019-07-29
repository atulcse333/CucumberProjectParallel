package stepdefs;

import org.openqa.selenium.By;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import driverinitialization.ThreadLocalDriver;

public class DemoFeature2 extends ThreadLocalDriver{


	
	
	@Given("^this is given two$")
	public void this_is_given_two() throws Throwable {

		getDriver().findElement(By.id("sds")).click();
	}

	@When("^this is when two$")
	public void this_is_when_two() throws Throwable {

	}

	@Then("^this is then two$")
	public void this_is_then_two() throws Throwable {

	}
	@Given("^this is given two_one$")
	public void this_is_given_two_one() throws Throwable {

	}

	@When("^this is when two_one$")
	public void this_is_when_two_one() throws Throwable {

	}

	@Then("^this is then two_one$")
	public void this_is_then_two_one() throws Throwable {

	}
	
	 
}

package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.meta.Exhaustive;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.SnippetType;
import cucumber.api.java.Before;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberScenario;
import driverinitialization.BaseTest;
import gherkin.formatter.model.ScenarioOutline;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

@CucumberOptions(
		
		plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty-chrome",
				"json:target/Chrome/cucumber-report-chrome.json"
		},
		glue = {"driverinitialization","stepdefs"},
		features = {"src/test/resources/suite/features1"},
		monochrome = true,
		snippets = SnippetType.CAMELCASE,
		tags = {"~@ignore"}
		)


public class TestRunner extends BaseTest{

	private TestNGCucumberRunner testNGCucumberRunner;

	//public RoadRunner runner;
	
	
    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
        //runner = new RoadRunner(this.getClass());
        
    }

    @Test(groups = "cucumber", description = "Runs LoginCandiate Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("Cucumber Test Class Inside Test");
       
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
        //runner.runCucumber(cucumberFeature.getCucumberFeature());
        
        
        
    }

    @DataProvider(parallel = true)
    public Object[][] features() {
        System.out.println("Data Provider test Class");
        
        return testNGCucumberRunner.provideFeatures();
      //  return runner.provideFeatures();
        
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
    	//runner.finish();
        File reportOutputDirectory = new File("target/chrome-html");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/Chrome/cucumber-report-chrome.json");
		
		

		String buildNumber = "1";
		String projectName = "cucumberProject";
		boolean runWithJenkins = false;
		boolean parallelTesting = false;

		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
		// optional configuration - check javadoc
		configuration.setRunWithJenkins(runWithJenkins);
		configuration.setBuildNumber(buildNumber);
		// addidtional metadata presented on main page
		configuration.addClassifications("Platform", "Windows");
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("Release", "1811");

		// optionally add metadata presented on main page via properties file
		

		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
		Reportable result = reportBuilder.generateReports();
    }
   /* 
    @AfterSuite
    @Parameters({"browserName"})
    public void generateReport(String browserName)
    {
    	
    	System.out.println("Going inside Suite");
    	if(browserName.equalsIgnoreCase("chrome"))
    	{
    		File reportOutputDirectory = new File("target/chrome-html");
    		List<String> jsonFiles = new ArrayList<>();
    		jsonFiles.add("cucumber-report-chrome.json");
    		

    		String buildNumber = "1";
    		String projectName = "cucumberProject";
    		boolean runWithJenkins = false;
    		boolean parallelTesting = false;

    		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    		// optional configuration - check javadoc
    		configuration.setRunWithJenkins(runWithJenkins);
    		configuration.setBuildNumber(buildNumber);
    		// addidtional metadata presented on main page
    		configuration.addClassifications("Platform", "Windows");
    		configuration.addClassifications("Browser", "Chrome");
    		configuration.addClassifications("Branch", "release/1.0");

    		// optionally add metadata presented on main page via properties file
    		

    		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    		Reportable result = reportBuilder.generateReports();
    	}
    	else if(browserName.equalsIgnoreCase("firefox"))
    	{
    		File reportOutputDirectory = new File("target/firefox-html");
    		List<String> jsonFiles = new ArrayList<>();
    		jsonFiles.add("cucumber-report-firefox.json");
    		

    		String buildNumber = "1";
    		String projectName = "cucumberProject";
    		boolean runWithJenkins = false;
    		boolean parallelTesting = false;

    		Configuration configuration = new Configuration(reportOutputDirectory, projectName);
    		// optional configuration - check javadoc
    		configuration.setRunWithJenkins(runWithJenkins);
    		configuration.setBuildNumber(buildNumber);
    		// addidtional metadata presented on main page
    		configuration.addClassifications("Platform", "Windows");
    		configuration.addClassifications("Browser", "firefox");
    		configuration.addClassifications("Branch", "release/1.0");

    		// optionally add metadata presented on main page via properties file
    		

    		ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
    		Reportable result = reportBuilder.generateReports();
    	}
    }
*/
}

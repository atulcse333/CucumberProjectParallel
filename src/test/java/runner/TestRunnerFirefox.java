package runner;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import driverinitialization.BaseTest;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
@CucumberOptions(
		
		plugin = {"pretty",
                "html:target/cucumber-reports/cucumber-pretty-firefox",
				"json:target/Firefox/cucumber-report-firefox.json"
		},
		glue = {"driverinitialization","stepdefs"},
		features = {"src/test/resources/suite/features1"},
				tags = {"~@ignore"}
		)

public class TestRunnerFirefox extends BaseTest{
	private TestNGCucumberRunner testNGCucumberRunner;

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println("Cucumber Test Class Before");
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
    }

    @Test(groups = "cucumber", description = "Runs LoginCandiate Feature", dataProvider = "features")
    public void feature(CucumberFeatureWrapper cucumberFeature) {
        System.out.println("Cucumber Test Class Inside Test");
        System.out.println(cucumberFeature.getCucumberFeature());
        testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
    }

    @DataProvider(parallel=true)
    public Object[][] features() {
        System.out.println("Data Provider test Class");
        return testNGCucumberRunner.provideFeatures();
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() throws Exception {
        testNGCucumberRunner.finish();
        File reportOutputDirectory = new File("target/firefox-html");
		List<String> jsonFiles = new ArrayList<>();
		jsonFiles.add("target/Firefox/cucumber-report-firefox.json");
		

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

}


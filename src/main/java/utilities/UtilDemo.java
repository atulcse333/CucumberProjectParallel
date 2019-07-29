package utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;


public class UtilDemo extends Constants{
	
	public static void takeScreenShot()
	{
		try
		{
			byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		catch(WebDriverException somePlatformsDontSupportScreenshots)
		{
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}
	
	public static boolean waitForJQueryProcessing(int timeOutInSeconds) { 
        boolean jQcondition = false; 
        try { 
            driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS); // nullify 
                                                                            // implicitlyWait() 
            new WebDriverWait(driver, timeOutInSeconds) { 
            }.until(new ExpectedCondition<Boolean>() { 
 
                public Boolean apply(WebDriver driverObject) { 
                    return (Boolean) ((JavascriptExecutor) driverObject) 
                            .executeScript("return jQuery.active == 0"); 
 
                } 
            }); 
            jQcondition = (Boolean) ((JavascriptExecutor) driver) 
                    .executeScript("return jQuery.active == 0"); 
            System.out.println(jQcondition); 
            driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS); // reset 
                                                                                // implicitlyWait 
            return jQcondition; 
        } catch (Exception e) { 
            e.printStackTrace(); 
        } 
        return jQcondition; 
        
	}

}

package driverinitialization;

import org.openqa.selenium.WebDriver;


public class ThreadLocalDriver {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    
	public synchronized static void setDriver(WebDriver driver) {
        ThreadLocalDriver.driver.set(driver);
    }

    public synchronized static WebDriver getDriver() {
        return driver.get();
    }
}
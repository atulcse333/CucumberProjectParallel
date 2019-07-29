package driverinitialization;

/*import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;*/
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	static WebDriver driver;
	public static void main(String[] args) {
		
		/*try
		{
		WebElement addItem = new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("shell-hdr"))));
		addItem.click();
		
		WebElement search = new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("searchFieldInShell-input-inner"))));
		search.sendKeys("Manage Statistical");
		search.sendKeys(Keys.ENTER);
		WebElement manageStatistical = new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("__tile31-title-inner"))));
		Thread.sleep(8000);
		manageStatistical.click();
		WebElement keyStatistics = new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("application-StatisticalKeyFigure-manageStatisticalKeyFigures-component---fullscreen--fin.co.statisticalkeyfigure.manage.SmartFilterBar-filterItemControl_BASIC-StatisticalKeyFigure-inner"))));
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}*/
		
System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("");
		new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("")))).sendKeys("");
		new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("")))).sendKeys("");
		new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.xpath("")))).click();
		try
		{
			String date = "10/05/2018";
		new WebDriverWait(driver , 90).until(ExpectedConditions.visibilityOf(driver .findElement(By.id("")))).sendKeys(date);
		}
		catch(Exception e)
		{
			e.getMessage();
		}
		
		
		
		
		

	}

}

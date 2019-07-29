package pagefactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomepagePO {
	
	@FindBy(id = "lst-ib")
	public WebElement search;

}

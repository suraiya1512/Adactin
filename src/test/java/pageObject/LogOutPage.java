package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogOutPage extends BasePage{

	public LogOutPage(WebDriver driver)
	{
		super(driver);
	}
		
	@FindBy(xpath="//a[normalize-space()='Click here to login again']")
	WebElement linkLoginAgain;
	
		
	public void loginagain()
	{
		linkLoginAgain.click();	
	}

}

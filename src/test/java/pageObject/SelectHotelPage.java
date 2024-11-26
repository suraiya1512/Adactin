package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectHotelPage extends BasePage{

	public SelectHotelPage(WebDriver driver) 
	{
		super(driver);
			}

	@FindBy(xpath="//input[@id='radiobutton_0']")
	WebElement chkdSelect;
	
	@FindBy(xpath="//input[@id='continue']")
	WebElement btnContinue;
	
	@FindBy(xpath="//input[@id='cancel']")
	WebElement btnCancel;
	
	@FindBy(xpath="//td[normalize-space()='Book A Hotel']")
	WebElement titleBookHotel;
	
	public void SelectHotel()
	{
		chkdSelect.click();
	}
	
	public void Click_Continue()
	{
		btnContinue.click();
	}
	
	public void Click_Cancel()
	{
		btnCancel.click();
	}
	
	public boolean isTitleBookHotelExits()
	{
		return titleBookHotel.isDisplayed();
	}
}

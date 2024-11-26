package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class SearchHotelPage extends BasePage
{

	public SearchHotelPage(WebDriver driver) 
	{
		super(driver);
		
	}

	@FindBy(xpath="//select[@id='location']")
	WebElement drplocation;
	
	@FindBy(xpath="//select[@id='hotels']")
	WebElement drphotels;
	
	@FindBy(xpath="//select[@id='room_type']")
	WebElement drproomtype;
	
	@FindBy(xpath="//select[@id='room_nos']")
	WebElement drpnoofrooms;
	
	@FindBy(xpath="//input[@id='datepick_in']")
	WebElement txtcheckIn;
	
	@FindBy(xpath="//input[@id='datepick_out']")
	WebElement txtcheckout;
	
	@FindBy(xpath="//select[@id='adult_room']")
	WebElement drpAdults;
	
	@FindBy(xpath="//select[@id='child_room']")
	WebElement drpChildren;
	
	@FindBy(xpath="//input[@id='Submit']")
	WebElement btnsearch;
	
	@FindBy(xpath="//input[@id='Reset']")
	WebElement btnreset;
	
	@FindBy(xpath="//input[@id='username_show']")
	WebElement myAccName;
	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement title;
	
	@FindBy(xpath="//a[normalize-space()='Logout']")
	WebElement linklogout;
	
	@FindBy(xpath="//span[@id='checkin_span']")
	public WebElement checkInErrorMsg;
	
	@FindBy(xpath="//span[@id='checkout_span']")
	public WebElement checkOutErrorMsg;
	
	public String actual =driver.getTitle();
	
	
    
	public void selectLocation ()
	{
		 if (drplocation == null) 
		 {
		        throw new IllegalStateException("drplocation is not initialized.");
		    }
		drplocation.click();
		Select location = new Select(drplocation);
		location.selectByVisibleText("London");
	}
	
	public void selectHotels ()
	{
		drphotels.click();
		Select Hotels = new Select(drphotels);
		Hotels.selectByVisibleText("Hotel Sunshine");
	}
	
	public void selectRoomType ()
	{
		drproomtype.click();
		Select RoomType = new Select(drproomtype);
		RoomType.selectByVisibleText("Deluxe");
	}
	
	public void selectNoOfRooms ()
	{
		drpnoofrooms.click();
		Select noofrooms = new Select(drpnoofrooms);
		noofrooms.selectByVisibleText("1 - One");
	}
	
	
	public void checkInDate(String fInDate)
	{
		txtcheckIn.clear();
        txtcheckIn.sendKeys(fInDate);  
    }

     public void checkOutDate(String fOutDate)
     {
    	txtcheckout.clear();
        txtcheckout.sendKeys(fOutDate);
      }

     public void checkInDateLater(String fLInDate)
     {
    	txtcheckIn.clear(); 
        txtcheckIn.sendKeys(fLInDate);  
    }

     public void checkOutDateEarlier(String fLOutDate)
     {
    	txtcheckout.clear(); 
        txtcheckout.sendKeys(fLOutDate); 
      }
	
	public void  selectAdults()
	{
		drpAdults.click();
		Select Adults = new Select(drpAdults);
		Adults.selectByVisibleText("2 - Two");
	}
	
	public void  selectChildren()
	{
		drpChildren.click();
		Select Children = new Select(drpChildren);
		Children.selectByVisibleText("2 - Two");
	}
	
	public void clickSearch()
	{
		btnsearch.click();
	}
	
	public void clickReset()
	{
		btnreset.click();
	}
	
	public boolean isMyAccExists()
	{
		return (myAccName.isDisplayed());
	}
	
	public boolean isTitleExists()
	{
		return (title.isDisplayed());
	}
	
	public boolean isCheckInErrorMsgExists()
	{
		return (checkInErrorMsg.isDisplayed());
	}
	
	public boolean isCheckOutErrorMsgExists()
	{
		return (checkOutErrorMsg.isDisplayed());
	}
	
	public void logout()
	{
		linklogout.click();	
	}
	
	}

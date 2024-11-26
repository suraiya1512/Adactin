package pageObject;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingConfirmationPage extends BasePage
{
 public WebDriverWait wait;
	public BookingConfirmationPage(WebDriver driver) 
	{
		super(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(0));
	}
	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement bookingMsg;
	
	@FindBy(xpath="//input[@id='search_hotel']")
	WebElement btnSearchHotel;
	
	@FindBy(xpath="//input[@id='my_itinerary']")
	WebElement btnitenary;
	
	@FindBy(xpath="//td[@class='login_title']")
	WebElement BookItenaryMsg;
	
	@FindBy(xpath="//input[@id='hotel_name']")
	WebElement hotelName;
	
	@FindBy(xpath="//input[@id='location']")
	WebElement location;
	
	@FindBy(xpath="//input[@id='room_type']")
	WebElement roomType;
	
	@FindBy(xpath="//input[@id='arrival_date']")
	WebElement arrivalDate;
	
	@FindBy(xpath="//input[@id='departure_text']")
	WebElement departureDate;
	
	@FindBy(xpath="//input[@id='total_rooms']")
	WebElement totalRooms;
	
	@FindBy(xpath="//input[@id='adults_room']")
	WebElement adults;
	
	@FindBy(xpath="//input[@id='children_room']")
	WebElement children;
	
	@FindBy(xpath="//input[@id='price_night']")
	WebElement ppNight;
	
	@FindBy(xpath="//input[@id='total_price']")
	WebElement tPrice;
	
	@FindBy(xpath="//input[@id='gst']")
	WebElement gst;
	
	@FindBy(xpath="//input[@id='final_price']")
	WebElement finalPrice;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement fName;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement lName;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement add;
	
	@FindBy(xpath="//input[@id='order_no']")
	WebElement orderNo;
	
		
	public String Verify_HotelName()
	{
		return(hotelName.getAttribute("value"));
	}
	
	public String Verify_Location()
	{
		return(location.getAttribute("value"));
	}	
	
	public String Verify_RoomType()
	{
		return(roomType.getAttribute("value"));
	}	
	
	public String Verify_Arrival()
	{
		return(arrivalDate.getAttribute("value"));
	}
	
	public String Verify_Departure()
	{
		return(departureDate.getAttribute("value"));
	}
	
	public String Verify_TotalRoom()
	{
		return(totalRooms.getAttribute("value"));
	}
	
	public String Verify_Adults()
	{
		return(adults.getAttribute("value"));
	}
	
	public String Verify_Children()
	{
		wait.until(ExpectedConditions.visibilityOf(children));
		return(children.getAttribute("value"));
	}
	
	public String Verify_ppNight()
	{
		wait.until(ExpectedConditions.visibilityOf(ppNight));
		return(ppNight.getAttribute("value"));
	}
	
	public String Verify_tPrice()
	{
		wait.until(ExpectedConditions.visibilityOf(tPrice)); 
		return(tPrice.getAttribute("value"));
	}
	
	public String Verify_gst()
	{
		return(gst.getAttribute("value"));
	}
	
	public String Verify_finalPrice()
	{
		return(finalPrice.getAttribute("value"));
	}
	
	public String Verify_firstName()
	{
		return(fName.getAttribute("value"));
	}
	
	public String Verify_lastName()
	{
		return(lName.getAttribute("value"));
	}
	
	public String Verify_address()
	{
		return(add.getAttribute("value"));
	}
	
	public boolean OrderNoExists()
	{
		return(orderNo.isDisplayed());
	}
		
	public boolean isBookingMsgExists()
	{
		return(bookingMsg.isDisplayed());
	}
	
	public void searchHotel()
	{
		btnSearchHotel.click();
	}
	
	public void Itenary()
	{
		btnitenary.click();
	}
	
		public boolean isBookItenaryMsgExists()
	{
		return(BookItenaryMsg.isDisplayed());
	}
	
		}
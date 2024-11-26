package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BookAHotelPage extends BasePage
{

	public BookAHotelPage(WebDriver driver) 
	{
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='hotel_name_dis']")
	WebElement hotelName;
	
	@FindBy(xpath="//input[@id='location_dis']")
	WebElement Location;
	
	@FindBy(xpath="//input[@id='room_type_dis']")
	WebElement roomType;
	
	@FindBy(xpath="//input[@id='room_num_dis']")
	WebElement noOfRooms;
	
	
	@FindBy(xpath="//input[@id='price_night_dis']")
	WebElement price;
	
	@FindBy(xpath="//input[@id='total_price_dis']")
	WebElement totPrice;
	
	@FindBy(xpath="//input[@id='gst_dis']")
	WebElement gst;
	
	@FindBy(xpath="//input[@id='final_price_dis']")
	WebElement finalPrice;
	
	
	public String PPNight()
	{
		return price.getAttribute("value");
	}
	
	public String TotPrice()
	{
		return totPrice.getAttribute("value");
	}
	
	public String Gst()
	{
		return gst.getAttribute("value");
	}
	
	public String FinalPrice()
	{
		return finalPrice.getAttribute("value");
	}
	
		
	@FindBy(xpath="//input[@id='first_name']")
	WebElement txtFname;
	
	@FindBy(xpath="//input[@id='last_name']")
	WebElement txtLName;
	
	@FindBy(xpath="//textarea[@id='address']")
	WebElement txtadd;
	
	@FindBy(xpath="//input[@id='cc_num']")
	WebElement txtcreditCard;
	
	@FindBy(xpath="//select[@id='cc_type']")
	WebElement drpcreditType;
	
	@FindBy(xpath="//select[@id='cc_exp_month']")
	WebElement drpexpiryMonth;
	
	@FindBy(xpath="//select[@id='cc_exp_year']")
	WebElement drpexpiryYear;
	
	@FindBy(xpath="//input[@id='cc_cvv']")
	WebElement txtcvv;
	
	@FindBy(xpath="//input[@id='book_now']")
	WebElement btnBookNow;
	
//	@FindBy(xpath="//input[@id='cancel']")
	WebElement btnCancel;
	
	public void firstName(String fname)
	{
	 txtFname.sendKeys(fname);
	}
	
	public void lastName(String lname)
	{
		txtLName.sendKeys(lname);
	}
	public void address(String add)
	{
		txtadd.sendKeys(add);
	}
	public void creditCardNo(String creditno)
	{
		txtcreditCard.sendKeys(creditno);
	}
	public void creditCardType(String creditType)
	{
		Select optioncredit = new Select(drpcreditType);
		optioncredit.selectByVisibleText(creditType);
	}
	public void expiryMonth(String month)
	{
		Select optionExpMonth = new Select(drpexpiryMonth);
				optionExpMonth.selectByVisibleText(month);		
	}
    public void expiryyear(String year)
    {
    	Select optionExpYear = new Select(drpexpiryYear);
    	optionExpYear.selectByVisibleText(year);
    }
	
    public void cvvNo(String cvvno)
    {
    	txtcvv.sendKeys(cvvno);
    }
    public void bookNow()
    {
    	btnBookNow.click();
    }
    
    public String verify_hotelName()
	{
	return hotelName.getAttribute("value");
	}
	
	public String verify_Location()
	{
		return Location.getAttribute("value");
	}
	
	public String verify_RoomType()
	{
		return roomType.getAttribute("value");
	}
	
	public String verify_NoOfRooms()
	{
		return noOfRooms.getAttribute("value");
	}
}

package testCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BookAHotelPage;
import pageObject.BookingConfirmationPage;
import pageObject.HomePage;
import pageObject.SearchHotelPage;
import pageObject.SelectHotelPage;
import testBase.BaseClass;

public class TC020_ItenaryTest_Build2 extends BaseClass
{
	@Test(groups="Build2",priority=4)
	public void MyItenary()
	{
	try
	{
		HomePage hp = new HomePage(driver);
		hp.build2();
		hp.setUserName(p.getProperty("username"));
		hp.setPassword(p.getProperty("password"));
		hp.clickLogin();
		
		SearchHotelPage shp = new SearchHotelPage(driver);
		shp.clickReset();
		shp.selectLocation();
		shp.selectHotels();
		shp.selectRoomType();
		shp.selectNoOfRooms();
		Thread.sleep(3000);
		LocalDate today = LocalDate.now();
	    LocalDate chkIn = today.plusDays(15);
	    LocalDate chkout = today.plusDays(20);
			 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String chkInDate = chkIn.format(formatter);      
	    String chkOutDate = chkout.format(formatter);    
	 
		shp.checkInDate(chkInDate);
		Thread.sleep(3000);
		shp.checkOutDate(chkOutDate);
		Thread.sleep(3000);	
		shp.selectAdults();
		shp.selectChildren();
		shp.clickSearch();
		
		SelectHotelPage selhotel= new SelectHotelPage(driver);
		selhotel.SelectHotel();
		selhotel.Click_Continue();
		
		BookAHotelPage bhp = new BookAHotelPage(driver);
		bhp.firstName(p.getProperty("firstName"));
		bhp.lastName(p.getProperty("lastName"));
		bhp.address(p.getProperty("address"));
		bhp.creditCardNo(p.getProperty("credicardno"));
		Thread.sleep(3000);
		bhp.creditCardType(p.getProperty("creditcardtype"));
		Thread.sleep(3000);
		bhp.expiryMonth(p.getProperty("expirymonth"));
		Thread.sleep(3000);
		bhp.expiryyear(p.getProperty("expiryyear"));
		Thread.sleep(3000);
		bhp.cvvNo(p.getProperty("cvv"));
		Thread.sleep(3000);
		bhp.bookNow();
		
				
	BookingConfirmationPage bc = new BookingConfirmationPage(driver);
	Thread.sleep(3000);
		
    bc.Itenary();
	Thread.sleep(3000);
	
	Assert.assertTrue(bc.isBookItenaryMsgExists(), "Booked Itenary Message Not Dispalyed");
	}
	catch(Exception e)
	{
		Assert.fail("Test faile due to : "+ e.getMessage());
	}	
}
}




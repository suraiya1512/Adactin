package testCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObject.BookAHotelPage;
import pageObject.BookingConfirmationPage;
import pageObject.HomePage;
import pageObject.SearchHotelPage;
import pageObject.SelectHotelPage;
import testBase.BaseClass;

public class TC010_Booking_Confirmation_Test_Build1 extends BaseClass
{
	@Test(groups= {"Build1"},priority=3)
public void BookingConfirmation() throws InterruptedException
{
    SoftAssert softAssert = new SoftAssert();
	try
	{
		HomePage hp = new HomePage(driver);
		
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
	
	softAssert.assertEquals( bc.Verify_HotelName(),p.getProperty("hotelname"),"HotelName Not Matched");
	softAssert.assertEquals( bc.Verify_Location(),p.getProperty("location"),"Location Not Matched");
	softAssert.assertEquals( bc.Verify_RoomType(),p.getProperty("roomtype"),"RoomType Not Matched");
	softAssert.assertEquals( bc.Verify_Arrival(),chkInDate,"Check In Date Not Matched");
	softAssert.assertEquals( bc.Verify_Departure(),chkOutDate,"Check Out Date Not Matched");
	softAssert.assertEquals( bc.Verify_TotalRoom(),p.getProperty("totalrooms"),"Total Rooms Not Matched");
	softAssert.assertEquals( bc.Verify_Adults(),p.getProperty("adults"),"Adults Not Matched");
	softAssert.assertEquals( bc.Verify_Children(),p.getProperty("children"),"Childrens Not Matched");
	softAssert.assertEquals( bc.Verify_ppNight(),p.getProperty("Pricepernight"),"Price Per Night Not Matched");
	softAssert.assertEquals( bc.Verify_tPrice(),p.getProperty("TotalPrice"),"Total Price Not Matched");
	softAssert.assertEquals( bc.Verify_gst(),p.getProperty("gst"),"GST Not Matched");
	softAssert.assertEquals( bc.Verify_finalPrice(),p.getProperty("finalPrice"),"Final Price Not Matched");
	softAssert.assertEquals( bc.Verify_firstName(),p.getProperty("firstName"),"First Name Not Matched");
	softAssert.assertEquals( bc.Verify_lastName(),p.getProperty("lastName"),"Last Name Not Matched");
	softAssert.assertEquals( bc.Verify_address(),p.getProperty("address"),"Address Not Matched");
	softAssert.assertTrue( bc.OrderNoExists(),"OrderNo Not Generated");
	
	softAssert.assertAll();
	}
	
/*	bc.Itenary();
	Thread.sleep(3000);
	
	Assert.assertTrue(bc.isBookItenaryMsgExists(), "Booked Itenary Message Not Dispalyed");
	}*/
	catch(Exception e)
	{
		Assert.fail("Test faile due to : "+ e.getMessage());
	}	

}
}
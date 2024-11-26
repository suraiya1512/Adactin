package testCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.BookAHotelPage;
import pageObject.HomePage;
import pageObject.SearchHotelPage;
import pageObject.SelectHotelPage;
import testBase.BaseClass;

public class TC007_Hotel_Data_Vrification_Test_Build1 extends BaseClass
{

	@Test(groups= {"Build1"},priority=3)
	public void Verify_HotelData()
	{
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
		
		Assert.assertEquals(bhp.verify_hotelName(),"Hotel Sunshine");
		Thread.sleep(3000);
		Assert.assertEquals(bhp.verify_Location(),"London");
		Thread.sleep(3000);
		Assert.assertEquals(bhp.verify_RoomType(),"Deluxe");
		Thread.sleep(3000);
		Assert.assertEquals(bhp.verify_NoOfRooms(),"1 Room(s)");
		
	}
		catch(Exception e)
		{
			Assert.fail("Test Failed due to :" + e.getMessage());
		}
}
}
package testCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchHotelPage;
import pageObject.SelectHotelPage;
import testBase.BaseClass;

public class TC006_Select_Hotel_Test_Build1 extends BaseClass

{

	@Test(groups= {"Build1"},priority=3)
public void Verify_Hotel() throws InterruptedException
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
	
	LocalDate today = LocalDate.now();
    LocalDate chkIn = today.plusDays(15);
    LocalDate chkout = today.plusDays(20);
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String chkInDate = chkIn.format(formatter);      
    String chkOutDate = chkout.format(formatter); 
	shp.checkInDate(chkInDate);
	Thread.sleep(3000);
	shp.checkOutDate(chkOutDate);
	shp.selectAdults();
	shp.selectChildren();
	shp.clickSearch();
	
	SelectHotelPage selhotel= new SelectHotelPage(driver);
	selhotel.SelectHotel();
	
	selhotel.Click_Continue();
	
	Assert.assertTrue(selhotel.isTitleBookHotelExits(), "Title : Book A Hotel is not Displayed");
	
	logger.info("*********Select Hotel Verification Completed*****");
}
}

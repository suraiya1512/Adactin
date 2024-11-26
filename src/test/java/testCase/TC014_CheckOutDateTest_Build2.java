package testCase;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchHotelPage;
import testBase.BaseClass;

public class TC014_CheckOutDateTest_Build2 extends BaseClass
{
	@Test(groups="Build2",priority=4)
	public void Verify_CheckOut_Date()
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
	    LocalDate chkInLater = today.plusDays(20);
		LocalDate chkoutEarlier = today.plusDays(10);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String chkInLaterDate = chkInLater.format(formatter);
		String chkoutEarlierDate = chkoutEarlier.format(formatter);
		
		shp.checkInDateLater(chkInLaterDate);
		Thread.sleep(3000);
		shp.checkOutDateEarlier(chkoutEarlierDate);
		Thread.sleep(3000);
		shp.selectAdults();
		shp.selectChildren();
		Thread.sleep(3000);
		shp.clickSearch();
		
		Assert.assertTrue(shp.isCheckInErrorMsgExists(), "Expected 'Error Message' is not displayed ");
		Assert.assertTrue(shp.isCheckOutErrorMsgExists(), "Expected 'Error Message' is not displayed ");
		
		Assert.assertEquals(shp.checkInErrorMsg.getText(), "Check-In Date shall be before than Check-Out Date");
		Assert.assertEquals(shp.checkOutErrorMsg.getText(), "Check-Out Date shall be after than Check-In Date");
		}
		catch(Exception e)
		{
			Assert.fail("Test failed due to: " + e.getMessage());
		}
		
	}
		
	}

	package testCase;
	
	import java.time.LocalDate;
	import java.time.format.DateTimeFormatter;
	import java.time.temporal.ChronoUnit;
	import java.util.Properties;
	import java.io.FileOutputStream;
	import java.io.OutputStream;
	
	import org.testng.Assert;
	import org.testng.ITestContext;
	import org.testng.annotations.Test;
	
	import pageObject.BookAHotelPage;
	import pageObject.HomePage;
	import pageObject.SearchHotelPage;
	import pageObject.SelectHotelPage;
	import testBase.BaseClass;
	
	public class TC008_Price_Validation_Test_Build1 extends BaseClass
	{
		@Test(groups= {"Build1"},priority=3)
		public void Price_Validation(ITestContext context)
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
		 
		    long daysBetween = ChronoUnit.DAYS.between(chkIn, chkout);
		    System.out.println("Number of days between: " + daysBetween);
		    
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
	
			 System.out.println("Price per night: " + bhp.PPNight());
	         System.out.println("Total price: " + bhp.TotPrice());
	
	         String pricePerNight = bhp.PPNight();
	         
	         String totalPriceperNight = bhp.PPNight().replace("AUD $", "").trim(); // Remove "AUD $"
	         double totalPriceValue = Double.parseDouble(totalPriceperNight)*daysBetween; // Convert to double
	         System.out.println("Parsed Total Price (as number): " + totalPriceValue);
	         String TPrice = String.format("AUD $ %.1f", totalPriceValue);
	         
	         // Calculate final price with 10% GST
	         double gstAmount = totalPriceValue * 0.10; 
	         String gst = String.format("AUD $ %.1f", gstAmount);
	         double finalPriceValue = totalPriceValue + gstAmount; 
	
	         String finalPriceFormatted = String.format("AUD $ %.1f", finalPriceValue);
	         System.out.println("Calculated Final Price (with GST): " + finalPriceFormatted);
	
	               
	         Assert.assertEquals(bhp.FinalPrice(), finalPriceFormatted, "Final price mismatch!");
	         System.out.println("Final Price after calculation: " + finalPriceFormatted);
	         
	         Properties properties = new Properties();
	         properties.setProperty("pricePerNight", pricePerNight);
	         properties.setProperty("finalPriceFormatted", finalPriceFormatted);
	         properties.setProperty("gst", gst);
	         properties.setProperty("TPrice", TPrice);
	         
	         
	         String filePath = System.getProperty("user.dir") + "\\testData\\testData.properties";
	         try (OutputStream output = new FileOutputStream(filePath)) {
	             properties.store(output, null);

	         }
	         
	         System.out.println("Data saved to properties file.");
	
	     } 
	     catch (Exception e)
	     {
	         Assert.fail("Test Failed due to: " + e.getMessage());
	     }
	 }
	}

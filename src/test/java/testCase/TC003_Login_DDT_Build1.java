	package testCase;
	
	import java.time.Duration;
	
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.Test;
	
	import pageObject.HomePage;
	import pageObject.LogOutPage;
	import pageObject.SearchHotelPage;
	import testBase.BaseClass;
	import utilities.DataProviders;
	
	public class TC003_Login_DDT_Build1 extends BaseClass
	{
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups="DDT",priority=2)
		
	    public void verify_LoginDDT(String username,String pwd,String exp)
	    {
	   
	    HomePage hp = new HomePage(driver);
		
	    hp.setUserName(username);
		hp.setPassword(pwd);
		hp.clickLogin();
		
		LogOutPage lop = new LogOutPage(driver);
		SearchHotelPage shp =new SearchHotelPage(driver);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		 logger.info("**********DDT started*************");
		 System.out.println(exp);
		if (exp.equalsIgnoreCase("Valid")) 
		{
	        wait.until(ExpectedConditions.titleIs(shp.actual));
	
	        System.out.println("Expected homepage title: " + shp.actual);
	        System.out.println("AccountPage title: " + driver.getTitle());
	
	        if (driver.getTitle().equals(shp.actual)) 
	        {
	            System.out.println("Login successful with valid credentials."+ username+" " +pwd);
	            System.out.println();
	            shp.logout();
				lop.loginagain();
	            Assert.assertTrue(true);  // Test passes
	        }
	        else 
	        {
	            System.out.println("Login failed, page title mismatch."+ username+" " +pwd);
	            System.out.println();
	            Assert.assertTrue(false, "Login failed, page title mismatch");
	        }
	    }
	
	    if (exp.equalsIgnoreCase("Invalid"))
	    {
	       wait.until(ExpectedConditions.titleIs(hp.hometitle)); 
	       
	       System.out.println("Expected home title: " + hp.hometitle);
	       System.out.println("HomePage title: " + driver.getTitle());
	
	       if (driver.getTitle().equals(hp.hometitle))
	       {
	            System.out.println("Login failed as expected with invalid credentials."+ username+" " +pwd);
	            System.out.println();
	            Assert.assertTrue(true);  // Test passes
	        } 
	       else 
	       {
	            System.out.println("Login succeeded unexpectedly with invalid credentials."+ username+" " +pwd);
	            System.out.println();
	            Assert.assertTrue(false, "Login succeeded with invalid credentials");
	        }
	     
	    }
	    logger.info("**********DDT Completed*************");
	}
	}
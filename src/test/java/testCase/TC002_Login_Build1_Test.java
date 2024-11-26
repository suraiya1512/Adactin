package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchHotelPage;
import testBase.BaseClass;

public class TC002_Login_Build1_Test extends BaseClass
{
	@Test(groups= {"Build1"},priority=3)
	public void veriy_Login()
	{
	
	HomePage hp = new HomePage(driver);
	
	hp.setUserName(p.getProperty("username"));
	hp.setPassword(p.getProperty("password"));
	hp.clickLogin();
	logger.info("*****Login Successful*****");
	
	SearchHotelPage shp = new SearchHotelPage(driver);
	boolean targetPage = shp.isMyAccExists();
	Assert.assertTrue(targetPage);
	
	}
}

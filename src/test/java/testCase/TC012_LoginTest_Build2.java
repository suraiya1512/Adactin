package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.SearchHotelPage;
import testBase.BaseClass;

public class TC012_LoginTest_Build2 extends BaseClass
{
	@Test(groups="Build2",priority=4)
public void veriy_Login()
{

HomePage hp = new HomePage(driver);
hp.build2();
hp.setUserName(p.getProperty("username"));
hp.setPassword(p.getProperty("password"));
hp.clickLogin();


SearchHotelPage shp = new SearchHotelPage(driver);
boolean targetPage = shp.isMyAccExists();
Assert.assertTrue(targetPage);

logger.info("*****Login Build 2 Successful*****");
}
}
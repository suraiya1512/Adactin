package testCase;

import org.testng.annotations.Test;

import pageObject.HomePage;
import pageObject.RegistrationPage;
import testBase.BaseClass;

public class TC001_NewUserRegistration extends BaseClass
{
@Test(groups= {"General"},priority=1)
public void new_user_registration()
{
		
	HomePage hp = new HomePage(driver);
	hp.newRegistration();
	
	logger.info("******Registration Started*******");
	
	RegistrationPage rp = new RegistrationPage(driver);
	rp.TextUserName(randomString().toUpperCase());
	
	String password=randomAlphaNumeric();
	
	rp.TextPassword(password);
	rp.TextConfPWD(password);
	rp.TextFullName(randomString().toUpperCase());
	rp.TextEmail  (randomString() +"@gmail.com");	
    rp.ClickTerms();
    rp.ClickRegisters();
    rp.ClickLogin();
    logger.info("******Registration Completed*******");
    
}

}

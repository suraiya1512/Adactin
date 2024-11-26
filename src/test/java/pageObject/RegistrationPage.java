package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage{

	public RegistrationPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='username']")
	WebElement txtUname;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='re_password']")
	WebElement txtConPwd;
	
	@FindBy(xpath="//input[@id='full_name']")
	WebElement fullname;
	
	@FindBy(xpath="//input[@id='email_add']")
	WebElement txtEmail;
	
	@FindBy(xpath="//input[@id='tnc_box']")
	WebElement chkdTerms;
	
	@FindBy(xpath="//input[@id='Submit']")
	WebElement 	btnRegister;

	@FindBy(xpath="//a[normalize-space()='Click here to login']")
	WebElement linkLogin;

public void TextUserName(String uname)
{
	txtUname.sendKeys(uname);
}

public void TextPassword(String pwd)
{
	txtPassword.sendKeys(pwd);
}

public void TextConfPWD(String pwd)
{
	txtConPwd.sendKeys(pwd);
}

public void TextFullName(String fname)
{
	fullname.sendKeys(fname);
}

public void TextEmail(String email)
{
	txtEmail.sendKeys(email);
}

public void ClickTerms()
{
	chkdTerms.click();
}

public void ClickRegisters()
{
	btnRegister.click();
}
public void ClickLogin()
{
	linkLogin.click();
}


}

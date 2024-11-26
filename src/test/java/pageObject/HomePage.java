package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver)
	{
		super(driver);
		
	}

	@FindBy(xpath="//input[@id='username']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement txtPassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement btnLogin;
	
	@FindBy(xpath="//a[normalize-space()='New User Register Here']")
	WebElement btnNewUSerRegister;
	
	@FindBy(xpath="//strong[normalize-space()='Go to Build 2']")
	WebElement linkbuild2;
	
	
	@FindBy(xpath ="//span[@id='username_span']")
	public WebElement userErrormsg;
	
	@FindBy(xpath ="//span[@id='password_span']")
	public WebElement pwdErrormsg;
	
	public String hometitle = driver.getTitle();
	
	public void  setUserName(String uname)
	{
		txtUserName.sendKeys(uname);
	}
	
	public void  setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void  clickLogin()
	{
		btnLogin.click();
	}
	
	public void  newRegistration()
	{
		btnNewUSerRegister.click();
	}
	
	public void  build2()
	{
		linkbuild2.click();
	}
	public boolean empty_user()
	{
		return (userErrormsg.isDisplayed());
	}
	
	public boolean empty_pwd()
	{
		return (pwdErrormsg.isDisplayed());
	}
	public boolean build1failed()
	{
		return linkbuild2.isDisplayed();
	}
}

package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass
{
    public static WebDriver driver;
    public Properties p;
    public Logger logger;
	
    
    @BeforeClass(groups= {"General","Build1","Build2","DDT"})
    @Parameters({"os","browser"})
	public void setup(String os, String br) throws IOException
	{
    	logger=LogManager.getLogger(this.getClass());	
    	
     FileReader file = new FileReader(".//src/test/resources//config.properties");
     p=new Properties();
     p.load(file);
     
     if(p.getProperty("execution_env").equalsIgnoreCase("remote"))
 	{
 		DesiredCapabilities capabilities= new	DesiredCapabilities();
 		
 		//OS
 		if(os.equalsIgnoreCase("windows"))
 		{
 			capabilities.setPlatform(Platform.WIN11);
 		}
 		else if (os.equalsIgnoreCase("mac"))
 		{
 			capabilities.setPlatform(Platform.MAC);
 		}
 		else
 		{
 			System.out.println("No Matching OS");
 			return;
 		}
 		
 		//browser
 		switch(br.toLowerCase())
 		{
 		case "chrome" : capabilities.setBrowserName("chrome");break;
 		case "edge": capabilities.setBrowserName("MicrosoftEdge");break;
 		default : System.out.println("No Matching Browser");
 		}
 		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),capabilities);
 	
 	}
 		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
 		{
 	
 		switch(br.toLowerCase())
 		{
 		case "chrome" : driver=new ChromeDriver(); break;
 		case "edge" : driver=new EdgeDriver(); break;
 		default: System.out.println("Invalid Browser");return;
 		
 		}
 		}
    	
	  //driver = new ChromeDriver();
	  driver.manage().deleteAllCookies();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.get(p.getProperty("appURL"));
	  driver.manage().window().maximize();
	}
    
     @AfterClass(groups= {"General","Build1","Build2","DDT"})
    public void tearDown()
    {
	      	driver.quit();
     }
    public String randomString()
    {
    	@SuppressWarnings("deprecation")
		String newString = RandomStringUtils.randomAlphabetic(10);
    	return newString;
    }
   
    public String randomNumbers()
    {
    	@SuppressWarnings("deprecation")
		String newNum = RandomStringUtils.randomNumeric(10);
    	return newNum;
    }
    
    public String randomAlphaNumeric()
    {
    	@SuppressWarnings("deprecation")
    	String newString = RandomStringUtils.randomAlphabetic(3);
		@SuppressWarnings("deprecation")
		String newNum = RandomStringUtils.randomNumeric(3);
    	return (newString + "_" + newNum);
    }
    public String captureScreen(String tname)throws IOException
	 {
			 String timeStamp = new SimpleDateFormat("yyyMMddhhmmss").format(new Date());
			 TakesScreenshot takesScreenShot = (TakesScreenshot)driver;
			 File sourceFile = takesScreenShot.getScreenshotAs(OutputType.FILE);
			 
			 String targetFilePath = System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
			 File targetFile = new File(targetFilePath);
			 
			 sourceFile.renameTo(targetFile);
			 return targetFilePath;
	}
}

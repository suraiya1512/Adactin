package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
//import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//import org.apache.commons.mail.DefaultAuthenticator;
//import org.apache.commons.mail.ImageHtmlEmail;
//import org.apache.commons.mail.resolver.DataSourceUrlResolver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.ExtentTest;

import testBase.BaseClass;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter SparkReporter;
    public ExtentReports extent;
    public ExtentTest test;
    public String repName;

    public void onStart(ITestContext testContext) {
        // Initialize report name with timestamp
    	
    	/*SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
    	Date dt = new Date();
    	String currentdatestamp = df.format(dt);*/
    	
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.ss").format(new Date());
        repName = "Test-Report-" + timestamp + ".html";

        // Initialize ExtentSparkReporter
        SparkReporter = new ExtentSparkReporter(".\\reports\\" + repName);  // specify location of the file
        SparkReporter.config().setDocumentTitle("OpenCart Automation Report"); // Title of report
        SparkReporter.config().setReportName("Open Functional Testing"); // Name of the report
        SparkReporter.config().setTheme(Theme.DARK);

        // Initialize ExtentReports object
        extent = new ExtentReports();
        extent.attachReporter(SparkReporter); // Attach the SparkReporter to ExtentReports

        // Set system information for the report
        extent.setSystemInfo("Application", "OpenCart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        // Add additional parameters from test XML (if available)
        String os = testContext.getCurrentXmlTest().getParameter("OS");
        extent.setSystemInfo("Operating System", os);

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", browser);

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        if (!includedGroups.isEmpty()) {
            extent.setSystemInfo("Groups", includedGroups.toString());
        }
    }

   
    public void onTestSuccess(ITestResult result) {
        // Create and log a successful test in the report
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.PASS, result.getName() + " got successfully executed");
    }

   
    public void onTestFailure(ITestResult result) {
        // Create and log a failed test in the report
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, result.getName() + " got Failed");
        test.log(Status.INFO, result.getThrowable().getMessage());

        // Capture screenshot if failure occurs (if you have a screenshot method)
        try {
            String imgPath = new BaseClass().captureScreen(result.getName());
            test.addScreenCaptureFromPath(imgPath);
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    
    public void onTestSkipped(ITestResult result) {
        // Create and log a skipped test in the report
        test = extent.createTest(result.getTestClass().getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, result.getName() + " got Skipped");
        test.log(Status.INFO, result.getThrowable().getMessage());
    }

  
    public void onFinish(ITestContext testContext) {
        // Add a null check before calling flush() to avoid NullPointerException
        if (extent != null) {
            extent.flush(); // Ensure extent is initialized before calling flush
        } else {
            System.out.println("ExtentReports not initialized. Skipping flush.");
        }

        // Open the generated report in the browser
        String pathOfExtentReport = System.getProperty("user.dir") + "\\reports\\" + repName;
        File extentReport = new File(pathOfExtentReport);

        try {
            Desktop.getDesktop().browse(extentReport.toURI()); // Open the report in the browser
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

   
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // This method is optional, but can be used for handling partial success tests
    }

/*	try
		{
			@SuppressWarnings("deprecation")
			URL url=new URL("file://"+System.getProperty("user.dir")+"//reports\\"+repName);
		 
			//Create email message
			
			ImageHtmlEmail email = new ImageHtmlEmail();
			email.setDataSourceResolver(new DataSourceUrlResolver(url));
			email.setHostName("smtp.googlemail.com");
			email.setSmtpPort(465);
			email.setAuthenticator(new DefaultAuthenticator("pavanoltraining@gmail.com","password"));
			email.setSSLOnConnect(true);
			email.setFrom("pavanoltraining@gmail.com");  //sender
			email.setSubject("Test Results");
			email.setMsg("please find Attached Report");
			email.addTo("PavanKumar.busyqa@gmail.com"); // Receiver
			email.attach(url,"extent report","please check report");
			email.send();      //send the email
		}
		catch (Exception e)
		{
			e.printStackTrace();
			
		}*/
			
		}
	


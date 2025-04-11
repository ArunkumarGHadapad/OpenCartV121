package utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import testCases.BaseClass;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extents;
	public ExtentTest extentTest;
	String repName;
	
	public void onTestStart(ITestResult result) {
	    // not implemented
//	 String timeStamp= SimpleDateFormat("").format(new Date());
		
		
	  }
	
	
	public void onStart(ITestContext context) {
		  
		  String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
			repName= "Test Report- " + timeStamp + ".html";
			timeStamp = timeStamp.replace(" ", "_").replace(":", "-");
			String repName = "Test_Report-" + timeStamp + ".html";
			System.out.println(repName);
			
			sparkReporter=new ExtentSparkReporter(".\\reports\\"+repName);
			sparkReporter.config().setDocumentTitle("Automation Project -OpenCart"); //Title of Project
			sparkReporter.config().setReportName("OpenCart Functional Testing");
			sparkReporter.config().setTheme(Theme.DARK);
			
			extents=new ExtentReports();
			extents.attachReporter(sparkReporter);
			extents.setSystemInfo("Application", "OpenCart");
			extents.setSystemInfo("Module", "Admin");
			extents.setSystemInfo("Sub Module", "Customer");
			extents.setSystemInfo("User Name", System.getProperty("user.name"));
			extents.setSystemInfo("Environment", "QA");
			
			String os = context.getCurrentXmlTest().getParameter("os");
			extents.setSystemInfo("Operating system", os);
			
			String browser = context.getCurrentXmlTest().getParameter("browser");
			extents.setSystemInfo("Browser", browser);
		    // not implemented
			List<String> includedGroups=context.getCurrentXmlTest().getIncludedGroups();
			if(!includedGroups.isEmpty()) {
				extents.setSystemInfo("Groups", includedGroups.toString());
			}
	  }

	  /**
	   * Invoked each time a test succeeds.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SUCCESS
	   */
	public void onTestSuccess(ITestResult result) {
	    // not implemented
		  			
		  extentTest=extents.createTest(result.getTestClass().getName());
		  extentTest.assignCategory(result.getMethod().getGroups());
		  extentTest.log(Status.PASS,result.getName()+"Got Successfully Executed");
		  
	  }

	  /**
	   * Invoked each time a test fails.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#FAILURE
	   */
	  public void onTestFailure(ITestResult result) {
		  extentTest=extents.createTest(result.getTestClass().getName());
		  extentTest.assignCategory(result.getMethod().getGroups());
		  extentTest.log(Status.FAIL,result.getName()+"Got Failed");
		  extentTest.log(Status.INFO,result.getThrowable().getMessage());
		  
		  String imgPath=new BaseClass().captureScreen(result.getName());
		  extentTest.addScreenCaptureFromPath(imgPath);
		  
		  
		  
	    // not implemented
	  }

	  public void onFinish(ITestContext context) {
		  
		  extents.flush();			  
		  
		  }	  
		  
//		  try {
//			  Desktop.getDesktop().browse(extentReport.toURI());
//		  }catch(IOException e) {
//			  e.printStackTrace();
//		  }
//		  
//		    // not implemented
//		  }
	  /**
	   * Invoked each time a test is skipped.
	   *
	   * @param result <code>ITestResult</code> containing information about the run test
	   * @see ITestResult#SKIP
	   */
	  public void onTestSkipped(ITestResult result) {
	    // not implemented
	  }


}

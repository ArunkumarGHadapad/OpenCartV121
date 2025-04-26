package Day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListner implements ITestListener {
	
	
	  public  void onTestStart(ITestResult result) {
		  System.out.println(" Test excution started ");
		    // not implemented
		  }
	  
	  public void onTestSuccess(ITestResult result) {
		  System.out.println(" Test excution Success ");
		    // not implemented
		  }
	  public void onTestFailure(ITestResult result) {
		  System.out.println(" Test excution Failed ");
		    // not implemented
		  }
	  public void onTestSkipped(ITestResult result) {
		  System.out.println(" Test excution Skipped ");
		    // not implemented
		  }
	  public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		    // not implemented
		  }
	  public void onStart(ITestContext context) {
		  System.out.println(" Test excution Onstart ");
		    // not implemented
		  }
	  public void onFinish(ITestContext context) {
		  System.out.println(" Test excution Finished ");
		    // not implemented
		  }
	  

}

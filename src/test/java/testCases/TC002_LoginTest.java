package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC002_LoginTest extends BaseClass {
	
	@Test(groups={"Sanity","Master"})
	public void VerifLogin() {
		logger.info("*****Login Test Started*****");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		logger.info("***** Clicked On MyAccount *****");
		hp.clickLogin();
		logger.info("***** Clicked On Login *****");
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.setLogin();
		logger.info("***** Clicked On Login button *****");	
		
		MyAccountPage map=new MyAccountPage(driver);
		boolean lblMyAccount=map.getMyAccount();
		logger.info("***** MyAccount Page Opened-{lblMyAccount} *****"+"	"+lblMyAccount);
		System.out.print(lblMyAccount);		
		Assert.assertEquals(lblMyAccount, true,"Login Failed");
		//Assert.assertFalse(lblMyAccount);
		}catch(Exception e) {
			Assert.fail();
		}
		logger.info("*****Login Test Finished*****");
	}

}

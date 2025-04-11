package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)//getting Dataprovider from Another class
	public void Verify_LoginDDT(String email,String pass,String exp) {
	
		logger.info("********LogDDt Started*******");
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();
		hp.clickLogin();
	//LoginPage
		LoginPage lp=new LoginPage(driver);
		lp.setEmail(email);
		lp.setpassword(pass);
		lp.setLogin();
	//MyAccountPage
		MyAccountPage map=new MyAccountPage(driver);
		boolean lblMyAccount=map.getMyAccount();
		
		
		//Data is Valid  - Login Success  -Testpass
		//Data is Invalid - Login Success -TestFail
		//Data is Valid  - Login Fail - TestFail
		//Data is Invalid -Login Fail -TestPass
		if(exp.equalsIgnoreCase("valid")) {
			if(lblMyAccount==true) {
				map.clickLogout();
				Assert.assertTrue(true);
				
			}else {
				Assert.assertTrue(false);
			}
			 
		}
		logger.info("********LogDDt In MyAccount*******");
		
		if(exp.equalsIgnoreCase("invalid")) {
			if(lblMyAccount==true) {
				map.clickLogout();
				Assert.assertTrue(false);
				
			}else {
				Assert.assertTrue(true);
			}
			
		}
		}catch(Exception e) {
			Assert.fail();
		}
		
		
		
		logger.info("********LogDDt Finished*******");
		
		
	}

}

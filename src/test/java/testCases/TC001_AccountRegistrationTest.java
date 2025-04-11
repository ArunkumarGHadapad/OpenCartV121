package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {
	

	@Test(groups={"Regression","Master"})
	public void VerifyAccountRegistration()  {
		
		logger.info("******** Started- TC001_AccountRegistrationTest ***********");
		try {
		HomePage hp=new HomePage(driver);
		hp.clickMyAccout();hp.clickRegister();
		logger.info("******** Clicked On Register- TC001_AccountRegistrationTest ***********");
		AccountRegisterPage regpage=new AccountRegisterPage(driver);
		logger.info("******** Providing Customer Details ***********");
		regpage.setFirstName(randomeString().toUpperCase());
		regpage.setLastName(randomeString().toUpperCase());
		regpage.setEmail(randomeString()+"@gmail.com");//arungh0711@gmail.com
		//regpage.setEmail(p.getProperty("email"));
		regpage.settelephone(randomNumeric());
		 
		String pass=randomAlphNumeric();
		
		regpage.setPassword(pass);
		regpage.setconfirmPassword(pass);
		regpage.setNewsletter();
		regpage.setAgree();
		regpage.setContinue();
		String succeMsg=regpage.getSuccessMsg();
		
		regpage.setSuccesContinue();

		logger.info("******** Validating Expected Details ***********");
		Assert.assertEquals(succeMsg, "Your Account Has Been Created!");
		}catch(Exception e) {
			logger.error("Test Failed");
			logger.debug("Dubug logs...");
			Assert.fail();
			
		}
		logger.info("Finisheeeeeed logs...");
		
	}
		
}

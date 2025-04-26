package AutomationExercise;
import static org.testng.Assert.assertEquals;
//	USING TESTNG FRAMEWORK
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
public class TestCase_1 {

	public WebDriver driver;
	@BeforeClass
	public void SetUp() {
		// WebDriverSetup
				WebDriverManager.chromedriver().setup();
				//1. Launch browser
				driver=new ChromeDriver();
				driver.manage().window().maximize();
				//2. Navigate to url 'http://automationexercise.com'
				driver.get("http://automationexercise.com");
	}
	
	@Test(priority=1)
	public void homePageTitleVerification() {
		//3. Verify that home page is visible successfully
				String StrTitle=driver.getTitle();
				System.out.println(StrTitle);
				assertEquals(StrTitle,"Automation Exercise","Incorrect Title");
		
	}
	@Test(priority=2)
	public void SignUpTextVisible() {
		//4. Click on 'Signup / Login' button
				driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
				//5. Verify 'New User Signup!' is visible
				boolean signUpText=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
				assertTrue(signUpText,"New User Signup! not Visible");
				
	}
}

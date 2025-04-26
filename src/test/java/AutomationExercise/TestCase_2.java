package AutomationExercise;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

/*
 * Test Case 2: Login User with correct email and password
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Delete Account' button
10. Verify that 'ACCOUNT DELETED!' is visible
*/

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_2 {

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
	
	@Test(priority=3)
	public void ExLogin() {
		//6. Enter correct email address and password 
		driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("Arun20252@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("Arun2025");
		//7. Click 'login' button
		driver.findElement(By.xpath("//button[@data-qa='login-button']")).click();
		//8. Verify that 'Logged in as username' is visible
		 String loggedUsername=driver.findElement(By.xpath("//a[text()=' Logged in as ']")).getText();
		assertEquals(loggedUsername, "Logged in as Arun2","Login Successfull");
		//9. Click 'Delete Account' button
		driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
		//10. Verify that 'ACCOUNT DELETED!' is visible
		String txtAccDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']")).getText();
		assertEquals(txtAccDeleted,"ACCOUNT DELETED!");
	}
	
	
	
	
	
	
	
	
	
	
	
}

package AutomationExercise;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
/*
 * Test Case 6: Contact Us Form
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully*/
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
/*
 * Test Case 6: Contact Us Form
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Contact Us' button
5. Verify 'GET IN TOUCH' is visible
6. Enter name, email, subject and message
7. Upload file
8. Click 'Submit' button
9. Click OK button
10. Verify success message 'Success! Your details have been submitted successfully.' is visible
11. Click 'Home' button and verify that landed to home page successfully*/
public class TestCase_6  {

	
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
	public void contactForm() {
		//4. Click on 'Contact Us' button //a[@href="/contact_us"]
		driver.findElement(By.xpath("//a[@href=\'/contact_us\']")).click();
		String txtGetTouch=driver.findElement(By.xpath("//h2[text()=\'Get In Touch\']")).getText();
		assertEquals(txtGetTouch,"GET IN TOUCH","Get In Touch Not Visible");
		
		//6. Enter name, email, subject and message //input[@data-qa='submit-button']
		driver.findElement(By.xpath("//input[@data-qa='name']")).sendKeys("Arun");
		driver.findElement(By.xpath("//input[@data-qa='email']")).sendKeys("Arun@gmail.com");
		driver.findElement(By.xpath("//input[@data-qa='subject']")).sendKeys("Mths");
		driver.findElement(By.xpath("//textarea[@data-qa=\'message\']")).sendKeys("Arun is Working on QA automation");
		driver.findElement(By.xpath("//input[@name=\"upload_file\"]")).sendKeys("F:\\Arun_Resume_STE.pdf");
		driver.findElement(By.xpath("//input[@data-qa='submit-button']")).click();
		driver.switchTo().alert().accept();
		String txtSuccess= driver.findElement(By.xpath("//div[text()=\"Success! Your details have been submitted successfully.\"]")).getText();
		assertEquals(txtSuccess,"Success! Your details have been submitted successfully.","not correct");
	//	11. Click 'Home' button and verify that landed to home page successfully*/
		////span[text()=' Home']
		driver.findElement(By.xpath("//span[text()=' Home']")).click();
		homePageTitleVerification();
		
	}

	
}

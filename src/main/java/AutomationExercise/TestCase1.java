package AutomationExercise;
import org.openqa.selenium.By;
//USING NORMAL JAVA CLASSES
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static void main(String[] args) {
		// WebDriverSetup
		WebDriverManager.chromedriver().setup();
		//1. Launch browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//2. Navigate to url 'http://automationexercise.com'
		driver.get("http://automationexercise.com");
		//3. Verify that home page is visible successfully
		String StrTitle=driver.getTitle();
		
		if(StrTitle.equalsIgnoreCase("Automation Exercise"))
		{
			System.out.println("Title Is Correct");
		}
		else
		{
			System.out.println("Title Is Correct");
		}
		//4. Click on 'Signup / Login' button
		driver.findElement(By.xpath("//a[text()=' Signup / Login']")).click();
		//5. Verify 'New User Signup!' is visible
		boolean signUpText=driver.findElement(By.xpath("//h2[text()='New User Signup!']")).isDisplayed();
		if(signUpText)
		{
			System.out.println("SignUP text Visible");
		}
		else {
			System.out.println("SignUP text not Visible");	
		}
		//6. Enter name and email address
			driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Arun2");
			driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("Arun20252@gmail.com");
		//7. Click 'Signup' button
			driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();
			
		//8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
			boolean EnterAccInfoText=  driver.findElement(By.xpath("//b[text()='Enter Account Information']")).isDisplayed();
			if(EnterAccInfoText)
			{
				System.out.println("EnterAccInfoText text Visible");
			}
			else {
				System.out.println("EnterAccInfoText text not Visible");	
			}			
		//9. Fill details: Title, Name, Email, Password, Date of birth
			driver.findElement(By.xpath("//input[@id='id_gender1']")).click();
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Arun2025");
			
			WebElement days=driver.findElement(By.xpath("//select[@id='days']"));
			Select dayDropdown=new Select(days);
			dayDropdown.selectByVisibleText("15");
			
			WebElement months=driver.findElement(By.xpath("//select[@id='months']"));
			Select monthsDropdown=new Select(months);
			monthsDropdown.selectByVisibleText("June");
			
			WebElement years=driver.findElement(By.xpath("//select[@id='years']"));
			Select yearsDropdown=new Select(years);
			yearsDropdown.selectByVisibleText("2010");
			
		//10. Select checkbox 'Sign up for our newsletter!'
			driver.findElement(By.xpath("//input[@name='newsletter']")).click();
		//11. Select checkbox 'Receive special offers from our partners!'
			driver.findElement(By.xpath("//input[@name='optin']")).click();
		
		//12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
			driver.findElement(By.xpath("//input[@name='first_name']")).sendKeys("ARUN");
			driver.findElement(By.xpath("//input[@name='last_name']")).sendKeys("KUMAR");
			driver.findElement(By.xpath("//input[@name='company']")).sendKeys("INFOSYS");
			driver.findElement(By.xpath("//input[@name='address1']")).sendKeys("vijayanagar");
			driver.findElement(By.xpath("//input[@name='address2']")).sendKeys("bangaluru");
			
			 WebElement country=driver.findElement(By.xpath("//select[@name='country']"));
			 Select countryDD=new Select(country);
			 countryDD.selectByVisibleText("India");
			 
			
			 driver.findElement(By.xpath("//input[@name='state']")).sendKeys("kar");
			 driver.findElement(By.xpath("//input[@name='city']")).sendKeys("bijapur");
			 driver.findElement(By.xpath("//input[@name='zipcode']")).sendKeys("58608");
			 driver.findElement(By.xpath("//input[@name='mobile_number']")).sendKeys("886165151");
			//13. Click 'Create Account button'
			 
			 driver.findElement(By.xpath("//button[@data-qa='create-account']")).click();
			 
			 //14. Verify that 'ACCOUNT CREATED!' is visible //b[text()='Account Created!']
			 boolean ACCOUNT_CREATED=driver.findElement(By.xpath("//b[text()='Account Created!']")).isDisplayed();
			 if(ACCOUNT_CREATED) {
				 System.out.println("Account Created");
			 }else {
				 System.out.println("Account not Created");
			 }
			 
			 //15. Click 'Continue' button //a[text()='Continue']
			 driver.findElement(By.xpath("//a[text()='Continue']")).click();
			 //16. Verify that 'Logged in as username' is visible //a[text()=' Logged in as ']
			 boolean loggedUsername=driver.findElement(By.xpath("//a[text()=' Logged in as ']")).isDisplayed();
			 
			 if(loggedUsername) {
				 System.out.println("logged Username Visible");
			 }else {
				 System.out.println("logged Username not Visible");
			 }			 
			 
				
				/*
				 * //17. Click 'Delete Account' button //a[@href='/delete_account']
				 * driver.findElement(By.xpath("//a[@href='/delete_account']")).click();
				 * 
				 * //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
				 * //a[@data-qa='continue-button'] boolean
				 * txtAccDeleted=driver.findElement(By.xpath("//b[text()='Account Deleted!']")).
				 * isDisplayed(); if(txtAccDeleted) {
				 * System.out.println("'ACCOUNT DELETED!' is visible"); }else {
				 * System.out.println("'ACCOUNT DELETED!' not is visible"); }
				 * 
				 * driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
				 */
				  
				 
			
			
			
			
			
			
			
			
		}

}

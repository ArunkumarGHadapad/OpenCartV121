package TestNGDay1;
/*
 * 1.Open Application
 * 2.Test Logo Presence
 * 3.Login Application
 * 4.Logout/Close Application
 * */

import org.testng.annotations.Test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMTest {
	
	public WebDriver driver;
	
	//1.Open Application
	@Test(priority=1)
	public void OpenApp() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	//2.Test LogoPresence
	@Test(priority=2)
	public void TestLogoPresence() throws InterruptedException {
		Thread.sleep(1000);
		boolean logoPresence= driver.findElement(By.xpath("//img[@src=\"/web/images/ohrm_branding.png?v=1721393199309\"]")).isDisplayed();
		System.out.println("Logo Displayed is"+logoPresence);
	}
	//3.Login Application
	@Test(priority=3)
	public void LoginApp() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
		
	}
	//4.Logout/Close Application
	@Test(priority=4)
	public void CloseApp() {
		driver.quit();
	}	

}

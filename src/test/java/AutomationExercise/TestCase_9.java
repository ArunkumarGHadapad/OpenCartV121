package AutomationExercise;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
/*
 * Test Case 9: Search Product
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. Enter product name in search input and click search button
7. Verify 'SEARCHED PRODUCTS' is visible
8. Verify all the products related to search are visible
*/
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_9 {

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
	public void searchProduct() {
				//4. Click on 'Products' button
				driver.findElement(By.xpath("//a[text()=\" Products\"]")).click();
				//5. Verify user is navigated to ALL PRODUCTS page successfully
				String txtAllProducts=driver.findElement(By.xpath("//h2[text()=\"All Products\"]")).getText();
				assertEquals(txtAllProducts,"ALL PRODUCTS","All Products text not Correct");
		//6. Enter product name in search input and click search button
		//7. Verify 'SEARCHED PRODUCTS' is visible
		//8. Verify all the products related to search are visible 
				driver.findElement(By.xpath("//input[@id=\"search_product\"]")).sendKeys("Jeans");
				driver.findElement(By.xpath("//button[@id=\"submit_search\"]")).click();
		String txtSearchProd=driver.findElement(By.xpath("//h2[text()=\"Searched Products\"]")).getText();				
		assertEquals(txtSearchProd,"SEARCHED PRODUCTS");
		
		//8. Verify all the products related to search are visible //div[@class="product-information"]//p
		List<WebElement> prodInfo=driver.findElements(By.xpath("//div[@class=\"productinfo text-center\"]"));
			for(int i=0;i<prodInfo.size();i++) {
				assertTrue(prodInfo.get(i).getText().contains("Jeans"));
			}
	}
	
	
	
	
	
	
	
	 
	
	
	
}

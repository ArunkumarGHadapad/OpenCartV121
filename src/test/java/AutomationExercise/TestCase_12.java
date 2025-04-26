package AutomationExercise;

import static org.testng.Assert.assertEquals;
/*
 * Test Case 12: Add Products in Cart
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click 'Products' button
5. Hover over first product and click 'Add to cart'
6. Click 'Continue Shopping' button
7. Hover over second product and click 'Add to cart'
8. Click 'View Cart' button
9. Verify both products are added to Cart
10. Verify their prices, quantity and total price
*/
import static org.testng.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_12 {

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
	public void addProduct() throws InterruptedException {
				//4. Click on 'Products' button
				driver.findElement(By.xpath("//a[text()=\" Products\"]")).click();
		//5. Hover over first product and click 'Add to cart' 
				driver.findElement(By.xpath("//a[@data-product-id='1']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//button[text()=\"Continue Shopping\"]")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a[@data-product-id='2']")).click();
				Thread.sleep(5000);
				driver.findElement(By.xpath("//a//u[text()=\"View Cart\"]")).click();
		//9. Verify both products are added to Cart
		//10. Verify their prices, quantity and total price
		List<WebElement> firstProdDetails=driver.findElements(By.xpath("//tr[@id='product-1']"));
		Thread.sleep(5000);
		List<WebElement> secondProdDetails=driver.findElements(By.xpath("//tr[@id='product-2']"));
		HashMap<Integer,String> map=new HashMap<Integer,String>();
		map.put(1, "Blue Top");
		map.put(1, "Women > Tops");
		map.put(1, "Rs. 500");
		map.put(1, "1");
		map.put(1, "Rs. 500");
		map.put(2, "Men Tshirt");
		map.put(2, "Men > Tshirts");
		map.put(2, "Rs. 400");
		map.put(2, "1");
		map.put(2, "Rs. 400");
		for(int i=0;i<firstProdDetails.size();i++) {
			assertTrue(firstProdDetails.get(i).getText().contains(map.get(1)));
			assertTrue(secondProdDetails.get(i).getText().contains(map.get(2)));
		}
				
	}
}

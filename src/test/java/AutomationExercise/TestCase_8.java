package AutomationExercise;
import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
/*Test Case 8: Verify All Products and product detail page
1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Products' button
5. Verify user is navigated to ALL PRODUCTS page successfully
6. The products list is visible
7. Click on 'View Product' of first product
8. User is landed to product detail page
9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
 * */
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase_8 {

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
	
	@Test (priority=2)
	public void VerifyAllProducts() {
		//4. Click on 'Products' button
		driver.findElement(By.xpath("//a[text()=\" Products\"]")).click();
		//5. Verify user is navigated to ALL PRODUCTS page successfully
		String txtAllProducts=driver.findElement(By.xpath("//h2[text()=\"All Products\"]")).getText();
		assertEquals(txtAllProducts,"ALL PRODUCTS","All Products text not Coorct");
		//7. Click on 'View Product' of first product
		//8. User is landed to product detail page
		driver.findElement(By.xpath("//a[text()=\"View Product\"][1]")).click();
		//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
		String productName= driver.findElement(By.xpath("//h2[text()=\"Blue Top\"]")).getText();
		assertEquals(productName,"Blue Top","Wrong Product name");
		
		ArrayList<Object> arr=new ArrayList<Object>();
		arr.add("Category: Women > Tops");
		arr.add("Availability: In Stock");
		arr.add("Condition: New");
		arr.add("Brand: Polo");
		List<WebElement> prodDetails=driver.findElements(By.xpath("//div[@class=\"product-information\"]//p"));
		for(int i = 0;i<arr.size();i++) {
			assertEquals(prodDetails.get(i).getText(),arr.get(i));
		}
		
		
		
		
		
		
		
		
	}
	
}

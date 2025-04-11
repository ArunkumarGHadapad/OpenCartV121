package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement lblMyAccount;
	@FindBy(xpath="//a[text()='Logout' and @class='list-group-item']") WebElement btnLogout;
	
	//Action Methods
	public boolean getMyAccount() {
		try {
			return (lblMyAccount.isDisplayed());
		}catch(Exception e) {
			return false;
		}
		
		
	}
	
	public void clickLogout() {	btnLogout.click();	}

}

package pageObjects;

//Constructor for Driver Initiating
//Locators
//Action Methods


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[text()=\"My Account\"]") WebElement lnkMyAccount;
	@FindBy(xpath="//a[text()=\"Register\"]") WebElement lnkRegister;
	@FindBy(xpath="//a[text()='Login']") WebElement lnkLogin;
	
	public void clickMyAccout() {	lnkMyAccount.click();	}
	public void clickRegister() {	lnkRegister.click();	}
	public void clickLogin() {		lnkLogin.click();	}
	

}

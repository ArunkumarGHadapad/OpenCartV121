package pageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath="//input[@name='email']") WebElement txtEmail;
	@FindBy(xpath="//input[@name='password']") WebElement txtpassword;
	@FindBy(xpath="//input[@value=\'Login\']") WebElement btnLogin;
	
	public void setEmail(String email) { txtEmail.sendKeys(email);}
	public void setpassword(String pass) {	txtpassword.sendKeys(pass);}
	public void setLogin() {	btnLogin.click();}

}

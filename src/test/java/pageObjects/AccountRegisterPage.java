package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegisterPage extends BasePage {

	public AccountRegisterPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Locators
	@FindBy(xpath="//input[@name='firstname']") WebElement txtfirstname;
	@FindBy(xpath="//input[@name='lastname']") WebElement txtlastname;
	@FindBy(xpath="//input[@name='email']") WebElement txtemail;
	@FindBy(xpath="//input[@name='telephone']") WebElement txttelephone;
	@FindBy(xpath="//input[@name='password']") WebElement txtpassword;
	@FindBy(xpath="//input[@name='confirm']") WebElement txtconfirmpassword;
	@FindBy(xpath="//input[@name='newsletter'][1]") WebElement rdnewsletter;
	@FindBy(xpath="//input[@name='agree']") WebElement chkagree;
	@FindBy(xpath="//input[@value=\"Continue\"]") WebElement btnContinue;
	@FindBy(xpath="//h1[text()=\"Your Account Has Been Created!\"]") WebElement txtMsg;
	@FindBy(xpath="//a[text()=\"Continue\"]") WebElement btnSuccesContinue;
	
	
	
	//Action Methods
	public void setFirstName(String fname) { txtfirstname.sendKeys(fname);	}
	public void setLastName(String lname) { txtlastname.sendKeys(lname);	}
	public void setEmail(String email) { txtemail.sendKeys(email);	}
	public void settelephone(String telephone) { txttelephone.sendKeys(telephone);	}
	public void setPassword(String password) { txtpassword.sendKeys(password);	}
	public void setconfirmPassword(String confirmpassword) { txtconfirmpassword.sendKeys(confirmpassword);	}
	public void setNewsletter() { rdnewsletter.click();	}
	public void setAgree() { chkagree.click();	}
	public void setContinue() { btnContinue.click();	}
	public String getSuccessMsg() {  try {return (txtMsg.getText());}catch(Exception e){ return(e.getMessage());}	}
	public void setSuccesContinue() { btnSuccesContinue.click();	}
	
	

}

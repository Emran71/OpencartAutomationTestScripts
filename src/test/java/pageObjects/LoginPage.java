package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);		
	}

	 @FindBy(xpath = "//input[@id='input-email']")
	   WebElement login_email;
	 

	 @FindBy(xpath = "//input[@id='input-password']")
	   WebElement login_passsword;
	 

	 @FindBy(xpath = "//input[@value='Login']")
	   WebElement click_login;
	 
	 public void setEmail(String email)
	 {
		 login_email.sendKeys(email);
	 }
	 
	 public void setPassword(String pass)
	 {
		 login_passsword.sendKeys(pass);
	 }
	 
	 public void clickLogin()
	 {
		 click_login.click();
	 }
}

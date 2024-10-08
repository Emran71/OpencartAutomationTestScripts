package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	public HomePage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement txt_myAccount;

	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement txt_registert;

	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement txt_login;

	public void clickmyAccount() {
		txt_myAccount.click();
	}

	public void clickregisterMenu() {
		txt_registert.click();
	}

	public void clickRegisterLogin() {
		txt_login.click();
	}
}

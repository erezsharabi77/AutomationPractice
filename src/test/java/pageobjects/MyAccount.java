package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class MyAccount extends BasePage {
	
	@FindBy(css = ".page-heading")
	WebElement header;
	
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	@Step("Get my account page header")
	public String getMyAccountHeader()
	{
		return getText(header);
	}
}

package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class MainPage extends BasePage {
	
	@FindBy(css = ".login")
	WebElement signIn;
	
	public MainPage(WebDriver driver) {
		super(driver);
	}

	@Step("Click on Sign in")
	public void clickSignIn()
	{
		click(signIn);
	}
}

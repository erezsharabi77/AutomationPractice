package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class ContactUsPage extends MenuPage {

	@FindBy(css = "#id_contact")
	WebElement subjectHeading;

	@FindBy(css = "[name='id_order']")
	WebElement orderReference;

	@FindBy(css = "#message")
	WebElement message;
	
	@FindBy(css = "#submitMessage")
	WebElement sendMsgBtn;
	
	@FindBy(css = "#\\32 88807_order_products")
	WebElement productDD;
	
	@FindBy(css = ".alert.alert-success")
	WebElement successHeader;
	
	
	public ContactUsPage(WebDriver driver) {
		super(driver);
	}

	@Step("Select subject heading")
	public void fillSubjectHeading(String str)
	{
		selectFromDropDown(subjectHeading, str);
	}
	
	@Step("Select Order Reference")
	public void fillOrderReference(String str)
	{
		selectFromDropDown(orderReference, str);
	}
	
	@Step("Select Product from drop down list")
	public void fillProduct(String str)
	{
		selectFromDropDown(productDD, str);
	}
	
	public void fillMessage(String strMsg)
	{
		fillText(message, strMsg);
	}
	
	public void clickSendMsg()
	{
		click(sendMsgBtn);
	}

	public String getSuccessHeader()
	{
		return getText(successHeader);
	}

}

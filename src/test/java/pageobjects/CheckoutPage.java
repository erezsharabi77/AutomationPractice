package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class CheckoutPage extends BasePage {
	
	@FindBy(css = "a.button.btn.btn-default.standard-checkout")
	WebElement proceedToCheckoutBtn;
	
	@FindBy(css = "#center_column > form > p > button")
	WebElement addressProceedToCheckoutBtn;
	
	@FindBy(css = "#form > p > button")
	WebElement shippingProceedToCheckoutBtn;
	
	@FindBy(css = "#cgv")
	WebElement termsCheckbox;
	
	@FindBy(css = ".bankwire")
	WebElement bankWireBtn;
	
	@FindBy(css = "#cart_navigation > button")
	WebElement confirmOrderBtn;
	
	@FindBy(css = ".page-heading")
	WebElement confirmationHeader;
	
	@FindBy(css = "#cart_title")
	WebElement shoppingCartHeader;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@Step("Click on 'Proceed to checkout' button")
	public void clickProceedToCheckout()
	{
		click(proceedToCheckoutBtn);
	}
	
	@Step("Click on 'Proceed to checkout' button from checkout addresses frame/page")
	public void clickAddressProceedToCheckout()
	{
		click(addressProceedToCheckoutBtn);
	}
	
	@Step("Click on 'Proceed to checkout' button from checkout shipping frame/page")
	public void clickShippingProceedToCheckout()
	{
		click(shippingProceedToCheckoutBtn);
	}
	
	@Step("Click on terms of service checkbox")
	public void clickTermsCheckbox()
	{
		click(termsCheckbox);
	}
	
	@Step("Click on pay by bank wire")
	public void clickPayByBankWire()
	{
		click(bankWireBtn);
	}
	
	@Step("Click on confirm order button")
	public void clickConfirmOrder()
	{
		click(confirmOrderBtn);
	}
	
	@Step("Get confirmation header")
	public String getConfirmationHeader()
	{
		return getText(confirmationHeader);
	}
	
	@Step("Get shopping cart header")
	public String getShoppingCartHeader()
	{
		return getText(shoppingCartHeader);
	}
	
}

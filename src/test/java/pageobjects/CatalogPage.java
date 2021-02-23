package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class CatalogPage extends MenuPage {

	@FindBy(css = ".button.ajax_add_to_cart_button.btn.btn-default")
	List<WebElement> AddToCartList;

	@FindBy(css = "[title='Continue shopping']")
	WebElement continueShopping;

	@FindBy(css = ".icon-th-list")
	WebElement listView;

	@FindBy(css = "[itemprop='name'] a")
	WebElement productName;


	public CatalogPage(WebDriver driver) {
		super(driver);
	}

	@Step("Add all products to cart from catalog page")
	public void addAllToCart()
	{
		for (WebElement elem : AddToCartList) {
			click(elem);
			wait.until(ExpectedConditions.elementToBeClickable(continueShopping));
			click(continueShopping);
		}
	}
	
	@Step("Change Grid view to List view to see the 'Add to Cart' buttons")
	public void clickOnListView()
	{
		click(listView);
	}
	
	public String getProductName()
	{
		return getText(productName);
	}


}

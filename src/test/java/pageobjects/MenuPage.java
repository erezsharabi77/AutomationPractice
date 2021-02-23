package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import io.qameta.allure.Step;

public class MenuPage extends BasePage {

	@FindBy(css = "#block_top_menu > ul > li:nth-child(1) > a")
	WebElement woman;
	
	@FindBy(css = ".submenu-container.clearfix.first-in-line-xs [title='T-shirts']")
	WebElement womanTShirt;
	
	@FindBy(css = ".submenu-container.clearfix.first-in-line-xs [title='Summer Dresses']")
	WebElement womanSummerDress;
	
	@FindBy(css = "[title='View my shopping cart']")
	WebElement viewShoppingCart;
	
	@FindBy(css = "#button_order_cart")
	WebElement checkout;
	
	@FindBy(css = ".logout")
	WebElement signOut;
	
	@FindBy(css = ".login")
	WebElement signIn;
	
	@FindBy(css = "#search_query_top")
	WebElement searchField;
	
	@FindBy(css = "[name='submit_search']")
	WebElement searchBtn;
	
	
		
	
	public MenuPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Mouse hover woman category and click on T-Shirts")
	public void clickWomanTShirts()
	{
		MouseHover(woman);
		click(womanTShirt);
	}
	
	@Step("Mouse hover woman category and click on Summer Dress")
	public void clickWomanSummerDress()
	{
		MouseHover(woman);
		click(womanSummerDress);
	}

	@Step("Mouse hover cart and click on checkout")
	public void clickCheckout()
	{
		MouseHover(viewShoppingCart);
		click(checkout);
	}
	
	@Step("Click on Sign Out")
	public void clickSignOut()
	{
		click(signOut);
	}
	
	@Step("Click on Sign in")
	public void clickSignIn()
	{
		click(signIn);
	}
	
	@Step("Validate signout has been done successfully")
	public boolean isLogout()
	{
		return isExist(signIn);
	}
	
	@Step("Search for a product {prdName}")
	public void searchProduct(String prdName)
	{
		fillText(searchField, prdName);
	}
	
	@Step("Click on Search button")
	public void clickSearch()
	{
		click(searchBtn);
	}
}

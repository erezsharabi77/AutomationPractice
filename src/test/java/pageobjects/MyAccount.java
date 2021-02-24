package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class MyAccount extends BasePage {
	
	@FindBy(css = ".page-heading")
	WebElement header;
	
	@FindBy(css = ".icon-heart")
	WebElement wishListBtn;
	
	@FindBy(css = "td:nth-child(1) > a")
	WebElement myWishlist;
	
	@FindBy(css = "#s_title")
	WebElement productName;
	
	@FindBy(css = ".icon-remove")
	WebElement deleteWishlist;
	
	
	
	public MyAccount(WebDriver driver) {
		super(driver);
	}
	
	@Step("Get my account page header")
	public String getMyAccountHeader()
	{
		return getText(header);
	}
	
	@Step("Click on My Wishlists button")
	public void clickMyWishListBtn()
	{
		click(wishListBtn);
		sleep(1000);
	}
	
	@Step("Click on My Wishlist")
	public void clickMyWishList()
	{
		click(myWishlist);
		sleep(1000);
	}
	
	@Step("Get the product name from my wishlist page")
	public String getProductName()
	{
		wait.until(ExpectedConditions.visibilityOf(productName));
		return getText(productName);
	}
	
	@Step("Remove/delete wishlist in my account page")
	public void clickDeleteWishlist()
	{
		click(deleteWishlist);
		driver.switchTo().alert().accept();
	}
}

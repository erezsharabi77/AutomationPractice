package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageobjects.AuthenticationPage;
import pageobjects.CheckoutPage;
import pageobjects.MainPage;
import pageobjects.MenuPage;
import pageobjects.MyAccount;
import pageobjects.CatalogPage;
import utils.Utils;

public class BuyWomanTShirtTest extends BaseTest {
	
	
	@Test(description = "tc01_Login")
	@Description("Login with existing user")
	public void tc01_Login() throws IOException
	{
		System.out.println("Login Test Begins");
		System.out.println("*******START LOGIN****************");
		MenuPage mp = new MenuPage(driver);
		mp.clickSignIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		//Fill email address and password to login
		ap.FillCustomerEmail(Utils.readProperty("email"));
		ap.FillCustomerPassword(Utils.readProperty("password"));
		ap.clickLogin();
		MyAccount ma = new MyAccount(driver);
		//verify the user has been logged in successfully
		Assert.assertEquals(ma.getMyAccountHeader(), "MY ACCOUNT");
		System.out.println("*******END LOGIN****************");
	}
	
	@Test(description = "tc02_AddTShirtProducts")
	@Description("Add all Woman T-Shirts products to cart")
	public void tc02_AddTShirtProducts() throws IOException
	{
		System.out.println("Buy Woman T-Shirt");
		System.out.println("*******START BUY T-SHIRT****************");
		MenuPage mp = new MenuPage(driver);
		mp.clickWomanTShirts();
		CatalogPage cp = new CatalogPage(driver);
		cp.clickOnListView();
		cp.addAllToCart();
		cp.clickCheckout();
		CheckoutPage cop = new CheckoutPage(driver);
		Assert.assertTrue(cop.getShoppingCartHeader().contains("SHOPPING-CART SUMMARY"));
//		Assert.assertEquals(cop.getShoppingCartHeader(), "SHOPPING-CART SUMMARY");
		System.out.println("*******END BUY T-SHIRT****************");
	}
	
	@Test(description = "tc03_checkout")
	@Description("Checkout")
	public void tc03_checkout() throws IOException
	{
		System.out.println("*******START CHECKOUT****************");
		CheckoutPage cop = new CheckoutPage(driver);
		cop.clickProceedToCheckout();
		cop.clickAddressProceedToCheckout();
		cop.clickTermsCheckbox();
		cop.clickShippingProceedToCheckout();
		cop.clickPayByBankWire();
		cop.clickConfirmOrder();
		String header = cop.getConfirmationHeader();
		Assert.assertEquals(header, "ORDER CONFIRMATION");
		System.out.println("*******END CHECKOUT****************");
	}
	
	@Test(description = "tc04_Signout")
	@Description("Sign out")
	public void tc04_Signout() throws IOException
	{
		System.out.println("Sign out Test Begins");
		System.out.println("*******START SIGN OUT****************");
		MenuPage mp = new MenuPage(driver);
		mp.clickSignOut();
		boolean actual = mp.isLogout();
		Assert.assertTrue(actual);
		System.out.println("*******END SIGN OUT****************");
	}
}

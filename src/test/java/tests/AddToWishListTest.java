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

public class AddToWishListTest extends BaseTest {
	
	
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
	
	@Test(description = "tc02_AddToWishList")
	@Description("Add Woman T-Shirts product to wish list and verify it's indeed added")
	public void tc02_AddToWishList() throws IOException
	{
		System.out.println("Add T-Shirt product to wish list");
		System.out.println("*******START ADD TO WISH LIST****************");
		MenuPage mp = new MenuPage(driver);
		//Click on Woman TShirts from the menu
		mp.clickWomanTShirts();
		CatalogPage cp = new CatalogPage(driver);
		//Change catalog view to list instead of Grid
		cp.clickOnListView();
		//Get TShirt product name
		String productName = cp.getProductName();
		//Add the product to wish list
		cp.clickOnAddToWishList();
		//Click on the customer name on the top of the page to access his account
		mp.clickViewCustomerAccount();
		
		MyAccount ma = new MyAccount(driver);
		//Click on MY WISHLISTS button
		ma.clickMyWishListBtn();
		//Click on "My wishlist"
		ma.clickMyWishList();
		//Verify the product name in the wish list is equal to the name from the catalog page
		Assert.assertEquals(ma.getProductName(), productName);
		ma.clickDeleteWishlist();
		System.out.println("*******END ADD TO WISH LIST****************");
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

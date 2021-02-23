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

public class SearchProductTest extends BaseTest {
	
	
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
	
	@Test(description = "tc02_SearchProduct")
	@Description("Search Product")
	public void tc02_SearchProduct() throws IOException
	{
		System.out.println("Search Product");
		System.out.println("*******START SEARCH PRODUCT****************");
		MenuPage mp = new MenuPage(driver);
		mp.searchProduct(Utils.readProperty("productName"));
		mp.clickSearch();
		
		CatalogPage cp = new CatalogPage(driver);
		String actual = cp.getProductName();
		Assert.assertEquals(actual, Utils.readProperty("productName"));
		System.out.println("*******END SEARCH PRODUCT****************");
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

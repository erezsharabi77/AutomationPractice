package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageobjects.AuthenticationPage;
import pageobjects.CheckoutPage;
import pageobjects.ContactUsPage;
import pageobjects.MainPage;
import pageobjects.MenuPage;
import pageobjects.MyAccount;
import pageobjects.CatalogPage;
import utils.Utils;

public class ContactUsTest extends BaseTest {
	
	
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
	
	@Test(description = "tc02_contactUs")
	@Description("Contact Us")
	public void tc02_contactUs() throws IOException
	{
		System.out.println("Contact Us");
		System.out.println("*******START CONTACT US****************");
		MenuPage mp = new MenuPage(driver);
		mp.clickContactUs();
		ContactUsPage cup = new ContactUsPage(driver);
		cup.fillSubjectHeading("Customer service");
		cup.fillOrderReference("PDQLNDDLU - 02/23/2021");
		cup.fillProduct("Printed Summer Dress - Color : Yellow, Size : S");
		cup.fillMessage("Can you please tell me the price of this product?");
		cup.clickSendMsg();
		String actual = cup.getSuccessHeader();
		Assert.assertEquals(actual, "Your message has been successfully sent to our team.");
		System.out.println("*******END CONTACT US****************");
	}
	
	
	@Test(description = "tc03_Signout")
	@Description("Sign out")
	public void tc03_Signout() throws IOException
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

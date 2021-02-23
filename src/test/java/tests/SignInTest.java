package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import pageobjects.AuthenticationPage;
import pageobjects.MainPage;
import pageobjects.MyAccount;
import utils.Utils;

public class SignInTest extends BaseTest {
	
	
	@Test(description = "tc01_Signin")
	@Description("Sign in with new user")
	public void tc01_Signin() throws IOException
	{
		System.out.println("SignIn Test Begins");
		System.out.println("*******START SIGNIN****************");
		MainPage mp = new MainPage(driver);
		mp.clickSignIn();
		AuthenticationPage ap = new AuthenticationPage(driver);
		String randomEmail = ap.getAlphaNumericString(7);
		System.out.println(randomEmail);
		ap.FillEmailCreateAddress(randomEmail + "@gmail.com");
		ap.clickCreateAccount();
		//Fill out registration form
		ap.clickMrGender();
		ap.FillCustomerFirstName(Utils.readProperty("firstName"));
		ap.FillCustomerLastName(Utils.readProperty("lastName"));
		ap.FillCustomerPassword(Utils.readProperty("password"));
		ap.FillCustomerBirthDay("27  ", "February ", "1977  ");
		ap.FillCustomerAddFirstName(Utils.readProperty("firstName"));
		ap.FillCustomerAddLastName(Utils.readProperty("lastName"));
		ap.FillCustomerAddress(Utils.readProperty("address"));
		ap.FillCustomerCity(Utils.readProperty("city"));
		ap.FillCustomerState(Utils.readProperty("state"));
		ap.FillCustomerZipCode(Utils.readProperty("zipCode"));
		ap.FillCustomerCountry(Utils.readProperty("country"));
		ap.FillCustomerMobile(Utils.readProperty("mobile"));
		ap.FillCustomerAddressAlias("My Address");
		//Finish fill out registration form
		
		//Click on register
		ap.clickRegister();
		MyAccount ma = new MyAccount(driver);
		Assert.assertEquals(ma.getMyAccountHeader(), "MY ACCOUNT");
		System.out.println("*******END SIGNIN****************");
	}
}

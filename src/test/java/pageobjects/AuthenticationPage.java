package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.qameta.allure.Step;

public class AuthenticationPage extends BasePage {
	
	@FindBy(css = "#email_create")
	WebElement emailCreateAddress;
	
	@FindBy(css = "#SubmitCreate")
	WebElement SubmitCreate;
	
	@FindBy(css = "#id_gender1")
	WebElement mrRadioBtn;
	
	@FindBy(css = "#id_gender2")
	WebElement mrsRadioBtn;
	
	@FindBy(css = "#customer_firstname")
	WebElement firstName;
	
	@FindBy(css = "#customer_lastname")
	WebElement lastName;
	
	@FindBy(css = "#passwd")
	WebElement password;
	
	@FindBy(css = "#days")
	WebElement day;
	
	@FindBy(css = "#months")
	WebElement month;
	
	@FindBy(css = "#years")
	WebElement year;
	
	@FindBy(css = "#firstname")
	WebElement addressFirstName;
	
	@FindBy(css = "#lastname")
	WebElement addressLastName;

	@FindBy(css = "#address1")
	WebElement address;
	
	@FindBy(css = "#city")
	WebElement city;
	
	@FindBy(css = "#id_state")
	WebElement state;
	
	@FindBy(css = "#postcode")
	WebElement zipCode;
	
	@FindBy(css = "#id_country")
	WebElement country;
	
	@FindBy(css = "#phone_mobile")
	WebElement mobile;
	
	@FindBy(css = "#alias")
	WebElement addressAlias;
	
	@FindBy(css = "#submitAccount")
	WebElement registerBtn;
	
	@FindBy(css = "#email")
	WebElement email;
	
	@FindBy(css = "#SubmitLogin")
	WebElement loginBtn;
	
	
	public AuthenticationPage(WebDriver driver) {
		super(driver);
	}
	
	@Step("Fill email address for user creation")
	public void FillEmailCreateAddress(String email)
	{
		fillText(emailCreateAddress,email);
	}
	
	@Step("Click on create an account")
	public void clickCreateAccount()
	{
		click(SubmitCreate);
	}
	
	@Step("Click on Mr. radio button")
	public void clickMrGender()
	{
		wait.until(ExpectedConditions.elementToBeClickable(mrRadioBtn));
		click(mrRadioBtn);
	}
	
	@Step("Fill customer first name")
	public void FillCustomerFirstName(String strFirstName)
	{
		fillText(firstName,strFirstName);
	}
	
	@Step("Fill customer last name")
	public void FillCustomerLastName(String strLastName)
	{
		fillText(lastName,strLastName);
	}
	
	@Step("Fill customer password")
	public void FillCustomerPassword(String strPassword)
	{
		fillText(password,strPassword);
	}
	
	@Step("Fill customer birth day")
	public void FillCustomerBirthDay(String strDay, String strMonth, String strYear)
	{
		selectFromDropDown(day, strDay);
		selectFromDropDown(month, strMonth);
		selectFromDropDown(year, strYear);
	}
	
	@Step("Fill customer address first name")
	public void FillCustomerAddFirstName(String strFirstName)
	{
		fillText(addressFirstName,strFirstName);
	}
	
	@Step("Fill customer address last name")
	public void FillCustomerAddLastName(String strLastName)
	{
		fillText(addressLastName,strLastName);
	}
	
	@Step("Fill customer address")
	public void FillCustomerAddress(String strAddress)
	{
		fillText(address,strAddress);
	}
	
	@Step("Fill customer city")
	public void FillCustomerCity(String strCity)
	{
		fillText(city,strCity);
	}
	
	@Step("Select state from drop down list")
	public void FillCustomerState(String strState)
	{
		selectFromDropDown(state, strState);
	}
	
	@Step("Fill customer zip code")
	public void FillCustomerZipCode(String strZipCode)
	{
		fillText(zipCode,strZipCode);
	}
	
	@Step("Select country from drop down list")
	public void FillCustomerCountry(String strCountry)
	{
		selectFromDropDown(country, strCountry);
	}
	
	@Step("Fill customer mobile phone number")
	public void FillCustomerMobile(String strMobilePhone)
	{
		fillText(mobile,strMobilePhone);
	}
	
	@Step("Fill customer address alias")
	public void FillCustomerAddressAlias(String strAlias)
	{
		fillText(addressAlias,strAlias);
	}
	
	@Step("Click on Register button")
	public void clickRegister()
	{
		click(registerBtn);
	}
	
	@Step("Fill customer login email address")
	public void FillCustomerEmail(String strEmail)
	{
		fillText(email,strEmail);
	}
	
	@Step("Click on Login button")
	public void clickLogin()
	{
		click(loginBtn);
	}
	
}

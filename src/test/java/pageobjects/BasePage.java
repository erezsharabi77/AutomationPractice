package pageobjects;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	JavascriptExecutor js; 
	WebDriverWait wait;
	WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js=(JavascriptExecutor)driver;
		wait = new WebDriverWait(driver, 15);
	}

	//Fill a given text to a given element
	public void fillText(WebElement el, String text)
	{
		highlightElement(el, "green");
		sleep(300);
		el.clear();
		el.sendKeys(text);
	}
	//Click on a given element
	public void click(WebElement el)
	{
		highlightElement(el, "green");
		sleep(300);
		el.click();
	}

	//Get Text from a given element
	public String getText(WebElement el) {
		highlightElement(el, "green");
		sleep(300);
		return el.getText();
	}

	//Wait for a given milliseconds
	public void sleep(long mills) {
		try {
			Thread.sleep(mills);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Check if element exist
	public boolean isExist(WebElement el)
	{
		return el.isDisplayed();
	}

	//Check if a given list exists
	public boolean isListExist(List<WebElement> list)
	{
		if (list.size() != 0) {
			return true;
		}

		else
			return false;
	}


	//Select from drop down list by text
	public void selectFromDropDown(WebElement el, String text)
	{
		highlightElement(el, "green");
		sleep(300);
		Select drp = new Select(el);
		drp.selectByVisibleText(text);
	}
	
	public static String getAlphaNumericString(int n) 
    { 
  
        // lower limit for LowerCase Letters 
        int lowerLimit = 97; 
  
        // lower limit for LowerCase Letters 
        int upperLimit = 122; 
  
        Random random = new Random(); 
  
        // Create a StringBuffer to store the result 
        StringBuffer r = new StringBuffer(n); 
  
        for (int i = 0; i < n; i++) { 
  
            // take a random value between 97 and 122 
            int nextRandomChar = lowerLimit 
                                 + (int)(random.nextFloat() 
                                         * (upperLimit - lowerLimit + 1)); 
  
            // append a character at the end of bs 
            r.append((char)nextRandomChar); 
        } 
  
        // return the resultant string 
        return r.toString(); 
    }

	/*
	 * Call this method with your element and a color like (red,green,orange etc...)
	 * Use this method to highlight elements on the screen
	 */
	private void highlightElement(WebElement element, String color) {
		//keep the old style to change it back
		String originalStyle = element.getAttribute("style");
		String newStyle = "background-color:yellow; border: 1px solid " + color + ";" + originalStyle;

		// Change the style 
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '" + newStyle + "');},0);",
				element);

		// Change the style back after few milliseconds
		js.executeScript("var tmpArguments = arguments;setTimeout(function () {tmpArguments[0].setAttribute('style', '"
				+ originalStyle + "');},400);", element);

	}
}

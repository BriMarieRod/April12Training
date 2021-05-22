package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TextBoxConfirmationPage extends Page {
	
	private WebElement parentElement;
	
	private By nameLocator = By.xpath(".//p[@id='name']");
	private By emailLocator = By.xpath(".//p[@id='email']");
	private By currentAddressLocator = By.xpath(".//p[@id='currentAddress']");
	private By permanentAddressLocator = By.xpath(".//p[@id='permanentAddress']");

	public TextBoxConfirmationPage(WebDriver driver, WebElement output) {
		super(driver);
		parentElement = output;
	}
	
	public String getName() {
		WebElement nameElement = parentElement.findElement(nameLocator);
		return nameElement.getText();
	}
	
	public String getEmail() {
		WebElement emailElement = parentElement.findElement(emailLocator);
		return emailElement.getText();
	}
	
	public String getCurrentAddress() {
		WebElement currentAddressElement = parentElement.findElement(currentAddressLocator);
		return currentAddressElement.getText();
	}
	
	public String getPermanentAddress() {
		WebElement permanentAddressElement = parentElement.findElement(permanentAddressLocator);
		return permanentAddressElement.getText();
	}
	
	public void waitForLoaded() {
		(new WebDriverWait(driver, 2)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return getName().length() != 0;
			}
		});
	}

}

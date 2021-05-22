package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TextBoxPage extends Page {
	
	private String pageUrl = "https://demoqa.com/text-box";
	
	@FindBy(how = How.ID, using = "userName")
	private WebElement userNameTextBox;
	
	@FindBy(how = How.ID, using = "userEmail")
	private WebElement userEmailTextBox;
	
	@FindBy(how = How.ID, using = "currentAddress")
	private WebElement currentAddressTextBox;
	
	@FindBy(how = How.ID, using = "permanentAddress")
	private WebElement permanentAddressTextBox;
	
	@FindBy(how = How.ID, using = "submit")
	private WebElement submitButton;
	
	public TextBoxPage(WebDriver driver) {
		super(driver);
	}
	
	public TextBoxPage enterData(String userName, String userEmail, String currentAddress, String permanentAddress) {
		
		userNameTextBox.sendKeys(userName);
		userEmailTextBox.sendKeys(userEmail);
		currentAddressTextBox.sendKeys(currentAddress);
		permanentAddressTextBox.sendKeys(permanentAddress);
		
		return this;
		
	}
	
	public TextBoxConfirmationPage submit() {
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)",submitButton);
		submitButton.click();
		
		WebElement output = driver.findElement(By.id("output"));
		
		TextBoxConfirmationPage results = new TextBoxConfirmationPage(driver, output);
		results.waitForLoaded();
		
		return results;
		
	}
	
	public TextBoxPage navigate() {
		
		driver.navigate().to(pageUrl);
		
		return this;
		
	}
	
}

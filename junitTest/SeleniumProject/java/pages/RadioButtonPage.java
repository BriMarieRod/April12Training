package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonPage extends Page {
	
	private String pageUrl = "https://demoqa.com/radio-button";
	
	private By yesRadioButtonLocator = By.xpath(".//label[@for='yesRadio']");
	private By impressiveRadioButtonLocator = By.xpath(".//label[@for='impressiveRadio']");
	
	public RadioButtonPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement clickYes() {
		
		driver.findElement(yesRadioButtonLocator).click();
		
		return getOutput();
		
	}
	
	public WebElement clickImpressive() {
		
		driver.findElement(impressiveRadioButtonLocator).click();
		
		return getOutput();
		
	}
	
	private WebElement getOutput() {
		
		return driver.findElement(By.className("text-success"));
		
	}
	
	public RadioButtonPage navigate() {
		
		driver.navigate().to(pageUrl);
		
		return this;
		
	}

}

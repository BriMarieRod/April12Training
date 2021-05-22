package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DynamicPropertiesPage extends Page {
	
	private String pageUrl = "https://demoqa.com/dynamic-properties";
	
	private By buttonLocator = By.xpath(".//button[@id='visibleAfter']");
	
	public DynamicPropertiesPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitForButtonToBeVisible() {
		(new WebDriverWait(driver, 6)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElement(buttonLocator) != null;
			}
		});
	}
	
	public DynamicPropertiesPage navigate() {
		driver.navigate().to(pageUrl);
		return this;
	}

}

package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinksPage extends Page {
	
	private String pageUrl = "https://demoqa.com/links";
	
	private By joinNowButtonLocator = By.xpath(".//a[@href='https://www.toolsqa.com/selenium-training/']");
	private By createdStatusLocator = By.xpath(".//p[@id='linkResponse']/b[2]");
	
	@FindBy(how = How.ID, using = "simpleLink")
	private WebElement homeLink;
	
	@FindBy(how = How.ID, using = "created")
	private WebElement createdLink;
	
	public LinksPage(WebDriver driver) {
		super(driver);
	}
	
	public WebElement clickCreatedLink() {
		
		createdLink.click();
		
		loadResponse();
		
		return driver.findElement(createdStatusLocator);
		
	}
	
	private void loadResponse() {
		
		(new WebDriverWait(driver, 2)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.findElement(createdStatusLocator) != null;
			}
		});
		
	}
	
	public void navigateToAndClickJoinNow() {
		
		clickHomeLink();
		loadNewTab();
		switchTabs();
		clickJoinNow();
		
	}
	
	private void clickHomeLink() {
		
		homeLink.click();
		
	}
	
	private void loadNewTab() {
		
		(new WebDriverWait(driver, 2)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return driver.getWindowHandles().size() == 2;
			}
		});
		
	}
	
	private void switchTabs() {
		
		String currentWindow = driver.getWindowHandle();		
		for(String windowHandle : driver.getWindowHandles()) {
			if(!windowHandle.equals(currentWindow)) {
				driver.switchTo().window(windowHandle);
				break;
			}
		}
		
	}
	
	private void clickJoinNow() {
		
		driver.findElement(joinNowButtonLocator);
		
	}
	
	public LinksPage navigate() {
		
		driver.navigate().to(pageUrl);
		
		return this;
		
	}

}

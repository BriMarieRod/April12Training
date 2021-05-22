package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.RadioButtonPage;

public class RadioButtonPageTest extends PageTest {
	
  @Test
  public void canClickYes() {
	  
	  String expectedOutput = "Yes";
	  
	  WebElement result = new RadioButtonPage(driver)
			  .navigate()
			  .clickYes();
	  
	  String actualOutput = result.getText();
	  
	  assertEquals(actualOutput, expectedOutput);
	  
  }
  
  @Test
  public void canClickImpressive() {
	  
	  String expectedOutput = "Impressive";
	  
	  WebElement result = new RadioButtonPage(driver)
			  .navigate()
			  .clickImpressive();
	  
	  String actualOutput = result.getText();
	  
	  assertEquals(actualOutput, expectedOutput);
	  
  }
  
}

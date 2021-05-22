package tests;

import org.testng.annotations.Test;

import pages.DynamicPropertiesPage;

public class DynamicPropertiesPageTest extends PageTest {
	
	@Test
	public void buttonBecomesVisible() {
		
		DynamicPropertiesPage page = new DynamicPropertiesPage(driver).navigate();
		page.waitForButtonToBeVisible();
		
	}
  
}

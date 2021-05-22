package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LinksPage;

public class LinksPageTest extends PageTest {
	
	@Test
	public void canNavigateToAndClickJoinNow() {
		
		LinksPage page = new LinksPage(driver).navigate();
		
		page.navigateToAndClickJoinNow();
		
	}
	
	@Test
	public void canClickCreatedLink() {
		
		String expectedOutput = "Created";
		
		LinksPage page = new LinksPage(driver).navigate();
		
		String actualOutput = page.clickCreatedLink().getText();
		
		assertEquals(actualOutput, expectedOutput);
		
	}
  
}

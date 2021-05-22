package tests;

import org.testng.annotations.Test;

import pages.TextBoxConfirmationPage;
import pages.TextBoxPage;

import static org.testng.Assert.assertEquals;

public class TextBoxPageTest extends PageTest {
	
	@Test
	public void canSubmitTextBox() {
		
		String userName = "Name";
		String userEmail = "name@email.com";
		String currentAddress = "Here";
		String permanentAddress = "There";
		
		String expectedName = "Name:" + userName;
		String expectedEmail = "Email:" + userEmail;
		String expectedCurrentAddress = "Current Address :" + currentAddress;
		String expectedPermanentAddress = "Permananet Address :" + permanentAddress;
		
		TextBoxConfirmationPage results = new TextBoxPage(driver)
				.navigate()
				.enterData(userName, userEmail, currentAddress, permanentAddress)
				.submit();
		
		String actualName = results.getName();
		String actualEmail = results.getEmail();
		String actualCurrentAddress = results.getCurrentAddress();
		String actualPermanentAddress = results.getPermanentAddress();
		
		assertEquals(actualName, expectedName);
		assertEquals(actualEmail, expectedEmail);
		assertEquals(actualCurrentAddress, expectedCurrentAddress);
		assertEquals(actualPermanentAddress, expectedPermanentAddress);
		
	}

}

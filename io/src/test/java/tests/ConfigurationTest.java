package tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.testng.annotations.Test;

import framework.ConfigurationProvider;

public class ConfigurationTest {
	
	@Test
	public void canGetChromeValue() {
		
		String fileName = "config.properties";
		HashMap<String, String> fileProperties = null;
		
		try {
			fileProperties = new ConfigurationProvider().getPropertiesFromResourceFile(fileName);
		} catch(Exception e) {
			System.out.println(e.toString());
		}
		
		String expectedBrowserTypeValue = "chrome";
		String actualBrowserTypeValue = fileProperties.get("BrowserType");
		
		assertEquals(actualBrowserTypeValue, expectedBrowserTypeValue);
		
	}
  
}

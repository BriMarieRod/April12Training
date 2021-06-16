package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.equalTo;

public class ReqresTests {

	private String baseUrl = "https://reqres.in/";

	@BeforeTest
	public void setBaseUri() {
		RestAssured.baseURI = baseUrl;
	}

	@Test
	public void verifyUserEmail() {

		String path = "api/users/2";
		String jsonPath = "data.email";
		
		String expectedEmail = "janet.weaver@reqres.in";

		RestAssured.get(path).then().body(jsonPath, equalTo(expectedEmail));

	}

}

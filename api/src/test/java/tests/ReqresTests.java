package tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

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
	
	@Test
	public void verifyTokenReturnValue() {
		
		String path = "api/login";
		String email = "eve.holt@reqres.in";
		String password = "cityslicka";
		String jsonPath = "token";
		
		String expectedToken = "QpwL5tke4Pnpja7X4";
		
		JSONObject json = new JSONObject();
		json.put("email", email);
		json.put("password", password);
		
		RestAssured
		.given().contentType("application/json").body(json.toString())
		.when().post(path)
		.then().body(jsonPath, equalTo(expectedToken));
		
	}
	
	@Test
	public void verifyDeleteResponseCode() {
		
		String path = "api/users/2";
		
		RestAssured.delete(path).then().statusCode(204); // Status code 204 = No Content
		
	}
	
	@Test
	public void ensurePatchTimestampUpdated() {
		
		String path = "api/users/2";
		String newName = "morpheus2";
		String jsonPath = "updatedAt";
		
		JSONObject json = new JSONObject();
		json.put("name", newName);
		
		RestAssured.patch(path).then().body(jsonPath, notNullValue());
		
	}

}

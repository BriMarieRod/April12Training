package tests;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import dataHandling.User;
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

		RestAssured.given().contentType("application/json").body(json.toString()).when().post(path).then()
				.body(jsonPath, equalTo(expectedToken));

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

	@Test
	public void ensurePutTimestampUpdated() {

		String path = "api/users/2";
		String newName = "morpheus2";
		String jsonPath = "updatedAt";

		JSONObject json = new JSONObject();
		json.put("name", newName);

		RestAssured.put(path).then().body(jsonPath, notNullValue());

	}

	@Test
	public void canDeserializeSingleUser() {

		String response = RestAssured.get("api/users/2").body().asString();
		JSONObject jsonResponse = new JSONObject(response);
		JSONObject userData = jsonResponse.getJSONObject("data");

		ObjectMapper objectMapper = new ObjectMapper();
		User user = null;
		try {
			user = objectMapper.readValue(userData.toString(), User.class);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		int expectedId = userData.getInt("id");
		String expectedEmail = userData.getString("email");
		String expectedFirstName = userData.getString("first_name");
		String expectedLastName = userData.getString("last_name");
		String expectedAvatar = userData.getString("avatar");
		
		int actualId = user.getId();
		String actualEmail = user.getEmail();
		String actualFirstName = user.getFirstName();
		String actualLastName = user.getLastName();
		String actualAvatar = user.getAvatar();
		
		assertEquals(actualId, expectedId);
		assertEquals(actualEmail, expectedEmail);
		assertEquals(actualFirstName, expectedFirstName);
		assertEquals(actualLastName, expectedLastName);
		assertEquals(actualAvatar, expectedAvatar);

	}
	
	@Test
	public void canDeserializeUserList() {
		
		String response = RestAssured.get("api/users").body().asString();
		JSONObject jsonResponse = new JSONObject(response);
		JSONArray usersData = jsonResponse.getJSONArray("data");
		
		ObjectMapper objectMapper = new ObjectMapper();
		List<User> userList = new ArrayList<User>();
		
		for(int i = 0; i < usersData.length(); i++) {
			User newUser = null;
			try {
				newUser = objectMapper.readValue(usersData.get(i).toString(), User.class);
			} catch (Exception e) {
				System.out.println(e);
			}
			userList.add(newUser);
		}
		
		assertTrue(userList.size() > 0);
		
	}

}

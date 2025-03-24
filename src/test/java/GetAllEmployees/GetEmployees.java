package GetAllEmployees;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetEmployees {

	// Get employees

	@Test(enabled = false)
	public void GetEmployee() {
		RestAssured.baseURI = "http://localhost:3000/";

		RequestSpecification requestspecification = RestAssured.given();

		Response response = requestspecification.request(io.restassured.http.Method.GET, "data");

		System.out.println(response.asPrettyString());

		System.out.println(response.getStatusLine());

	}

	// Create employees

	@Test(enabled = false)

	public void createemployee() {

		RestAssured.baseURI = "http://localhost:3000/";

		RequestSpecification requestspecification = RestAssured.given().header("Content-Type", "application/json")
				.body("  {\r\n" + "    \"id\": \"5\",\r\n" + "    \"first_name\": \"prasanth\",\r\n"
						+ "    \"last_name\": \"M\",\r\n" + "    \"email\": \"prasanthM@gmail.com\"\r\n" + "  }");

		Response response = requestspecification.request(Method.POST, "data");

		System.out.println(response.getStatusLine());

		System.out.println(response.asPrettyString());

	}

	@Test(enabled = true)

	public void updateemployees() {

		RestAssured.baseURI = "http://localhost:3000/";

		RequestSpecification requestspecification = RestAssured.given().header("Content-Type", "application/json")
				.body(" {\r\n" + "    \"id\": \"3\",\r\n" + "    \"first_name\": \"maria\",\r\n"
						+ "    \"last_name\": \"javanova\",\r\n" + "    \"email\": \"marianova@gmail.com\"\r\n"
						+ "  }\r\n" + "\r\n" + "");

		Response respose = requestspecification.request(Method.PUT, "data/2");

		System.out.println(respose.getStatusLine());

		System.out.println(respose.asPrettyString());

	}

}

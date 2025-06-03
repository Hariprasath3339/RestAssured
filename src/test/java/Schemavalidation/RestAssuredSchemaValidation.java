package Schemavalidation;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class RestAssuredSchemaValidation {
	@Test(enabled = false)
	public void SchemaValidation() {

		File input = new File("src/test/resources/input.json");
		given().baseUri("http://localhost:3000/").header("Content-Type", "application/json").body(input).when()
				.post("/data").then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));

	}

	@Test
	public void SchemaValidationwithoutPath() throws FileNotFoundException {

		File input = new File("src/test/resources/input.json");
		// method1 File inputSchema = new File("src/test/resources/schema.json");
		// method2 FileInputStream inputSchema=new
		// FileInputStream("src/test/resources/schema.json");
		Reader inputSchema = new FileReader("src/test/resources/schema.json");
		given().baseUri("http://localhost:3000/").header("Content-Type", "application/json").body(input).when()
				.post("/data").then()
				.body(JsonSchemaValidator
						.matchesJsonSchema("{\r\n" + "  \"$schema\": \"http://json-schema.org/draft-04/schema#\",\r\n"
								+ "  \"type\": \"object\",\r\n" + "  \"properties\": {\r\n" + "    \"id\": {\r\n"
								+ "      \"type\": \"string\"\r\n" + "    },\r\n" + "    \"first_name\": {\r\n"
								+ "      \"type\": \"string\"\r\n" + "    },\r\n" + "    \"last_name\": {\r\n"
								+ "      \"type\": \"string\"\r\n" + "    },\r\n" + "    \"email\": {\r\n"
								+ "      \"type\": \"string\"\r\n" + "    }\r\n" + "  },\r\n" + "  \"required\": [\r\n"
								+ "    \"id\",\r\n" + "    \"first_name\",\r\n" + "    \"last_name\",\r\n"
								+ "    \"email\"\r\n" + "  ]\r\n" + "}"));

	}

}

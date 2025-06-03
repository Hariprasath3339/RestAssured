package Schemavalidation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class NetworkNTjsonschemavalidator {
	@Test
	public void Network() throws IOException {

		ObjectMapper obj = new ObjectMapper();

		JsonSchemaFactory Jsonfactory = JsonSchemaFactory.getInstance(VersionFlag.V4);

		File inputjson = new File("src/test/resources/input.json");
		InputStream inputschema = new FileInputStream("src/test/resources/schema.json");
		JsonNode jsonnode = obj.readTree(inputjson);

		com.networknt.schema.JsonSchema schema = Jsonfactory.getSchema(inputschema);

		Set<ValidationMessage> result = schema.validate(jsonnode);

		if (result.isEmpty()) {
			System.out.println("No validation errors");
		} else {
			for (ValidationMessage Message : result) {
				System.out.println(Message);
			}
		}

	}

}

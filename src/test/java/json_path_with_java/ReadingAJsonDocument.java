package json_path_with_java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class ReadingAJsonDocument {

	public static void ParseEveryTime() throws IOException {

		File jsofile = new File("src/test/resources/bookstore.json");
		List<Object> pricelist = JsonPath.read(jsofile, "$..price");

		for (Object price : pricelist) {
			System.out.println(price);
		}

	}

	public static void parseOneTime() throws IOException {

		FileInputStream jsofile = new FileInputStream("src/test/resources/bookstore.json");

		Object parsejsondoc = Configuration.defaultConfiguration().jsonProvider().parse(jsofile.readAllBytes());
		List<Object> author = JsonPath.read(parsejsondoc, "$..author");

		for (Object author1 : author) {
			System.out.println(author1);
		}

	}

	public static void fluentAPI() throws IOException {
		File jsofile = new File("src/test/resources/bookstore.json");
		DocumentContext context = JsonPath.parse(jsofile);
		List<Object> author = context.read("$..author");
		for (Object author1 : author) {
			System.out.println(author1);
		}

		Configuration configuration = Configuration.defaultConfiguration();

		JsonPath
		.using(configuration)
		.parse(jsofile)
		.read("$..author");
		
		for (Object author1 : author) {
			System.out.println(author1);
		}
	}

	public static void main(String[] args) throws IOException {
		fluentAPI();
	}

}

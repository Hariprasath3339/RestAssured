package json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class KnowWhatIsReturned {

	public static void main(String[] args) throws IOException {

		File jsofile = new File("src/test/resources/bookstore.json");
		List<Object> pricelist = JsonPath.read(jsofile, "$.store.book[*].author");

		for (Object price : pricelist) {
			System.out.println(price);
		}

	}

}

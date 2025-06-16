package json_path_with_java;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jayway.jsonpath.JsonPath;

public class InlinePredicate {

	File file = new File("src/test/resources/bookstore.json");

	public void InlinePredicateexp() throws IOException {

		List<Object> result = JsonPath.parse(file).read("$.store.book[?(!(@.price>10 || @.category=='fiction'))]");
		
		//$.store.book[?(@.price<10 && @.category=='author')]
		//$.store.book[?(@.price<10 || @.category=='author')]

		System.out.println(result);

	}

	public static void main(String[] args) throws IOException {

		InlinePredicate I = new InlinePredicate();
		I.InlinePredicateexp();

	}

}

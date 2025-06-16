package json_path_with_java;

import static com.jayway.jsonpath.Criteria.where;
import static com.jayway.jsonpath.Filter.filter;
import static com.jayway.jsonpath.JsonPath.parse;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class FilterPredicate {

	static File file = new File("src/test/resources/bookstore.json");

	public void FirstFilter() throws IOException {

		Filter priceLessThanTen1 = Filter.filter(Criteria.where("price").lt(10));

		List<Object> result = JsonPath.parse(file).read("$.store.book[?]", priceLessThanTen1);

		System.out.println(result);
	}

	public static void secondfilter() throws IOException {

		Filter pricelessthanten2 = Filter.filter(Criteria.where("price").lt(10).and("category").is("fiction"));

		List<Map<String, Object>> result = JsonPath.parse(file).read("$.store.book[?]", pricelessthanten2);

		System.out.println(result.get(0).get("author"));

	}

	public static void thirdfilter() throws IOException {

		Filter pricegreaterthan10 = filter(where("price").gt(10).and("category").is("fiction"));

		List<Map<String, Object>> result = parse(file).read("$.store.book[?]", pricegreaterthan10);

		System.out.println(result);

	}

	public static void main(String[] args) throws IOException {
		FilterPredicate exp = new FilterPredicate();
		exp.thirdfilter();
	}
}

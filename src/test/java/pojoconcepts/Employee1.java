package pojoconcepts;

import java.util.Arrays;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Employee1 {

	public static void main(String[] args) throws JsonProcessingException {

		pojo emp = new pojo();
		emp.setFirstName("hari");
		emp.setLastName("Prasath");
		emp.setEmail("hariprasathanagarajan35@gmail.com");
		emp.setSkills(Arrays.asList("java", "selenium"));

		System.out.println(emp.getFirstName());
		System.out.println(emp.getLastName());
		System.out.println(emp.getEmail());
		System.out.println(emp.getSkills());

		// serialize into json

		ObjectMapper mapper = new ObjectMapper();

		String jsonmapper = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);

		System.out.println(jsonmapper);

	}

}

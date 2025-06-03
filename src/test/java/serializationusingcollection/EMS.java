package serializationusingcollection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class EMS {
    @Test
    public void Serialization() {

        Map<String, Object> json = new HashMap<>();

        List<String> Listofdrp = new ArrayList<>();
        Listofdrp.add("java");
        Listofdrp.add("selenium");

        json.put("first_name", "hari");
        json.put("last_name", "prasath");
        json.put("email", "herculeshari007@gmail.com");
        json.put("skills", Listofdrp); // add the list properly instead

   
        System.out.println(json);

        given()
            .baseUri("http://localhost:3000/")
            .header("Content-Type", "application/json")
            .body(json)
            .log().all()
        .when()
            .post("data")
        .then()
            .log().all();
    }
}

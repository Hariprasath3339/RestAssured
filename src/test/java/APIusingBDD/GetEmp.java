package APIusingBDD;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

import java.io.File;

public class GetEmp {
	
    @Test(enabled=false)
	public void GetEmployee() {
		
		 given()
		.baseUri("http://localhost:3000/")
		.when()
		.get("data")
		.prettyPrint();

	}
    
    
    @Test(enabled=false)
    
    public void createemp()
    {
    	given()
    	.baseUri("http://localhost:3000/")
    	.header("Content-Type", "application/json")
    	.body("  {\r\n" + "    \"id\": \"5\",\r\n" + "    \"first_name\": \"prasanthLV\",\r\n"
				+ "    \"last_name\": \"M\",\r\n" + "    \"email\": \"prasanthM@gmail.com\"\r\n" + "  }")
    	.when()
    	.post("data")
    	.prettyPrint();
    	
    }
    

    @Test(enabled=false)
    
    public void updateemp()
    {
    	given()
    	.baseUri("http://localhost:3000/")
    	.header("Content-Type", "application/json")
    	.body(" {\r\n" + "    \"id\": \"3\",\r\n" + "    \"first_name\": \"maria\",\r\n"
				+ "    \"last_name\": \"javanova\",\r\n" + "    \"email\": \"marianova@gmail.com\"\r\n"
				+ "  }\r\n" + "\r\n" + "")
    	.when()
    	.put("data/2")
    	.prettyPrint();
    
    }
    
    
    @Test(enabled=true)
    
    public void deleteemp()
    {
    	given()
    	.baseUri("http://localhost:3000/")
    	.when()
    	.delete("data/a28d")
    	.prettyPrint();
    }
    
    @Test(enabled=false)
    
    public void createemployeebddjsonfile()
    {
    
    	 
         File file=new File("PostData.json");
       	given()
    	.baseUri("http://localhost:3000/")
    	.header("Content-Type", "application/json")
    	.body(file)
    	.when()
    	.post("data")
    	.prettyPrint();
 
    	
    }
    
    
    
    
    
    
    
    
    
    
   
}

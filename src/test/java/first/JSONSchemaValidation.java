package first;

import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;

public class JSONSchemaValidation {

    @Test
    public void validateLogin(){
        baseURI="https://qa1.ushur.in";
        HashMap request = new HashMap();
        request.put("email","__chandan.jaishankar@ushur.com");
        request.put("password","Chandan@3334");
        JSONObject json = new JSONObject(request);
        given().contentType("application/json").
                body(json.toJSONString()).
                when().
                post("/rest/login").
                then().
                assertThat().body(matchesJsonSchemaInClasspath("loginschema.json")).
                statusCode(200).log().all();
                //schema is in target/classes
    }
}

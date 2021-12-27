package first;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matcher.*;

public class SecondTest {
    @Test
    public void getFunc(){
        baseURI="https://reqres.in/api";
        given().get("/users?page=2").then().statusCode(200).log().all();
    }

    @Test
    public void postfunc(){
        baseURI="https://qa1.ushur.in";
        Map request=new HashMap();
        request.put("email","__chandan.jaishankar@ushur.com");
        request.put("password","Chandan@3334");
        JSONObject json=new JSONObject(request);
        System.out.println(json);
        given().contentType("application/json").
                body(json.toJSONString()).
                when().
                post("/rest/login").
                then().
                statusCode(200).log().all();
        /*given().contentType("application/json").
                body("{\"email\":\"__chandan.jaishankar@ushur.com\",\"password\":\"Chandan@3334\"}").
                when().
                post("/rest/login").then().statusCode(200).log().all();*/

    }

}

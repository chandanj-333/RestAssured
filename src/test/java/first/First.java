package first;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.matcher.ResponseAwareMatcher.*;
import static org.hamcrest.Matcher.*;
//given ..get.....when..method(post/patch/put/delete)........then..statusCode
public class First {
    @Test
    public void test0(){
        Response res=RestAssured.get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(res.getStatusCode(),200);
        System.out.println("Test Steps");
    }

    @Test
    public void test1(){
        RestAssured.baseURI="https://reqres.in/api";
        RestAssured.given().get("/users?page=2").then().statusCode(200);
    }
}

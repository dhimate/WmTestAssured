import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.basic;
import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;

public class HelloWorldTest {
    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost:5555/invoke/";
        RestAssured.port = 5555;
        RestAssured.authentication = basic("Administrator", "manage");
    }

    @Test
    public void HellowWorldTestSuccess(){

        Response response = given().
                header("Content-Type","application/json").
                get("Yogesh.flow/addNumbers");

        response.getBody().prettyPrint();

        assertThat(response.getStatusCode(),lessThan(300));
    }

    @Test
    public void HellowWorldTestFailure(){

        assertThat("Failed test", false);

    }
}

package com.dhimate.WmTestAssured;

import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class HelloWorldTest extends WmTestAssuredBase {

    @Test
    public void HellowWorldTestSuccess(){

        Response response = given().
                header("Content-Type","application/json").
                get("Yogesh.flow/addNumbers");

        response.getBody().prettyPrint();

        assertThat(response.getStatusCode(), equalTo(200));
        HashMap body = response.jsonPath().get("");

        assertThat("Check one", body.get("one"), equalTo("number #1"));
        assertThat("Check two", body.get("two"), equalTo("number #2"));


    }

    @Test
    public void HellowWorldTestFailure(){

        assertThat("Failed test", true);

    }
}

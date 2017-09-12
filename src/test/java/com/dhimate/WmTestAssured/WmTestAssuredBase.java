package com.dhimate.WmTestAssured;

import io.restassured.RestAssured;
import org.junit.Before;

import java.io.FileInputStream;
import java.util.Properties;

import static io.restassured.RestAssured.basic;

public class WmTestAssuredBase {


    @Before
    public void setUp() throws Exception {
        Properties properties = getProperties("config.properties");
        RestAssured.baseURI = properties.getProperty("server.baseuri");
//        RestAssured.port = Integer.parseInt(properties.getProperty("server.port"));
        RestAssured.authentication = basic(properties.getProperty("server.user"), properties.getProperty("server.password"));

    }


    private Properties getProperties(String fileName) {

        ClassLoader classLoader = getClass().getClassLoader();
        Properties properties = new Properties();

        try {
            FileInputStream in = new FileInputStream(classLoader.getResource(fileName).getFile());
            properties.load(in);
            in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }
}

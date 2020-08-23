package com.api.test;

import com.api.methods.GetWeatherDetails;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.LoadProperties;
import utils.Weather;

import java.io.IOException;
import java.util.Properties;

public class APITest {

    RestAssured restAssured;
    Properties properties;
    String city;
    String apiKey;

    @BeforeTest
    public void setup() throws IOException {

        properties = new LoadProperties().readPropertiesFile("src//test//resources//config.properties");
        restAssured = new RestAssured();
        restAssured.baseURI = properties.getProperty("baseUri");
        city = properties.getProperty("city");
        apiKey = properties.getProperty("apiKey");
    }

    /**
     * This test method sends a get request to openweatherapi and stores weather object in ITestContext
     *
     * @param context ITestContext for storing weather object
     */
    @Test(priority = 1, groups = "requiredTests")
    public void getWeatherInfoAPI(ITestContext context) {

        Reporter.log("Getting Weather Information from OpenMapAPI for "+city);
        GetWeatherDetails weatherDetails = new GetWeatherDetails();
        Response response = weatherDetails.getWeatherFromCity(restAssured, city, apiKey);
        Weather weather = weatherDetails.getWeatherObject(response);
        context.setAttribute("WeatherObjectAPI", weather);

        Assert.assertEquals(response.getBody().jsonPath().get("name").toString(), city);
    }
}

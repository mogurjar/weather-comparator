package com.api.test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.Weather;

import static io.restassured.RestAssured.given;

public class APITest {

    @BeforeTest
    public void setup() {

        RestAssured.baseURI = "http://api.openweathermap.org/data/2.5";
    }

    @Test(priority = 1, groups = "requiredTests")
    public void getWeatherDetails(ITestContext context) {

        Response response = given()
                .contentType("application/json")
                .queryParam("q","Pune")
                .queryParam("appid","7fe67bf08c80ded756e598d6f8fedaea")
                .when()
                .get("/weather")
                .then()
                .extract().response();
        JsonPath jsonResponse = response.getBody().jsonPath();

        Weather weather = new Weather();
        weather.setTemperatureFromKelvinToDegree(jsonResponse.getString("main.temp"));
        weather.setCondition(jsonResponse.getString("weather[0].description"));
        weather.setHumidity(jsonResponse.getString("main.humidity"));
        String tempFarhenit = ((Double.parseDouble(weather.getTemperatureDegree())*9/5)+32)+"";
        weather.setTemperatureFahrenheit(tempFarhenit);
        weather.setWind(jsonResponse.getString("wind.speed"));
        context.setAttribute("WeatherObjectAPI", weather);

        Assert.assertEquals(jsonResponse.get("name").toString(), "Pune");


    }

}

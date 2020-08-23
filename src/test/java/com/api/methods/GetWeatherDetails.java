package com.api.methods;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import utils.Weather;

/**
 * Get the weather details from OpenWeatherMap API
 */
public class GetWeatherDetails {

    /**
     * This method sends a get request to fetch weather details of a given city
     *
     * @param restAssured Rest Assured Response
     * @param city        City name for which weather details needs to be fetched
     * @param apiKey      API Key to access the weather API
     * @return Response object containing weather details
     */
    public Response getWeatherFromCity(RestAssured restAssured, String city, String apiKey) {

        Response response = restAssured.given()
                .contentType("application/json")
                .queryParam("q", city)
                .queryParam("appid", apiKey)
                .when()
                .get("/weather")
                .then()
                .extract().response();

        return response;
    }

    /**
     * This method fetches required information from API Response and stores it in Weather Object
     *
     * @param response Rest Assured Response object
     * @return Weather object containing details from API Response
     */
    public Weather getWeatherObject(Response response) {

        JsonPath jsonResponse = response.getBody().jsonPath();
        Weather weather = new Weather();
        weather.setTemperatureFromKelvinToDegree(jsonResponse.getString("main.temp"));
        weather.setCondition(jsonResponse.getString("weather[0].description"));
        weather.setHumidity(jsonResponse.getString("main.humidity"));
        String tempFahrenheit = ((Double.parseDouble(weather.getTemperatureDegree()) * 9 / 5) + 32) + "";
        weather.setTemperatureFahrenheit(tempFahrenheit);
        weather.setWind(jsonResponse.getString("wind.speed"));

        return weather;
    }
}

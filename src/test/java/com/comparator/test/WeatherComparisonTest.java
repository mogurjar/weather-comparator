package com.comparator.test;

import com.comparator.variance.Comparator;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.Test;
import utils.Weather;

public class WeatherComparisonTest {

    /**
     * This Test Compares Temperature from weather objects of Front End and API
     *
     * @param context ITestContext for getting weather object
     * @throws Exception
     */
    @Test(dependsOnGroups = "requiredTests")
    public void compareTemperatures(ITestContext context) throws Exception {

        Weather frontendWeather = (Weather) context.getAttribute("WeatherObjectFrontEnd");
        Weather apiWeather = (Weather) context.getAttribute("WeatherObjectAPI");

        Reporter.log("Temperature in Degree from Front End: "+frontendWeather.getTemperatureDegree());
        Reporter.log("Temperature in Degree from API Endpoint: "+apiWeather.getTemperatureDegree());

        double frontendTemp = Double.parseDouble(frontendWeather.getTemperatureDegree());
        double apiTemp = Double.parseDouble(apiWeather.getTemperatureDegree());

        Assert.assertTrue(new Comparator().compareTemperatures(frontendTemp, apiTemp),
                "Temperature from Front End and API do not match");

    }

}

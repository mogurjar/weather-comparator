package com.comparator;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import utils.Weather;

public class WeatherComparisonTest {

        @Test(dependsOnGroups = "requiredTests")
        public void compareTemperatures(ITestContext context){

            Weather frontendWeather = (Weather) context.getAttribute("WeatherObjectFrontEnd");
            Weather apiWeather = (Weather) context.getAttribute("WeatherObjectAPI");

            double frontendTemp = Double.parseDouble(frontendWeather.getTemperatureDegree());
            double apiTemp = Double.parseDouble(apiWeather.getTemperatureDegree());

            Assert.assertTrue(Comparator.compareTemperatures(frontendTemp, apiTemp),"Temperature from Front End and API is same");

        }

}

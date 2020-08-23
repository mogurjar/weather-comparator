package com.comparator.variance;

import utils.LoadProperties;

import java.util.Properties;

/**
 * This class provides methods to compare objects
 */
public class Comparator {

    /**
     * This method compares temperatures with respect to variance provided in config.properties file
     *
     * @param temp1 weather temperature 1
     * @param temp2 weather temperature 2
     * @return boolean value based on comparision result for temperatures
     * @throws Exception
     */
    public boolean compareTemperatures(Double temp1, Double temp2) throws Exception {

        boolean tempMatches = false;
        double tempDiff = temp1 - temp2;

        LoadProperties loadProperties = new LoadProperties();
        Properties properties = loadProperties.readPropertiesFile("src//test//resources//config.properties");
        double temperatureVariance = Double.parseDouble(properties.getProperty("temperatureVariance"));
        if (Math.abs(tempDiff) >= 0 && Math.abs(tempDiff) <= temperatureVariance) {
            tempMatches = true;
        } else {
            throw new Exception("Values do not match in variance of " + temperatureVariance);
        }

        return tempMatches;
    }

}

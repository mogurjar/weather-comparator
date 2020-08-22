package com.test.model;

public class Weather {

    private String condition;
    private String wind;
    private String humidity;
    private String tempratureDegree;
    private String temperatureFahrenheit;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTempratureDegree() {
        return tempratureDegree;
    }

    public void setTempratureDegree(String tempratureDegree) {
        this.tempratureDegree = tempratureDegree;
    }

    public String getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }

    public void setTemperatureFahrenheit(String temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }
}

package utils;

public class Weather {

    private String condition;
    private String wind;
    private String humidity;
    private String temperatureDegree;
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

    public String getTemperatureDegree() {
        return temperatureDegree;
    }

    public void setTemperatureDegree(String temperatureDegree) {
        this.temperatureDegree = temperatureDegree;
    }

    public String getTemperatureFahrenheit() {
        return temperatureFahrenheit;
    }

    public void setTemperatureFahrenheit(String temperatureFahrenheit) {
        this.temperatureFahrenheit = temperatureFahrenheit;
    }

    public void setTemperatureFromKelvinToDegree(String temperatureKelvin) {
        double temp = Double.parseDouble(temperatureKelvin) - 273.15;
        this.temperatureDegree = temp+"";
    }

}

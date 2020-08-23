package com.frontend.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LoadProperties;
import utils.Weather;

import java.io.IOException;
import java.util.Properties;

/**
 * NDTV Weather Page Class with required Locators
 */
public class NDTVWeatherPage {

    WebDriverWait wait;
    WebDriver driver;
    Properties properties;
    String city;

    public String getCity() {
        return city;
    }

    @FindBy(id = "searchBox")
    WebElement searchInputBox;

    @FindBy(xpath = "//b[contains(text(),'Condition')]")
    WebElement weatherCondition;

    @FindBy(xpath = "//b[contains(text(),'Wind')]")
    WebElement weatherWind;

    @FindBy(xpath = "//b[contains(text(),'Humidity')]")
    WebElement weatherHumidity;

    @FindBy(xpath = "//b[contains(text(),'Temp in Degrees')]")
    WebElement tempDegrees;

    @FindBy(xpath = "//b[contains(text(),'Temp in Fahrenheit')]")
    WebElement tempFahrenheit;

    public NDTVWeatherPage(WebDriver driver) throws IOException {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        properties = new LoadProperties().readPropertiesFile("src//test//resources//config.properties");
        city = properties.getProperty("city");
        PageFactory.initElements(driver, this);
    }

    /**
     * Wait for Loading element to get visible and searches for given city
     */
    public void searchCity() throws IOException {

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));
        searchInputBox.sendKeys(city);
        WebElement cityCheckLabel = driver.findElement(By.xpath("//label[@for='"+city+"']"));
        wait.until(ExpectedConditions.visibilityOf(cityCheckLabel));
        cityCheckLabel.click();
    }

    /**
     * Get Weather details from front end and stores in weather object
     *
     * @return Weather object with information fetched from Front end
     */
    public Weather getWeatherDetails() {

        WebElement cityDivMap = driver.findElement(By.xpath("//div[@title='"+city+"']"));
        wait.until(ExpectedConditions.visibilityOf(cityDivMap));
        cityDivMap.click();
        Weather weather = new Weather();
        weather.setCondition(weatherCondition.getText().split(": ")[1]);
        weather.setHumidity(weatherHumidity.getText().split(": ")[1].replace("%", ""));
        weather.setWind(weatherWind.getText().split(": ")[1]);
        weather.setTemperatureDegree(tempDegrees.getText().split(": ")[1]);
        weather.setTemperatureFahrenheit(tempFahrenheit.getText().split(": ")[1]);

        return weather;
    }

}

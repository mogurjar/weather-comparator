package com.frontend.pages;

import com.test.model.Weather;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NDTVWeatherPage {

    WebDriverWait wait;
    WebDriver driver;

    @FindBy(id = "searchBox")
    WebElement searchInputBox;

    @FindBy(xpath = "//label[@for='Pune']")
    WebElement puneCheckLabel;

    @FindBy(xpath = "//div[@title='Pune']")
    WebElement puneDivMap;

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

    public NDTVWeatherPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void searchCity(){

        searchInputBox.sendKeys("Pune");
        searchInputBox.click();
//        wait.until(ExpectedConditions.visibilityOf(puneCheckLabel));
        puneCheckLabel.click();

    }

    public Weather getWeatherDetails(){

        puneDivMap.click();
        Weather weather = new Weather();
        weather.setCondition(weatherCondition.getText().split(": ")[1]);
        weather.setHumidity(weatherHumidity.getText().split(": ")[1].replace("%",""));
        weather.setWind(weatherWind.getText().split(": ")[1]);
        weather.setTempratureDegree(tempDegrees.getText().split(": ")[1]);
        weather.setTemperatureFahrenheit(tempFahrenheit.getText().split(": ")[1]);

        return weather;


    }

}

package com.frontend.test;

import com.frontend.pages.NDTVHomePage;
import com.frontend.pages.NDTVWeatherPage;
import org.testng.annotations.AfterMethod;
import utils.Weather;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestFrontEnd {

    WebDriver driver;
    NDTVHomePage homePage;
    NDTVWeatherPage weatherPage;

    @BeforeTest
    public void setup() throws IOException {
        System.setProperty("webdriver.chrome.driver", "BrowserDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ndtv.com/");
        homePage = new NDTVHomePage(driver);
        weatherPage = new NDTVWeatherPage(driver);
    }

    /**
     * This test gets Weather details from Front End and Stores them to ITestContext
     *
     * @param context ITestContext to set Weather Object
     */
    @Test(priority = 1, groups = "requiredTests")
    public void getWeatherInfoUI(ITestContext context) throws IOException {
        homePage.navigateToWeatherPage();
        weatherPage.searchCity();
        Weather weather = weatherPage.getWeatherDetails();
        context.setAttribute("WeatherObjectFrontEnd", weather);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }

}

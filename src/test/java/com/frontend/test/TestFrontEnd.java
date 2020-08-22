package com.frontend.test;

import com.frontend.pages.NDTVHomePage;
import com.frontend.pages.NDTVWeatherPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestFrontEnd {

    WebDriver driver;
    NDTVHomePage homePage;
    NDTVWeatherPage weatherPage;

    @BeforeTest
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "BrowserDriver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.ndtv.com/");
        homePage = new NDTVHomePage(driver);
        weatherPage = new NDTVWeatherPage(driver);



    }
    @Test(priority = 1)
    public void testProductAddition() {
        homePage.navigateToWeatherPage();
        weatherPage.searchCity();
        weatherPage.getWeatherDetails();

    }

}

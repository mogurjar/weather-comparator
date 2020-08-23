package com.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Home Page of NDTV website with required Locators
 */
public class NDTVHomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//a[@class='notnow']")
    WebElement closeNotificationAlert;

    @FindBy(xpath = "//a[@class='topnavmore']")
    WebElement moreNavigationOption;

    @FindBy(xpath = "//a[contains(text(),'WEATHER')]")
    WebElement weatherLink;

    public NDTVHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    /**
     * Waits for Notification popup, closes ita and lciks on weather tab to navigate to Weather Page
     */
    public void navigateToWeatherPage() {

        wait.until(ExpectedConditions.visibilityOf(closeNotificationAlert));
        closeNotificationAlert.click();
        moreNavigationOption.click();
        weatherLink.click();
    }

}

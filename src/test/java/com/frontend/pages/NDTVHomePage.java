package com.frontend.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NDTVHomePage {

    WebDriver driver;

    @FindBy(xpath = "//a[@class='topnavmore']")
    WebElement moreNavigationOption;

    @FindBy(xpath = "//a[contains(text(),'WEATHER')]")
    WebElement weatherLink;

    public NDTVHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void navigateToWeatherPage(){

        moreNavigationOption.click();
        weatherLink.click();
    }


}

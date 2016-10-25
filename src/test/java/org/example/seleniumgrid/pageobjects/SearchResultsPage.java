package org.example.seleniumgrid.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

}

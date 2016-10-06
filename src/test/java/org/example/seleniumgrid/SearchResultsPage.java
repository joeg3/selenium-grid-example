package org.example.seleniumgrid;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        this.driver = driver;
    }

    public String getTitle() {
        return this.driver.getTitle();
    }

}

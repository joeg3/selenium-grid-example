package org.example.seleniumgrid.pageobjects;

import org.openqa.selenium.WebDriver;

public class SearchResultsPage extends BasePage {

    WebDriver driver;

    public SearchResultsPage(WebDriver driver){
        super(driver);
    }

    public String getTitle() {
        return super.getDriver().getTitle();
    }

}

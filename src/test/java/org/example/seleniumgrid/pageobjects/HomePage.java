package org.example.seleniumgrid.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private String pagePath = "";

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchText;
    
    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    public HomePage(WebDriver driver, String baseUrl) {
        super(driver);
        super.setUrl(baseUrl + pagePath);
    }

    public SearchResultsPage search(String searchString) throws Exception {
        setSearchText(searchString);
        clickSearchButton();
        return new SearchResultsPage(super.getDriver());
    }

    public void setSearchText(String searchText) {
        this.searchText.sendKeys(searchText);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

}
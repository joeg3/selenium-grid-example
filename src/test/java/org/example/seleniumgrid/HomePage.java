package org.example.seleniumgrid;

import static org.testng.AssertJUnit.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

public class HomePage extends LoadableComponent<HomePage> {

    private WebDriver driver;
    private String url = "https://www.duckduckgo.com";
    private String title = "DuckDuckGo";

    @FindBy(id = "search_form_input_homepage")
    private WebElement searchText;
    
    @FindBy(id = "search_button_homepage")
    private WebElement searchButton;

    public HomePage(WebDriver driver) {
        System.out.println("here1");
        this.driver = driver;
        PageFactory.initElements(driver, this);
        System.out.println("here2");
    }
    
    @Override
    protected void load() {
        System.out.println("here!!!!!");
        this.driver.get(url);
    }
    
    @Override
    protected void isLoaded() throws Error {
        if (!driver.getTitle().equals(title)) {
            throw new Error("Duck Duck Go page not loaded");
        }
    }

    public String getTitle(){
       return driver.getTitle();
    }

    public SearchResultsPage search(String searchString) throws Exception {
        setSearchText(searchString);
        clickSearchButton();
        return new SearchResultsPage(driver);
    }

    public void setSearchText(String searchText) {
        this.searchText.sendKeys(searchText);
    }

    public void clickSearchButton() {
        this.searchButton.click();
    }

}
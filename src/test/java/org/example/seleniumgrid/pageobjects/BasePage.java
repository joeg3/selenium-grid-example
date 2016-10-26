package org.example.seleniumgrid.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    
    private WebDriver driver;
    private String url;
    
    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void load() {
        driver.get(url);
    }
    
    protected WebDriver getDriver() {
        return this.driver;
    }
    
    public String getTitle(){
        return driver.getTitle();
     }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}

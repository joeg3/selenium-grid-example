package org.example.seleniumgrid;

import static org.junit.Assert.assertEquals;

import org.example.seleniumgrid.pageobjects.HomePage;
import org.example.seleniumgrid.pageobjects.SearchResultsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
  
public class SearchTest {
    
    WebDriver driver;
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    
    @Before
    public void setup() {
        driver = new FirefoxDriver();
        homepage = new HomePage(driver, "https://www.duckduckgo.com");
        //homepage.get();
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testSearch() throws Exception {
        //homepage.isLoaded(); // Throws error if not loaded
        assertEquals("DuckDuckGo", homepage.getTitle());
        searchResultsPage = homepage.search("packers");
        assertEquals("packers at DuckDuckGo", searchResultsPage.getTitle());
  }
}
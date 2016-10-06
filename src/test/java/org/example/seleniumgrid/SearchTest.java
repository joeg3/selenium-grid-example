package org.example.seleniumgrid;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
  
public class SearchTest {
    
    WebDriver driver;
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    
    @Before
    public void setup() {
        driver = new ChromeDriver();
        homepage = new HomePage(driver);
        homepage.get();
    }
    
    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testSearch() throws Exception {
        assertEquals("DuckDuckGo", homepage.getTitle());
        searchResultsPage = homepage.search("packers");
        assertEquals("packers at DuckDuckGo", searchResultsPage.getTitle());
  }
}
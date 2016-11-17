package org.example.seleniumgrid;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.example.seleniumgrid.pageobjects.HomePage;
import org.example.seleniumgrid.pageobjects.SearchResultsPage;
import org.testng.annotations.Test;
  
public class SearchUsingGridTest extends GridBase {
    
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    
    @Test(description = "Test DuckDuckGo Search")
    public void testSearch() throws Exception {
        homepage = new HomePage(getDriver(), getBaseUrl());
        homepage.load();
        assertEquals("DuckDuckGo", homepage.getTitle());
        
        //TimeUnit.SECONDS.sleep(10); // Demonstrate browser tests running in parallel
        
        searchResultsPage = homepage.search("green bay packers");
        assertEquals("green bay packers at DuckDuckGo", searchResultsPage.getTitle());
  }
}
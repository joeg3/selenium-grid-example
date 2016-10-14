package org.example.seleniumgrid;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
  
public class SearchUsingGridTest extends GridBase {
    
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    
    @Test(description = "Test DuckDuckGo Search")
    public void testSearch() throws Exception {
        homepage = new HomePage(getDriver(), getBaseUrl());
        //homepage.get();
        TimeUnit.SECONDS.sleep(10);
        //homepage.isLoaded(); // Throws error if not loaded
        assertEquals("DuckDuckGo", homepage.getTitle());
        searchResultsPage = homepage.search("packers");
        //TimeUnit.SECONDS.sleep(5);
        assertEquals("packers at DuckDuckGo", searchResultsPage.getTitle());
  }
}
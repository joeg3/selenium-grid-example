package org.example.seleniumgrid;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.example.seleniumgrid.pageobjects.HomePage;
import org.example.seleniumgrid.pageobjects.SearchResultsPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
  
public class SearchUsingGridTest extends GridBase {
    
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    
    @Parameters({ "hubIpAddress", "baseUrl" })
    public SearchUsingGridTest(String hubIpAddress, String baseUrl) {
        super(hubIpAddress, baseUrl);
    }
    
    @Test(description = "Test DuckDuckGo Search")
    public void testSearch() throws Exception {
        homepage = new HomePage(getDriver(), getBaseUrl());
        homepage.load();
        assertEquals("DuckDuckGo", homepage.getTitle());
        
        TimeUnit.SECONDS.sleep(5); // Demonstrate browser tests running in parallel
        
        searchResultsPage = homepage.search("green bay packers");
        TimeUnit.SECONDS.sleep(5); // Demonstrate browser tests running in parallel
        assertEquals("green bay packers at DuckDuckGo", searchResultsPage.getTitle());
  }
}
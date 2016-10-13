package org.example.seleniumgrid;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
  
public class SearchUsingGridTest {
    
    WebDriver driver = null;
    HomePage homepage;
    SearchResultsPage searchResultsPage;
    
    @Parameters({ "platform", "browser", "version", "url" })
    @BeforeTest(alwaysRun = true)
    public void setup(String platform, String browser, String version, String url) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Browsers
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setBrowserName("internet explorer");
            capabilities.setVersion(version);
        }

        if (browser.equalsIgnoreCase("Firefox")) {
            capabilities = DesiredCapabilities.firefox();
            capabilities.setBrowserName("firefox");
            capabilities.setVersion(version);
        }

        if (browser.equalsIgnoreCase("Chrome")) {
            capabilities = DesiredCapabilities.chrome();
            capabilities.setBrowserName("chrome");
            capabilities.setVersion(version);
        }

        if (browser.equalsIgnoreCase("Safari")) {
            capabilities = DesiredCapabilities.safari();
            capabilities.setBrowserName("safari");
            capabilities.setVersion(version);
        }
        
        // Platforms
        if (platform.equalsIgnoreCase("Windows")) {
            capabilities.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        }

        if (platform.equalsIgnoreCase("MAC")) {
            capabilities.setPlatform(org.openqa.selenium.Platform.MAC);
        }
        
        if (platform.equalsIgnoreCase("LINUX")) {
            capabilities.setPlatform(org.openqa.selenium.Platform.LINUX);
        }

        capabilities.setVersion(version);
        
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), capabilities);

        // Open browser to URL
        homepage = new HomePage(driver);
        homepage.get();
    }
    
    @AfterTest
    public void afterTest() {
        driver.close();
        driver.quit();
    }
    
    @Test(description = "Test DuckDuckGo Search")
    public void testSearch() throws Exception {
        //TimeUnit.SECONDS.sleep(5);
        //homepage.isLoaded(); // Throws error if not loaded
        //assertEquals("DuckDuckGo", homepage.getTitle());
        searchResultsPage = homepage.search("packers");
        //TimeUnit.SECONDS.sleep(5);
        assertEquals("packers at DuckDuckGo", searchResultsPage.getTitle());
  }
}
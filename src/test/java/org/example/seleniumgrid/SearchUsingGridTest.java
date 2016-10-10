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
        DesiredCapabilities caps = new DesiredCapabilities();
    
        System.out.printf("Search using platform: '%s', browser: '%s', version: '%s'", platform, browser, version);
        
        // Browsers
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            caps = DesiredCapabilities.internetExplorer();
            caps.setBrowserName("internet explorer");
        }

        if (browser.equalsIgnoreCase("Firefox")) {
            caps = DesiredCapabilities.firefox();
            caps.setBrowserName("firefox");
        }

        if (browser.equalsIgnoreCase("Chrome")) {
            caps = DesiredCapabilities.chrome();
            caps.setBrowserName("chrome");
        }

        if (browser.equalsIgnoreCase("Safari")) {
            caps = DesiredCapabilities.safari();
            caps.setBrowserName("safari");
        }
        
        // Platforms
        if (platform.equalsIgnoreCase("Windows")) {
            caps.setPlatform(org.openqa.selenium.Platform.WINDOWS);
        }

        if (platform.equalsIgnoreCase("MAC")) {
            caps.setPlatform(org.openqa.selenium.Platform.MAC);
        }
        
        if (platform.equalsIgnoreCase("LINUX")) {
            caps.setPlatform(org.openqa.selenium.Platform.LINUX);
        }

        // Version
        caps.setVersion(version);
        
        driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

        // Open browser to URL
        homepage = new HomePage(driver);
        homepage.get();
        //driver.get(url);
        
    }
    
    @AfterTest
    public void afterTest() {
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
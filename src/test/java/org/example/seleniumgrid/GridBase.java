package org.example.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridBase {
    
    public static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<RemoteWebDriver>();
    private String baseUrl = "https://www.duckduckgo.com";
    
    @Parameters({ "platform", "browser", "version", "url" })
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String platform, String browser, String version, String url) throws MalformedURLException {
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
        
        setDriver(new RemoteWebDriver(new URL("http://192.168.33.10:4444/wd/hub"), capabilities));
    }
    
    @AfterClass
    public void afterTest(){
        getDriver().close();
        getDriver().quit();
    }
    
    public RemoteWebDriver getDriver() {
        return threadLocalDriver.get();
    }
 
    public void setDriver(RemoteWebDriver driver) {
        threadLocalDriver.set(driver);
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }
    
    

}

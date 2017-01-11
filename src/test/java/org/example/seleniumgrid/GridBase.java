package org.example.seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class GridBase {
    
    public static ThreadLocal<RemoteWebDriver> threadLocalDriver = new ThreadLocal<RemoteWebDriver>();
    private String baseUrl;
    private String hubIpAddress;
    
    @Parameters({ "hubIpAddress", "baseUrl" })
    public GridBase(String hubIpAddress, String baseUrl) {
        this.hubIpAddress = hubIpAddress;
        this.baseUrl = baseUrl;
    }
    
    @Parameters({ "platform", "browser", "version" })
    @BeforeClass(alwaysRun = true)
    public void beforeClass(String platform, String browser, String version) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        
        // Browsers
        if (browser.equalsIgnoreCase("Internet Explorer")) {
            capabilities = DesiredCapabilities.internetExplorer();
        }
        if (browser.equalsIgnoreCase("Firefox")) {
            capabilities = DesiredCapabilities.firefox();
        }
        if (browser.equalsIgnoreCase("Chrome")) {
            capabilities = DesiredCapabilities.chrome();
        }
        if (browser.equalsIgnoreCase("Safari")) {
            capabilities = DesiredCapabilities.safari();
        }
        
        // Platforms
        if (platform.equalsIgnoreCase("WINDOWS")) {
            capabilities.setPlatform(Platform.WINDOWS);
        }
        if (platform.equalsIgnoreCase("MAC")) {
            capabilities.setPlatform(Platform.MAC);
        }
        if (platform.equalsIgnoreCase("LINUX")) {
            capabilities.setPlatform(Platform.LINUX);
        }

        capabilities.setVersion(version);
        
        setDriver(new RemoteWebDriver(new URL("http://" + hubIpAddress + ":4444/wd/hub"), capabilities));
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

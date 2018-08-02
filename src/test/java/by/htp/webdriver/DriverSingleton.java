package by.htp.webdriver;

import static by.htp.utils.PropertyManager.getProperty;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import by.htp.utils.Log;

public class DriverSingleton {
	private static WebDriver driver;
	private static final String BROWSER = getProperty("browser");
    private static final String CHROME = getProperty("webdriver.chrome");
    private static final String CHROME_EXE = getProperty("driver.exe.path.chrome");
    private static final String FIREFOX = getProperty("webdriver.firefox");
    private static final String FIREFOX_EXE = getProperty("driver.exe.path.firefox");
    
    private DriverSingleton(){};


    public static WebDriver getDriver() {
        if (null == driver) {
        	switch(BROWSER){
        		case "chrome":
        			System.setProperty(CHROME, CHROME_EXE);
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments(Arrays.asList("--incognito", "--start-maximized","--lang=ru"));
                    driver = new ChromeDriver(chromeOptions);
                    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    Log.getLogInfo("Chrome browser started");
                    break;
        		case "firefox":
        			System.setProperty(FIREFOX, FIREFOX_EXE);
        	        FirefoxOptions firefoxOptions = new FirefoxOptions();
        	        firefoxOptions.addArguments("-private-window");
        	        driver = new FirefoxDriver(firefoxOptions);
                    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    Log.getLogInfo("Firefox browser started");
        	        break;
        		default :
        			Log.getLogFatal("Can't find browser");
        	}
        }
        return driver;
    }

    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

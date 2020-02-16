package scriptFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static pageObjects.testsShared.WEBDRIVER;
import static pageObjects.testsShared.WEBDRIVER_LOCATION;

public class ChromeScript {

    private static WebDriver driver;

    // Using options I always used in the past, it's a mix of different tweaks I need for different websites. It doesn't make much sense here except for maximizing, which I do a bit differently in FF and for IE which starts maximized
    public static WebDriver setUp(String domain) {
        System.setProperty(WEBDRIVER, WEBDRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--no-sandbox");
        options.addArguments("enable-strict-powerful-feature-restrictions");
        options.addArguments("disable-geolocation");
        driver = new ChromeDriver(options);
        driver.get(domain);
        return driver;
    }

    // Close and Quit because sometimes my test machine was being flooded with leftover driver executables
    public static WebDriver closeUp(WebDriver driver) {
        driver.close();
        driver.quit();
        return driver;
    }
}


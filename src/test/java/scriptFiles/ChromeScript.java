package scriptFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static pageObjects.testsShared.WEBDRIVER;
import static pageObjects.testsShared.WEBDRIVER_LOCATION;

public class ChromeScript {

    private static WebDriver driver;

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
        System.out.println("*** Script start ***");
        return driver;
    }

    public static WebDriver closeUp(WebDriver driver) {
        System.out.println("*** Script end ***");
        driver.close();
        driver.quit();
        return driver;
    }
}


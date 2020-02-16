package scriptFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static pageObjects.testsShared.WEBDRIVER_FF;
import static pageObjects.testsShared.WEBDRIVER_FF_LOCATION;

public class FirefoxScript {

    protected static FirefoxDriver driver;

    public static WebDriver setUp(String domain) {
        System.setProperty(WEBDRIVER_FF, WEBDRIVER_FF_LOCATION);
        FirefoxProfile myProfile = new FirefoxProfile();
        myProfile.setPreference("geo.enabled", false);
        myProfile.setPreference("geo.provider.use_corelocation", false);
        myProfile.setPreference("geo.prompt.testing", false);
        myProfile.setPreference("geo.prompt.testing.allow", false);
        FirefoxOptions options = new FirefoxOptions();
        options.setProfile(myProfile);
        driver = new FirefoxDriver(options);
        driver.get(domain);
        driver.manage().window().maximize();
        return driver;
    }

    public static void closeUp(WebDriver driver) {
        driver.quit();
    }
}


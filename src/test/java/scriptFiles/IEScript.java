package scriptFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static pageObjects.testsShared.WEBDRIVER_IE;
import static pageObjects.testsShared.WEBDRIVER_IE_LOCATION;

public class IEScript {

    private static WebDriver driver;

    public static WebDriver setUp(String domain) {
        System.setProperty(WEBDRIVER_IE, WEBDRIVER_IE_LOCATION);
        try {
            driver = new InternetExplorerDriver();
        } catch (Exception e) {
            System.out.println(e);
        }
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


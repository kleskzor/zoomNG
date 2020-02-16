package pageObjects;

public class testsShared {

    /* Just a "config" file for Strings used very frequently, it made more sense when I was loading different plugins and I needed one place for quick changes,
    for example:

    private static String build = "19.4.416";
    public static String LATEST_OPERA = "./common/browser_extensions/OPERA/opera-aos-" + build + ".crx";
    public static String LATEST_CHROME = "./common/browser_extensions/CHROME/chrome-aos-" + build + ".crx";

     */
    /// CHROME
    public static String WEBDRIVER = "webdriver.chrome.driver";
    public static String WEBDRIVER_LOCATION = "src/test/java/drivers/chromedriver.exe";

    /// Firefox
    public static String WEBDRIVER_FF = "webdriver.gecko.driver";
    public static String WEBDRIVER_FF_LOCATION = "src/test/java/drivers/geckodriver.exe";

    /// Internet Explorer
    public static String WEBDRIVER_IE = "webdriver.ie.driver";
    public static String WEBDRIVER_IE_LOCATION = "src/test/java/drivers/IEDriverServer.exe";


}

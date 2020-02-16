import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.Zoom.FinalPage;
import pageObjects.Zoom.FirstPage;
import pageObjects.Zoom.SecondPage;
import pageObjects.Zoom.ThirdPage;

import java.util.Objects;

import static pageObjects.Zoom.FirstPage.HOMEPAGE;
import static scriptFiles.ChromeScript.closeUp;
import static scriptFiles.ChromeScript.setUp;

public class ZoomChromeTest {

    //-----------------------------------Global Variables-----------------------------------
    //Declare a Webdriver variable
    public WebDriver driver;

    //-----------------------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        // Go to Google document page
        driver = setUp(HOMEPAGE);
    }

    //-----------------------------------Tests-----------------------------------
    @Test
    public void ChromeTest() {

        FirstPage firstPage = new FirstPage(driver);
        firstPage.checkThis();
        firstPage.fillFutureDateChrome(5);

        Assert.assertTrue(firstPage.isMandatory());
        firstPage.fillMonth();

        SecondPage secondPage = firstPage.nextPage();
        secondPage.fillShows();
        secondPage.fillColor();

        firstPage = secondPage.previousPage();
        firstPage.reverseMonth();

        secondPage = firstPage.nextPage();

        Assert.assertTrue(secondPage.checkFilledFirst());

        Assert.assertTrue(secondPage.checkFilledSecond());

        ThirdPage thirdPage = secondPage.nextPage();

        thirdPage.confirm();

        FinalPage finalPage = thirdPage.send();
    }

    //-----------------------------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        closeUp(Objects.requireNonNull(driver));
    }
}


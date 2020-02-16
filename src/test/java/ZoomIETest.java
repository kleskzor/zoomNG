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
import static scriptFiles.IEScript.closeUp;
import static scriptFiles.IEScript.setUp;

public class ZoomIETest {

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

       // Initiating firstPage PO, fulfilling 1) Fill first and second question
        FirstPage firstPage = new FirstPage(driver);
        firstPage.checkThis();
        firstPage.fillFutureDate(5);

        // 2) Validate that third question is mandatory
        Assert.assertTrue(firstPage.isMandatory());

        // 3) Fill third question and go to another step
        firstPage.fillMonth();
        SecondPage secondPage = firstPage.nextPage();

        // 4) Fill next questions
        secondPage.fillShows();
        secondPage.fillColor();

        // 5) Go back to first step & 6) Reverse text in third question
        firstPage = secondPage.previousPage();
        firstPage.reverseMonth();

        // 7) Go to second step
        secondPage = firstPage.nextPage();

        // 8) Check that both questions are still filed
        Assert.assertTrue(secondPage.checkFilledFirst());
        Assert.assertTrue(secondPage.checkFilledSecond());

        // 9) Go to last step
        ThirdPage thirdPage = secondPage.nextPage();

        //10) Fill last question and send form
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


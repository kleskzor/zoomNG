package pageObjects.Zoom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObject;

public class FinalPage extends PageObject {

    @FindBy(xpath = "//div[text()='Thank you for your response.']")
    private WebElement confirmationTest;

    public FinalPage(WebDriver driver) {
        super(driver);
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(confirmationTest));
    }
}
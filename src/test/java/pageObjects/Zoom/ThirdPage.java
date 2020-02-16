package pageObjects.Zoom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObject;

public class ThirdPage extends PageObject {

    @FindBy(xpath = "//span[text()='Zpět']")
    private WebElement previousButton;

    @FindBy(xpath = "//span[text()='Odeslat']")
    private WebElement send;

    @FindBy(xpath = "//span[text()='Yes']")
    private WebElement confirm;

    public ThirdPage(WebDriver driver) {
        super(driver);
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(previousButton));
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(send));
    }

    public void confirm() {
        confirm.click();
    }

    public FinalPage send() {
        send.click();
        return new FinalPage(driver);
    }
}
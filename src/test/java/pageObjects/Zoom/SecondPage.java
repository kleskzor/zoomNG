package pageObjects.Zoom;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObject;

import java.util.ArrayList;
import java.util.Collections;

public class SecondPage extends PageObject {

    @FindBy(xpath = "//span[text()='Zpět']")
    private WebElement previousButton;

    @FindBy(xpath = "//span[text()='Další']")
    private WebElement nextButton;

    @FindBy(xpath = "//span[text()='Black']")
    private WebElement favColor;

    @FindBy(xpath = "//div[contains(@class,'isCheckedNext isChecked')]")
    private WebElement favColorFilled;

    @FindBy(xpath = "//div[contains(@class,'exportToggleEl isChecked')]")
    private WebElement favColorFilledChrome;


    @FindBy(xpath = "//textarea[contains(@aria-label,'Create list of your favorite movies')]")
    private WebElement textArea;

    public SecondPage(WebDriver driver) {
        super(driver);
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(previousButton));
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    public void fillShows() {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "X-Files", "Monty Python's Flying Circus", "Star Trek: The Next Generation", "Shining", "Sunshine", "2001 - A Space Odyssey", "American Psycho", "Clockwork Orange", "Full Metal Jacket");
        Collections.shuffle(list);
        textArea.clear();
        for (int i = 0; i < 3; i++) {
            textArea.sendKeys(list.get(i));
            textArea.sendKeys(Keys.ENTER);
        }
        textArea.sendKeys(Keys.BACK_SPACE);
    }

    public void fillColor() {
        favColor.click();
    }

    public boolean checkFilledFirst() {
        return !textArea.getText().isEmpty();
    }

    public boolean checkFilledSecond() {
        return favColorFilledChrome.isEnabled();
    }

//    public boolean checkFilledSecondFF() {
//        return favColorFilled.isEnabled();
//    }

    public FirstPage previousPage() {
        previousButton.click();
        return new FirstPage(driver);
    }

    public ThirdPage nextPage() {
        nextButton.click();
        return new ThirdPage(driver);
    }
}
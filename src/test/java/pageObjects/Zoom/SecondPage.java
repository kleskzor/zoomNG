package pageObjects.Zoom;

import org.openqa.selenium.By;
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

    @FindBy(xpath = "(//span[contains(@class,'appsMaterialWizButtonPaperbuttonContent exportButtonContent')])[1]")
    private WebElement previousButton;

    @FindBy(xpath = "(//span[contains(@class,'appsMaterialWizButtonPaperbuttonContent exportButtonContent')])[2]")
    private WebElement nextButton;

    @FindBy(xpath = "//span[text()='Black']")
    private WebElement favColor;

    @FindBy(xpath = "//div[contains(@class,'isCheckedNext isChecked')]")
    private WebElement favColorFilled;

    // Chrome has again different elements shown
    @FindBy(xpath = "//div[contains(@class,'exportToggleEl isChecked')]")
    private WebElement favColorFilledChrome;

    @FindBy(xpath = "//textarea[contains(@aria-label,'Create list of your favorite movies')]")
    private WebElement favMovieInput;

    public SecondPage(WebDriver driver) {
        super(driver);
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(previousButton));
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    public void fillShows() {
        ArrayList<String> list = new ArrayList<>();
        Collections.addAll(list, "X-Files", "Monty Python's Flying Circus", "Star Trek: The Next Generation", "Shining", "Sunshine", "2001 - A Space Odyssey", "American Psycho", "Clockwork Orange", "Full Metal Jacket");
        Collections.shuffle(list);
        favMovieInput.clear();
        for (int i = 0; i < 3; i++) {
            favMovieInput.sendKeys(list.get(i));
            favMovieInput.sendKeys(Keys.ENTER);
        }
        favMovieInput.sendKeys(Keys.BACK_SPACE);
    }

    public void fillColor(String color) {
        driver.findElement(By.xpath("//span[text()='"+color+"']")).click();
        favColor.click();
    }

    public boolean checkFilledFirst() {
        return !favMovieInput.getText().isEmpty();
    }

    public boolean checkFilledSecond() {
        return favColorFilledChrome.isEnabled();
    }

    public FirstPage previousPage() {
        previousButton.click();
        return new FirstPage(driver);
    }

    public ThirdPage nextPage() {
        nextButton.click();
        return new ThirdPage(driver);
    }
}
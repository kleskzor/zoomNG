package pageObjects.Zoom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.PageObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FirstPage extends PageObject {

    public static String HOMEPAGE = "https://docs.google.com/forms/d/e/1FAIpQLScNx9xK2LM-G3Z3fJXOQapiSK1IAoNXc_67MyS-soTfhDXotA/viewform";

    // In first commit I selected this by text, but it was Další/Předchozí, which could cause problems in different languages, this ugly xpath was the only solution for that
    @FindBy(xpath = "(//span[contains(@class,'appsMaterialWizButtonPaperbuttonContent exportButtonContent')])[1]")
    private WebElement nextButton;

    @FindBy(xpath = "(//span[text()='Check this'])[1]")
    private WebElement checkThis;

    @FindBy(xpath = "(//span[text()='Check this'])[2]")
    private WebElement checkThis2;

    @FindBy(xpath = "//input[@type='date']")
    private WebElement inputDate;

    // Don't like those three next xpaths, but they work
    @FindBy(xpath = "//input[@max='31']")
    private WebElement inputDay;

    @FindBy(xpath = "//input[@max='12']")
    private WebElement inputMonth;

    @FindBy(xpath = "//input[@min='1870']")
    private WebElement inputYear;

    @FindBy(xpath = "//input[contains(@aria-label,'Check that this question')]")
    private WebElement inputCurrentMonth;

    @FindBy(xpath = "//div[@role='listitem'][contains(.,'Check that this question is mandatory')]")
    private WebElement mandatoryBox;

    // I didn't use Selenide or any other "update" of pure Selenium to show how I dealt with waiting for elements etc.
    public FirstPage(WebDriver driver) {
        super(driver);
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(checkThis));
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(checkThis2));
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.elementToBeClickable(nextButton));
    }

    // I've put this outside of the fillMonth() because this could be used also in different places? Or not..
    public String getCurrentMonth() {
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("MMMM").format(cal.getTime());
    }

    public void checkThis() {
        checkThis.click();
        checkThis2.click();
    }

    // For Chrome I can just write the date to the element and it formats automatically. You can add any number of days, it even works for negative for which I chose not to validate inputs. I noticed that if you enter 5+ digits the form throws an error.
    public void fillFutureDateChrome(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        inputDate.sendKeys(new SimpleDateFormat("dd").format(cal.getTime()));
        inputDate.sendKeys(new SimpleDateFormat("MM").format(cal.getTime()));
        inputDate.sendKeys(new SimpleDateFormat("yyyy").format(cal.getTime()));
    }

    // For FF and IE different elements are shown and for whatever reason you cant change the year (using normal means)
    public void fillFutureDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, days);
        inputDay.sendKeys(new SimpleDateFormat("dd").format(cal.getTime()));
        inputMonth.sendKeys(new SimpleDateFormat("MM").format(cal.getTime()));
        // Can't set year in FF and IE
        inputYear.sendKeys(new SimpleDateFormat("yyyy").format(cal.getTime()));
    }

    // If question is mandatory it has a star * in the question box, so I chose it for checking
    public boolean isMandatory() {
        return mandatoryBox.getText().contains("*");
    }

    public void fillMonth() {
        inputCurrentMonth.clear();
        inputCurrentMonth.sendKeys(getCurrentMonth());
    }

    public void reverseMonth() {
        String text = inputCurrentMonth.getAttribute("value");
        inputCurrentMonth.clear();
        inputCurrentMonth.sendKeys(new StringBuffer(text).reverse().toString());
    }

    public SecondPage nextPage() {
        nextButton.click();
        return new SecondPage(driver);
    }
}
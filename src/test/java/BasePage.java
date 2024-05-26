import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * BasePage serves as a foundation for all page classes.
 * It contains common methods and elements used across different pages.
 */
public class BasePage {

    // Locator for the title element in the section
    private final By titleLocator = By.xpath("//section/span");

    protected WebDriver driver;
    protected WebDriverWait wait;

    /**
     * Constructor to initialize the WebDriver and WebDriverWait.
     *
     * @param driver WebDriver instance to interact with the web page.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Waits until the element located by the given locator is visible and then returns it.
     *
     * @param locator By locator to find the element.
     * @return WebElement that is visible.
     */
    protected WebElement waitVisibilityAndFindElement(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    /**
     * Retrieves the first 6 characters of the text from the title element in the section.
     *
     * @return Substring of the title text (first 6 characters).
     */
    public String getTitlePart() {
        WebElement title = waitVisibilityAndFindElement(titleLocator);
        return title.getText().substring(0, 6);
    }
}

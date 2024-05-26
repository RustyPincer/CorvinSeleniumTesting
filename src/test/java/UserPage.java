import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * UserPage represents the user page of the website and provides methods to interact with it.
 */
public class UserPage extends BasePage {

    // Locators for elements on the user page
    private final By postalCodeTextLocator = By.xpath("//span[@class='postal-code']");
    private final By userDataEditLocator = By.xpath("//a[@href='/user/7504/customer']");
    private final By alertTextLocator = By.xpath("//div[@class='alert alert-success alert-dismissible']/p");

    /**
     * Constructor to initialize the UserPage.
     *
     * @param driver WebDriver instance to interact with the web page.
     */
    public UserPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Retrieves the postal code displayed on the user page.
     *
     * @return String representing the postal code.
     */
    public String getPostalCode() {
        WebElement postalCodeText = waitVisibilityAndFindElement(postalCodeTextLocator);
        return postalCodeText.getText();
    }

    /**
     * Navigates to the user edit page by clicking on the edit user data link.
     *
     * @return UserEditPage object representing the user edit page.
     */
    public UserEditPage goToUserEdit() {
        WebElement userEdit = waitVisibilityAndFindElement(userDataEditLocator);
        userEdit.click();
        return new UserEditPage(this.driver);
    }

    /**
     * Retrieves the alert text displayed on the user page.
     *
     * @return String representing the alert text.
     */
    public String getAlertText() {
        WebElement alertText = waitVisibilityAndFindElement(alertTextLocator);
        return alertText.getText();
    }
}

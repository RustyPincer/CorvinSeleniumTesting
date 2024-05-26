import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * LoginPage represents the login page of the website and provides methods to interact with it.
 */
public class LoginPage extends BasePage {

    // Locators for elements on the login page
    private final By nameInputLocator = By.xpath("//input[@name='name']");
    private final By passInputLocator = By.xpath("//input[@name='pass']");
    private final By submitButtonLocator = By.xpath("//button[@id='edit-submit']");

    /**
     * Constructor to initialize the LoginPage.
     *
     * @param driver WebDriver instance to interact with the web page.
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Logs in the user by entering the provided username and password, and then clicking the submit button.
     *
     * @param name Username to be entered.
     * @param pass Password to be entered.
     * @return UserPage object representing the user page after login.
     */
    public UserPage login(String name, String pass) {
        WebElement nameInput = waitVisibilityAndFindElement(nameInputLocator);
        nameInput.sendKeys(name);
        WebElement passInput = waitVisibilityAndFindElement(passInputLocator);
        passInput.sendKeys(pass);
        WebElement submitButton = waitVisibilityAndFindElement(submitButtonLocator);
        submitButton.click();
        return new UserPage(this.driver);
    }
}

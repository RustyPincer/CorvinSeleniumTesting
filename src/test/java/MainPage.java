import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * MainPage represents the main page of the website and provides methods to interact with it.
 */
public class MainPage extends BasePage {

    // Locators for elements on the main page
    private final By accountButtonLocator = By.xpath("//a[@id='account-menu']");
    private final By loginButtonLocator = By.xpath("//a[@href='/user/login']");
    private final By logoutButtonLocator = By.xpath("//li[@class='last']/a[@href='/user/logout']");
    private final By accountStatusLocator = By.className("account--status");

    /**
     * Constructor to initialize the MainPage.
     * It opens the main page URL and deletes all cookies.
     *
     * @param driver WebDriver instance to interact with the web page.
     */
    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://corvinmozi.hu/");
        driver.manage().deleteAllCookies();
    }

    /**
     * Navigates to the login page by clicking on the account button and then the login button.
     *
     * @return LoginPage object representing the login page.
     */
    public LoginPage goToLoginPage() {
        WebElement accountButton = waitVisibilityAndFindElement(accountButtonLocator);
        accountButton.click();
        WebElement loginButton = waitVisibilityAndFindElement(loginButtonLocator);
        loginButton.click();
        return new LoginPage(this.driver);
    }

    /**
     * Logs out the user by clicking on the account button and then the logout button.
     */
    public void logout() {
        WebElement accountButton = waitVisibilityAndFindElement(accountButtonLocator);
        accountButton.click();
        WebElement logoutButton = waitVisibilityAndFindElement(logoutButtonLocator);
        logoutButton.click();
    }

    /**
     * Retrieves the background color of the account status element.
     *
     * @return String representing the CSS value of the background color.
     */
    public String getAccountStatus() {
        WebElement accountStatus = waitVisibilityAndFindElement(accountStatusLocator);
        return accountStatus.getCssValue("background-color");
    }
}

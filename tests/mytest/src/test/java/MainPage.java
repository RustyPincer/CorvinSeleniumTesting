import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    private final By accountButtonLocator = By.xpath("//a[@id='account-menu']");
    private final By loginButtonLocator = By.xpath("//a[@href='/user/login']");
    private final By logoutButtonLocator = By.xpath("//li[@class='last']/a[@href='/user/logout']");
    private final By accountStatusLocator = By.className("account--status");

    public MainPage(WebDriver driver) {
        super(driver);
        driver.get("https://corvinmozi.hu/");
        driver.manage().deleteAllCookies();
    }

    public LoginPage goToLoginPage() {
        WebElement accountButton = waitVisibiltyAndFindElement(accountButtonLocator);
        accountButton.click();
        WebElement loginButton = waitVisibiltyAndFindElement(loginButtonLocator);
        loginButton.click();
        return new LoginPage(this.driver);
    }

    public void logout() {
        WebElement accountButton = waitVisibiltyAndFindElement(accountButtonLocator);
        accountButton.click();
        WebElement logoutButton = waitVisibiltyAndFindElement(logoutButtonLocator);
        logoutButton.click();
    }

    public String getAccountStatus() {
        WebElement accountStatus = waitVisibiltyAndFindElement(accountStatusLocator);
        return accountStatus.getCssValue("background-color");
    }
}

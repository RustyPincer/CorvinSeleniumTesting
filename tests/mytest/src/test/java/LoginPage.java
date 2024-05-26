import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    private final By nameInputLocator = By.xpath("//input[@name='name']");
    private final By passInputLocator = By.xpath("//input[@name='pass']");
    private final By submitButtonLocator = By.xpath("//button[@id='edit-submit']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public UserPage login(String name, String pass) {
        WebElement nameInput = waitVisibiltyAndFindElement(nameInputLocator);
        nameInput.sendKeys(name);
        WebElement passInput = waitVisibiltyAndFindElement(passInputLocator);
        passInput.sendKeys(pass);
        WebElement submitButton = waitVisibiltyAndFindElement(submitButtonLocator);
        submitButton.click();
        return new UserPage(this.driver);
    }
}

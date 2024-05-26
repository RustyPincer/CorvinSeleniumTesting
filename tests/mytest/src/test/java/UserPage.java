import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserPage extends BasePage {
    private final By postalCodeTextLocator = By.xpath("//span[@class='postal-code']");
    private final By userDataEditLocator = By.xpath("//a[@href='/user/7504/customer']");
    private final By alertTextLocator = By.xpath("//div[@class='alert alert-success alert-dismissible']/p");

    public UserPage(WebDriver driver) {
        super(driver);
    }

    public String getPostalCode() {
        WebElement postalCodeText = waitVisibiltyAndFindElement(postalCodeTextLocator);
        return postalCodeText.getText();
    }

    public UserEditPage goToUserEdit() {
        WebElement userEdit = waitVisibiltyAndFindElement(userDataEditLocator);
        userEdit.click();
        return new UserEditPage(this.driver);
    }

    public String getAlertText() {
        WebElement alertText = waitVisibiltyAndFindElement(alertTextLocator);
        return alertText.getText();
    }
}

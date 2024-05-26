import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class UserEditPage extends BasePage {
    private final By editSubmitLocator = By.xpath("//button[@id='edit-submit']");
    private final By countrySelectLocator = By.xpath("//div[@class='select-wrapper']/select");
    private final By postalInputLocator = By.xpath("//input[@class='postal-code form-text required form-control']");
    private final By lastNameInputLocator = By.xpath("//div[@id='edit-address-0-address-container0']/div/input[@name='address[0][address][family_name]']");

    public UserEditPage(WebDriver driver) {
        super(driver);
    }

    public void selectCountryByValue(String value) {
        Select countrySelect = new Select(waitVisibiltyAndFindElement(countrySelectLocator));
        countrySelect.selectByValue(value);
    }

    public void setPostalCode(String value) {
        WebElement postalInput = waitVisibiltyAndFindElement(postalInputLocator);
        postalInput.clear();
        postalInput.sendKeys(value);
    }

    public void setLastName(String value) {
        WebElement lastNameInput = waitVisibiltyAndFindElement(lastNameInputLocator);
        lastNameInput.clear();
        lastNameInput.sendKeys(value);
    }

    public void submitForm() {
        WebElement editSubmit = waitVisibiltyAndFindElement(editSubmitLocator);

        Actions actions = new Actions(driver);
        actions.moveToElement(editSubmit);
        actions.pause(1000);
        actions.click(editSubmit);
        actions.perform();
    }
}

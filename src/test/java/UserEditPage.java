import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * UserEditPage represents the user edit page of the website and provides methods to interact with it.
 */
public class UserEditPage extends BasePage {

    // Locators for elements on the user edit page
    private final By editSubmitLocator = By.xpath("//button[@id='edit-submit']");
    private final By countrySelectLocator = By.xpath("//div[@class='select-wrapper']/select");
    private final By postalInputLocator = By.xpath("//input[@class='postal-code form-text required form-control']");
    private final By lastNameInputLocator = By.xpath("//div[@id='edit-address-0-address-container0']/div/input[@name='address[0][address][family_name]']");

    /**
     * Constructor to initialize the UserEditPage.
     *
     * @param driver WebDriver instance to interact with the web page.
     */
    public UserEditPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Selects a country from the dropdown by its value.
     *
     * @param value The value attribute of the option to be selected.
     */
    public void selectCountryByValue(String value) {
        Select countrySelect = new Select(waitVisibilityAndFindElement(countrySelectLocator));
        countrySelect.selectByValue(value);
    }

    /**
     * Sets the postal code in the postal code input field.
     *
     * @param value The postal code to be entered.
     */
    public void setPostalCode(String value) {
        WebElement postalInput = waitVisibilityAndFindElement(postalInputLocator);
        postalInput.clear();
        postalInput.sendKeys(value);
    }

    /**
     * Sets the last name in the last name input field.
     *
     * @param value The last name to be entered.
     */
    public void setLastName(String value) {
        WebElement lastNameInput = waitVisibilityAndFindElement(lastNameInputLocator);
        lastNameInput.clear();
        lastNameInput.sendKeys(value);
    }

    /**
     * Submits the user edit form.
     */
    public void submitForm() {
        WebElement editSubmit = waitVisibilityAndFindElement(editSubmitLocator);

        Actions actions = new Actions(driver);
        actions.moveToElement(editSubmit)
                .pause(1000)
                .click(editSubmit)
                .perform();
    }
}

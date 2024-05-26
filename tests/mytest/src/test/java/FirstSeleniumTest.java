import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class FirstSeleniumTest {
    private final String[] staticPages = {
            "https://corvinmozi.hu/info/simple-mobilapp",
            "https://corvinmozi.hu/jegyar/online-vasarlas",
            "https://corvinmozi.hu/100-eves-corvin-mozi-tortenete"
    };
    private final String[] staticPageTitles = {
            "SIMPLE",
            "ONLINE",
            "A 100 "
    };
    private WebDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("log-level=3");
        driver = new RemoteWebDriver(new URL("http://selenium:4444/wd/hub"), options);
        driver.manage().window().maximize();
    }

    @Test
    public void testLoginAndLogout() {
        MainPage mainPage = new MainPage(driver);
        UserPage userPage = login(mainPage);

        assertEquals("1000", userPage.getPostalCode());

        mainPage.logout();

        assertEquals("rgba(217, 83, 79, 1)", mainPage.getAccountStatus());
    }

    @Test
    public void testFormSendingWithUser() {
        MainPage mainPage = new MainPage(driver);
        UserPage userPage = login(mainPage);
        UserEditPage userEditPage = userPage.goToUserEdit();

        userEditPage.selectCountryByValue("HU");
        userEditPage.setPostalCode("1000");
        userEditPage.setLastName("Mac");

        userEditPage.submitForm();

        assertEquals("The profile has been saved.", userPage.getAlertText());
    }

    @Test
    public void testStaticPages() {
        BasePage basePage = new BasePage(driver);
        for(int i = 0; i < staticPages.length; i++) {
            driver.get(staticPages[i]);
            assertEquals(staticPageTitles[i], basePage.getTitlePart());
        }
    }

    private UserPage login(MainPage mainPage) {
        LoginPage loginPage = mainPage.goToLoginPage();
        return loginPage.login("Sqat", "Alma123");
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

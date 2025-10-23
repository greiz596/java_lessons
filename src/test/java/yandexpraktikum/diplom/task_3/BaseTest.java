package diplom.task_3;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import static api.UserApi.deleteUser;
import static constants.User.*;


public class BaseTest {

    public WebDriver driver;

    @Before
    public void preCondition() {
        driver = SelectBrowser.getWebDriver("chrome");
        deleteUser(DEFAULT_DATA_LOGIN);
    }

    @After
    public void deleteUserAndCloseBrowser() {
        deleteUser(DEFAULT_DATA_LOGIN);
        driver.quit();
    }
}

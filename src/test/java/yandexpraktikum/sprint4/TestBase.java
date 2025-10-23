package sprint4;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class TestBase {
    protected WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();  //FirefoxDriver ChromeDriver
        driver.manage().window().maximize();
    }

    @After
    public void teardown() {
        if (driver != null) {
            // Quit the WebDriver session
            driver.quit();
        }
    }
}
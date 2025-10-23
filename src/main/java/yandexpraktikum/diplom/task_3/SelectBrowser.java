package diplom.task_3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SelectBrowser {
    public static WebDriver getWebDriver(String browserName) {
        switch (browserName) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\chromedriver.exe"); //версия 124.0.6367.119
                ChromeOptions options = new ChromeOptions();
                options.setBinary("C:\\WebDriver\\chrome-win64\\chrome.exe"); //версия 124.0.6367.119
                return new ChromeDriver(options);
            case "yandex":
                System.setProperty("webdriver.chrome.driver", "C:\\WebDriver\\bin\\yandexdriver.exe");
                return new ChromeDriver();
            default:
                throw new RuntimeException("invalid browser name");
        }
    }
}

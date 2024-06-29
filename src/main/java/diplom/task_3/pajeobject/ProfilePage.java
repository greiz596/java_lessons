package diplom.task_3.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePage {
    private final WebDriver driver;
    private final By textDescription = By.className("Account_text__fZAIn");
    private final By buttonExit = By.xpath(".//button[text() = 'Выход']");
    private final By buttonConstructor = By.xpath(".//p[text() = 'Конструктор']");
    private final By buttonLogo = By.className("AppHeader_header__logo__2D0X2");

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Открыть: главная страница через кнопку Конструктор")
    public void openHomePageConstructorButton() {
        HomePage homePage = new HomePage(driver);
        driver.findElement(buttonConstructor).click();
        homePage.checkPageLoad();
    }

    @Step("Открыть: главная страница через логотип")
    public void openHomePageHeadlineButton() {
        HomePage homePage = new HomePage(driver);
        driver.findElement(buttonLogo).click();
        homePage.checkPageLoad();
    }

    @Step("Нажать кноку Выход на странице профиля")
    public void exit() {
        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(buttonExit).click();
        loginPage.checkPageLoad();
    }

    @Step("Проверка: загружена страница профиля")
    public void checkPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textDescription));
    }

    @Step("Проверка: отображен текст на странице профиля")
    public boolean checkDescription() {
        return driver.findElement(textDescription).isDisplayed();
    }
}

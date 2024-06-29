package diplom.task_3.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private final WebDriver driver;
    private final By textRegistration = By.xpath(".//h2[text() = 'Регистрация']");
    private final By inputName = By.xpath(".//label[text() = 'Имя']/../input");
    private final By inputEmail = By.xpath(".//label[text() = 'Email']/../input");
    private final By inputPassword = By.xpath(".//input[@type = 'password']");
    private final By buttonRegister = By.xpath(".//button[text()  = 'Зарегистрироваться']");
    private final By buttonEnter = By.className("Auth_link__1fOlj");
    private final By invalidPassword = By.xpath(".//p[text() = 'Некорректный пароль']");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Регистрация: ввод name, email, пароль")
    public void register(String name, String email, String password) {
        driver.findElement(inputName).sendKeys(name);
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonRegister).click();
    }

    @Step("Проверка: загрузка страницы регистрации")
    public void checkPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textRegistration));
    }

    @Step("Переход на страницу Вход через кнопку Войти")
    public void openLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(buttonEnter).click();
        loginPage.checkPageLoad();
    }

    @Step("Проверка: отображен текст Некорректный пароль")
    public boolean checkInvalidPassword() {
        return driver.findElement(invalidPassword).isDisplayed();
 }
}




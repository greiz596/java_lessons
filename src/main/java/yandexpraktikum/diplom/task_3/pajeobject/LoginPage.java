package diplom.task_3.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;
    private final By textEnter = By.xpath(".//h2[text() = 'Вход']");
    private final By inputEmail = By.xpath(".//input[@type = 'text']");
    private final By inputPassword = By.xpath(".//input[@type = 'password']");
    private final By buttonEnter = By.xpath(".//button[text() = 'Войти']");
    private final By buttonRegister = By.xpath(".//a[text() = 'Зарегистрироваться']");
    private final By buttonRecoveryPassword = By.xpath(".//a[text() = 'Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Логин: ввод email, pswd")
    public void login(String email, String password) {
        driver.findElement(inputEmail).sendKeys(email);
        driver.findElement(inputPassword).sendKeys(password);
        driver.findElement(buttonEnter).click();
    }

    @Step("Открыть страницу: регистрация")
    public void openRegisterPage() {
        RegisterPage registerPage = new RegisterPage(driver);
        driver.findElement(buttonRegister).click();
        registerPage.checkPageLoad();
    }

    @Step("Открыть страницу: восстановление пароля")
    public void openRecoveryPasswordPage() {
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);
        driver.findElement(buttonRecoveryPassword).click();
        forgotPasswordPage.checkPageLoad();
    }

    @Step("Проверка: загружена страница login")
    public void checkPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(textEnter));
    }

    @Step("роверка: отображен текст Вход")
    public boolean checkTextEnter() {
        return driver.findElement(textEnter).isDisplayed();
    }
}

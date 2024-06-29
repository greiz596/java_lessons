package diplom.task_3.pajeobject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static constants.Api.*;

public class HomePage {
    private final WebDriver driver;
    private final By buttonBuns = By.xpath(".//span[text() = 'Булки']");
    private final By buttonSauce = By.xpath(".//span[text() = 'Соусы']");
    private final By buttonFilling = By.xpath(".//span[text() = 'Начинки']");
    private final By buttonAccount = By.xpath(".//p[text() = 'Личный Кабинет']");
    private final By buttonEnterAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    private final By buttonPlaceOrder = By.xpath(".//button[text()= 'Оформить заказ']");
    private final By headlineCollectBurger = By.xpath(".//h1[text() = 'Соберите бургер']");
    private final By currentTab = By.className("tab_tab_type_current__2BEPc");


    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Перейти на главную страницу https://stellarburgers.nomoreparties.site/")
    public void openHomePage() {
        driver.get(BASE_URL);
        checkPageLoad();
    }

    @Step("Главная страница. Нажать Личный кабинет")
    public void openAccount() {
        driver.findElement(buttonAccount).click();
        if (driver.getCurrentUrl().equals(BASE_URL + "login")) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.checkPageLoad();
        } else {
            ProfilePage profilePage = new ProfilePage(driver);
            profilePage.checkPageLoad();
        }
    }

    @Step("Гланвая страница. Нажать Войти в аккаунт")
    public void openLoginPage() {
        LoginPage loginPage = new LoginPage(driver);
        driver.findElement(buttonEnterAccount).click();
        loginPage.checkPageLoad();
    }

    @Step("Гланвая страница. Нажать Булки")
    public void openBuns() {
        driver.findElement(buttonBuns).click();
    }
    @Step("Главная страница. Нажать Соусы")
    public void openSauces() {
        driver.findElement(buttonSauce).click();
    }

    @Step("Главная страница. Нажать Начинки")
    public void openFillings() {
        driver.findElement(buttonFilling).click();
    }

    @Step("Конструктор: проверить выбранный раздел Булки")
    public String checkScrollBuns() {
        WebElement element = driver.findElement(currentTab);
        return element.getText();
    }

    @Step("Конструктор: проверить выбранный раздел Соусы")
    public String checkScrollSauces() {
        WebElement element = driver.findElement(currentTab);
        return element.getText();
    }

    @Step("Конструктор: проверить выбранный раздел Начинки")
    public String checkScrollFillings() {
        WebElement element = driver.findElement(currentTab);
        return element.getText();
    }

    @Step("Проверка: главная страница загружена")
    public void checkPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(headlineCollectBurger));
    }

    @Step("Проверка: доступна кнопка Оформить заказ")
    public boolean checkButtonPlaceOrder() {
        return driver.findElement(buttonPlaceOrder).isDisplayed();
    }
}

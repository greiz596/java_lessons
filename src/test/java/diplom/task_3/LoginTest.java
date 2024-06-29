package diplom.task_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pajeobject.ForgotPasswordPage;
import pajeobject.HomePage;
import pajeobject.LoginPage;
import pajeobject.RegisterPage;

import static api.UserApi.createUser;
import static constants.Api.*;
import static constants.User.*;

public class LoginTest extends BaseTest {
    @Test
    @DisplayName("Успешный вход: кнопка Войти")
    public void loginEnterButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        createUser();

        homePage.openHomePage();
        homePage.openLoginPage();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assert.assertTrue(homePage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Успешный вход: кнопка Личный кабинет")
    public void loginUserWithPersonalAccountButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);

        createUser();

        homePage.openHomePage();
        homePage.openAccount();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assert.assertTrue(homePage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Успешный вход: кнопка через форму регистрации")
    public void loginUserFromRegistrationPage() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        createUser();

        homePage.openHomePage();
        homePage.openLoginPage();

        loginPage.openRegisterPage();
        registerPage.openLoginPage();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assert.assertTrue(homePage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Успешный вход: кнопка через форму восстановления пароля")
    public void loginUserFromForgotPasswordPage() {
        createUser();
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        homePage.openHomePage();
        homePage.openLoginPage();

        loginPage.openRecoveryPasswordPage();
        forgotPasswordPage.openLoginPage();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assert.assertTrue(homePage.checkButtonPlaceOrder());
    }
}

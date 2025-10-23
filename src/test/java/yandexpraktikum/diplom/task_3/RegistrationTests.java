package diplom.task_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pajeobject.HomePage;
import pajeobject.LoginPage;
import pajeobject.RegisterPage;

import static constants.Api.*;
import static constants.User.*;
import static org.junit.Assert.assertEquals;

public class RegistrationTests extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void createNewUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.openHomePage();
        homePage.openLoginPage();

        loginPage.openRegisterPage();
        registerPage.register(USER_NAME, USER_EMAIL, USER_PASSWORD);

        loginPage.checkPageLoad();

        assertEquals(BASE_URL + "login", driver.getCurrentUrl());
        Assert.assertTrue(loginPage.checkTextEnter());
    }

    @Test
    @DisplayName("Неуспешная регистрация: некорректный пароль")
    public void createUserWrongPassword() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        homePage.openHomePage();
        homePage.openLoginPage();

        loginPage.openRegisterPage();
        registerPage.register(USER_NAME, USER_EMAIL, WRONG_PASSWORD);

        Assert.assertTrue(registerPage.checkInvalidPassword());
    }
}

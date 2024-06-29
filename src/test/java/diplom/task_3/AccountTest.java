package diplom.task_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import pajeobject.HomePage;
import pajeobject.LoginPage;
import pajeobject.ProfilePage;

import static api.UserApi.createUser;
import static constants.Api.*;
import static constants.User.*;

public class AccountTest extends BaseTest {
    @Test
    @DisplayName("Личный кабинет: открытие по кнопке «Личный кабинет»")
    public void openWebAccount() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        createUser();
        homePage.openHomePage();
        homePage.openAccount();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        homePage.openAccount();
        Assert.assertEquals(BASE_URL + "account/profile", driver.getCurrentUrl());
        Assert.assertTrue(profilePage.checkDescription());
    }

    @Test
    @DisplayName("Конструктор: открытие по кнопке «Конструктор»")
    public void clickConstructorButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        createUser();

        homePage.openHomePage();
        homePage.openAccount();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();
        homePage.openAccount();

        profilePage.openHomePageConstructorButton();

        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assert.assertTrue(homePage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Конструктор: открытие по кнопке «Логотип»")
    public void clickLogoButton() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        createUser();
        homePage.openHomePage();
        homePage.openAccount();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        homePage.openAccount();
        profilePage.openHomePageHeadlineButton();

        Assert.assertEquals(BASE_URL, driver.getCurrentUrl());
        Assert.assertTrue(homePage.checkButtonPlaceOrder());
    }

    @Test
    @DisplayName("Выход из аккаунта")
    public void logoutUser() {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        createUser();
        homePage.openHomePage();
        homePage.openAccount();

        loginPage.login(USER_EMAIL, USER_PASSWORD);
        homePage.checkPageLoad();

        homePage.openAccount();
        profilePage.exit();

        Assert.assertEquals(BASE_URL + "login", driver.getCurrentUrl());
        Assert.assertTrue(loginPage.checkTextEnter());
    }

}

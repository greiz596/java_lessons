package diplom.task_3.api;

import data.CreateUser;
import data.LoginUser;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static constants.Api.*;
import static constants.User.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserApi {
    @Step("Регистрация /api/auth/register")
    public static void sendPostCreateUser(CreateUser createUser) {
        given()
                .header("Content-type", "application/json")
                .body(createUser)
                .post(CREATE_USER_URL)
                .then()
                .statusCode(CODE_200)
                .body("success", equalTo(true));
    }

    @Step("Авторизация /api/auth/login")
    public static Response sendLoginUser(LoginUser login) {
        return given()
                .header("Content-type", "application/json")
                .body(login)
                .post(LOGIN_USER_URL);
    }

    @Step("Получить accessToken")
    public static String loginGetAccessToken(LoginUser login) {
        String accessToken = sendLoginUser(login).path("accessToken");
        return accessToken;
    }


    @Step("Создать пользователя")
    public static void createUser() {
        RestAssured.baseURI = BASE_URL;
        CreateUser createUser = new CreateUser(USER_EMAIL, USER_PASSWORD, USER_NAME);
        sendPostCreateUser(createUser);
    }


    @Step("Удалить пользователя")
    public static void deleteUser(LoginUser login) {
        RestAssured.baseURI = BASE_URL;
        String accessToken = loginGetAccessToken(login);
        if (accessToken != null) {
            Response responseDelete =
                    given()
                            .header("Authorization", accessToken)
                            .delete(USER_URL);
            responseDelete.then()
                    .statusCode(CODE_202)
                    .body("message", equalTo("User successfully removed"));
        }
    }
}



package diplom.task_2.api;

import diplom.task_2.data.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static diplom.task_2.utils.constants.Api.*;
import static diplom.task_2.utils.constants.Constants.*;
import static diplom.task_2.utils.constants.Steps.USER_API;

public class UserApi {
    @Step("POST /api/auth/register")
    public Response sendCreateUser(CreateUser createUser) {
        return given()
                .header("Content-type", "application/json")
                .body(createUser)
                .post(CREATE_USER_URL);
    }

    @Step("POST /api/auth/login")
    public Response sendLoginUser(Login login) {
        return given()
                .header("Content-type", "application/json")
                .body(login)
                .post(LOGIN_USER_URL);
    }

    @Step("PATCH /api/auth/user")
    public Response sendUpdateUser(UpdateUser updateUser, String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .body(updateUser)
                .patch(UPDATE_INFO_URL);
    }

    @Step("Получить accessToken")
    public String loginGetAccessToken(Login login) {
        String accessToken = USER_API.sendLoginUser(login).path("accessToken");
        return accessToken;
    }

    @Step("Удалить пользователь")
    public void deleteUser(Login login) {
        String accessToken = USER_API.loginGetAccessToken(login);
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

package diplom.task_2;

import diplom.task_2.data.UpdateUser;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static diplom.task_2.utils.constants.Constants.*;
import static diplom.task_2.utils.constants.Steps.USER_API;
import static diplom.task_2.utils.constants.User.*;

public class ChangeUserTests extends BaseTest {

    @Test
    @DisplayName("Изменить email. Пользователь авторизован")
    @Description("Успешная смена email пользователя под его учетной записью")
    public void changeEmailWithAuth() {
        USER_API.sendCreateUser(DEFAULT_CREATE_USER_DATA).then().statusCode(CODE_200);
        String accessToken = USER_API.loginGetAccessToken(DEFAULT_LOGIN_DATA);

        UpdateUser updateUser = new UpdateUser(NEW_EMAIL, null, null);
        USER_API.sendUpdateUser(updateUser, accessToken).then()
                .statusCode(CODE_200)
                .body("success", equalTo(true))
                .body("user.email", equalTo(NEW_EMAIL))
                .body("user.name", equalTo(LOGIN));

        UpdateUser returnUser = new UpdateUser(EMAIL, null, null);
        USER_API.sendUpdateUser(returnUser, accessToken).then().statusCode(CODE_200);
    }

    @Test
    @DisplayName("Изменить password. Пользователь авторизован")
    @Description("Успешная смена password пользователя под его учетной записью")
    public void changePasswordWithAuth() {
        USER_API.sendCreateUser(DEFAULT_CREATE_USER_DATA).then().statusCode(CODE_200);
        String accessToken = USER_API.loginGetAccessToken(DEFAULT_LOGIN_DATA);

        UpdateUser updateUser = new UpdateUser(null, NEW_PASSWORD, null);
        USER_API.sendUpdateUser(updateUser, accessToken).then()
                .statusCode(CODE_200)
                .body("success", equalTo(true))
                .body("user.email", equalTo(EMAIL))
                .body("user.name", equalTo(LOGIN));

        UpdateUser returnUser = new UpdateUser(null, PASSWORD, null);
        USER_API.sendUpdateUser(returnUser, accessToken).then().statusCode(CODE_200);
    }

    @Test
    @DisplayName("Изменить login. Пользователь авторизован")
    @Description("Успешная смена login пользователя под его учетной записью")
    public void changeNameWithAuth() {
        USER_API.sendCreateUser(DEFAULT_CREATE_USER_DATA).then().statusCode(CODE_200);
        String accessToken = USER_API.loginGetAccessToken(DEFAULT_LOGIN_DATA);

        UpdateUser updateUser = new UpdateUser(null, null, NEW_LOGIN);
        USER_API.sendUpdateUser(updateUser, accessToken).then()
                .statusCode(CODE_200)
                .body("success", equalTo(true))
                .body("user.email", equalTo(EMAIL))
                .body("user.name", equalTo(NEW_LOGIN));

        UpdateUser returnUser = new UpdateUser(null, null, LOGIN);
        USER_API.sendUpdateUser(returnUser, accessToken).then().statusCode(CODE_200);
    }

    @Test
    @DisplayName("Изменить email. Пользователь не авторизован")
    @Description("Неуспешная смена email без авторизаци")
    public void changeEmailWithoutAuth() {

        UpdateUser updateUser = new UpdateUser(NEW_EMAIL, null, null);
        USER_API.sendUpdateUser(updateUser, "").then()
                .statusCode(CODE_401)
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Изменить password. Пользователь не авторизован")
    @Description("Неуспешная смена password без авторизаци")
    public void changePasswordWithoutAuth() {

        UpdateUser updateUser = new UpdateUser(null, NEW_PASSWORD, null);
        USER_API.sendUpdateUser(updateUser, "").then()
                .statusCode(CODE_401)
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));
    }

    @Test
    @DisplayName("Изменить login. Пользователь не авторизован")
    @Description("Неуспешная смена login без авторизаци")
    public void changeLoginWithoutAuth() {

        UpdateUser updateUser = new UpdateUser(null, null, NEW_LOGIN);
        USER_API.sendUpdateUser(updateUser, "").then()
                .statusCode(CODE_401)
                .body("success", equalTo(false))
                .body("message", equalTo("You should be authorised"));
    }

    @After
    public void sendDeleteUser() {
        USER_API.deleteUser(DEFAULT_LOGIN_DATA);
    }
}


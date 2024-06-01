package sprint7;

import sprint7.data.courier.LoginCourier;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static sprint7.utils.Steps.*;
import static sprint7.utils.constants.Constants.*;
import static sprint7.utils.constants.Courier.*;

public class LoginCourierTest extends BaseTest {
    @Test
    @DisplayName("Успешная авторизация существующего курьера")
    public void testAuthCourier() {
        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(201);
        COURIER_API.sendPostRequestLogin(DEFUALT_LOGIN_COURIER_DATA).
                then()
                .statusCode(CODE_200)
                .body("id", instanceOf(Integer.class));
    }

    @Test
    @DisplayName("Авторизация без поля login")
    public void testAuthCourierMissingLogin() {
        LoginCourier courierWithoutLogin = new LoginCourier(null, PASSWORD);


        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(201);
        COURIER_API.sendPostRequestLogin(courierWithoutLogin).
                then()
                .statusCode(CODE_400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test //504 ошибка при password = null
    @DisplayName("Авторизация без поля password")
    public void testAuthCourierMissingPassword() {
        LoginCourier courierWithoutPassword = new LoginCourier(LOGIN, "");

        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(201);
        COURIER_API.sendPostRequestLogin(courierWithoutPassword).
                then()
                .statusCode(CODE_400)
                .body("message", equalTo("Недостаточно данных для входа"));
    }

    @Test
    @DisplayName("Авторизация с несуществующим логином, существующим паролем")
    public void testAuthCourierHalfNonExistentLogin() {

        LoginCourier courierNonExistenLogin = new LoginCourier("nonExisten", PASSWORD);

        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(201);
        COURIER_API.sendPostRequestLogin(courierNonExistenLogin).
                then()
                .statusCode(CODE_404)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Авторизация с существующим логином, несуществующим паролем")
    public void testAuthCourierHalfNonExistentPassword() {

        LoginCourier courierNonExistenPassword = new LoginCourier(LOGIN, "nonExisten");

        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(201);
        COURIER_API.sendPostRequestLogin(courierNonExistenPassword).
                then()
                .statusCode(CODE_404)
                .body("message", equalTo("Учетная запись не найдена"));
    }

    @Test
    @DisplayName("Авторизация с несуществующим логином, несуществующим паролем")
    public void testAuthCourierNonExistentUser() {

        LoginCourier courierNonExistenUser = new LoginCourier("nonExisten", "nonExisten");

        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(201);
        COURIER_API.sendPostRequestLogin(courierNonExistenUser).
                then()
                .statusCode(CODE_404)
                .body("message", equalTo("Учетная запись не найдена"));
    }
}
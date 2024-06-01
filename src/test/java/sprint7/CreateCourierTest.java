package sprint7;

import sprint7.data.courier.CreateCourier;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import static org.hamcrest.Matchers.equalTo;
import static sprint7.utils.Steps.*;
import static sprint7.utils.constants.Constants.*;
import static sprint7.utils.constants.Courier.*;


public class CreateCourierTest extends BaseTest {
    @Test
    @DisplayName("Создание нового курьера")
    public void testCreateCourier() {
        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA)
                .then()
                .statusCode(CODE_201)
                .body("ok", equalTo(true));
    }

    @Test
    @DisplayName("Неуспешное создание двух одинаковых курьеров")
    public void testCreateDuplicateCourier() {

        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).then().statusCode(CODE_201);

        COURIER_API.sendPostRequestCourier(DEFUALT_CREATE_COURIER_DATA).
                then()
                .statusCode(CODE_409)
                .body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

    @Test
    @DisplayName("Создание курьера без поля login")
    public void testCreateCourierMissingLogin() {
        CreateCourier courierWithoutLogin = new CreateCourier(null, PASSWORD, FIRST_NAME);

        COURIER_API.sendPostRequestCourier(courierWithoutLogin).
                then()
                .statusCode(CODE_400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }

    @Test
    @DisplayName("Создание курьера без поля password")
    public void testCreateCourierMissingPassword() {
        CreateCourier courierWithoutPassword = new CreateCourier(LOGIN, null, FIRST_NAME);

        COURIER_API.sendPostRequestCourier(courierWithoutPassword).
                then()
                .statusCode(CODE_400)
                .body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}
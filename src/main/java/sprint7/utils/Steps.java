package sprint7.utils;

import sprint7.api.CourierApi;
import sprint7.api.OrdersApi;
import sprint7.data.courier.DeleteCourier;
import sprint7.data.courier.LoginCourier;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static sprint7.utils.constants.Api.COURIER_API_URL;
import static sprint7.utils.constants.Constants.*;

public class Steps {
    public final static CourierApi COURIER_API = new CourierApi();
    public final static OrdersApi ORDERS_API = new OrdersApi();


    @Step("Получение ID курьера")
    public String getCourierId(LoginCourier loginCourier) {
        Integer id = COURIER_API.sendPostRequestLogin(loginCourier).path("id");
        String courierId = String.valueOf(id);
        return courierId;
    }

    @Step("Предварительная очистка тестовых данных, если они есть: удаление курьера по ID")
    public void deleteCourierById(LoginCourier loginCourier) {

        String id = getCourierId(loginCourier);

        // Удаляем курьера, если он существует
        if (id != "null") {
            DeleteCourier deleteCourier = new DeleteCourier(id);

            Response responseDelete =

                    given()
                            .header("Content-type", "application/json")
                            .and()
                            .body(deleteCourier)
                            .when()
                            .delete(COURIER_API_URL + "/" + id);
            responseDelete.then()
                    .statusCode(CODE_200)
                    .body("ok", equalTo(true));

        }
    }
}
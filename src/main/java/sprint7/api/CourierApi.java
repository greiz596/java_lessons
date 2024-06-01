package sprint7.api;

import sprint7.data.courier.CreateCourier;
import sprint7.data.courier.LoginCourier;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static sprint7.utils.constants.Api.*;

public class CourierApi {
    @Step("POST /api/v1/courier")
    public Response sendPostRequestCourier(CreateCourier createCourier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(createCourier)
                .when()
                .post(COURIER_API_URL);
    }

    @Step("POST /api/v1/courier/login")
    public Response sendPostRequestLogin(LoginCourier loginCourier) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(loginCourier)
                .when()
                .post(LOG_IN_URL);
    }
}
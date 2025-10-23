package diplom.task_2.api;

import diplom.task_2.data.*;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static diplom.task_2.utils.constants.Api.*;

public class OrderApi {

    @Step("POST /api/orders")
    public Response sendCreateOrder(CreateOrder createOrder, String accessToken) {
        return given()
                .header("Content-type", "application/json")
                .header("Authorization", accessToken)
                .body(createOrder)
                .post(СREATE_ORDER_URL);
    }

    @Step("GET /api/orders")
    public static Response sendGetOrder(String accessToken) {
        return given()
                .header("Authorization", accessToken)
                .get(СREATE_ORDER_URL);
    }


}

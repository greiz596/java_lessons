package sprint7.api;

import sprint7.data.orders.CreateOrder;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static sprint7.utils.constants.Api.*;
import static io.restassured.RestAssured.*;

public class OrdersApi {
    @Step("POST /api/v1/orders")
    public Response sendPostRequestOrder(CreateOrder createOrder) {
        return given()
                .header("Content-type", "application/json")
                .and()
                .body(createOrder)
                .when()
                .post(ORDER_API_URL);
    }

    @Step("GET /api/v1/orders")
    public Response sendGetRequestOrder() {
        return given()
                .header("Content-type", "application/json")
                .when()
                .get(ORDER_API_URL);
    }
}
package sprint7;

import sprint7.data.orders.CreateOrder;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static sprint7.utils.Steps.*;
import static sprint7.utils.constants.Constants.*;
import static sprint7.utils.constants.Order.*;

import static org.hamcrest.Matchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderTest extends BaseTest {
    public CreateOrderTest(String[] color) {
        COLOR = color;
    }

    @Parameterized.Parameters
    public static Object[][] orderParameters() {
        return new Object[][]{
                {new String[]{"BLACK"}},
                {new String[]{"GREY"}},
                {new String[]{"BLACK", "GREY"}},
                {new String[]{}}
        };
    }

    @Test
    @DisplayName("Создание заказа")
    public void createOrder() {

        CreateOrder createOrder;

        if (COLOR.length == 0) {
            createOrder = new CreateOrder(FIRST_NAME_CLIENT, LAST_NAME_CLIENT, ADDRESS_CLIENT,
                    METRO_STATION, PHONE, RENT_TIME, DELIVERY_DATE, COMMENT);
        } else {
            createOrder = new CreateOrder(FIRST_NAME_CLIENT, LAST_NAME_CLIENT, ADDRESS_CLIENT,
                    METRO_STATION, PHONE, RENT_TIME, DELIVERY_DATE, COMMENT, COLOR);
        }
        Response response = ORDERS_API.sendPostRequestOrder(createOrder);

        response.then()
                .body("track", notNullValue())
                .and()
                .statusCode(CODE_201);
    }
}
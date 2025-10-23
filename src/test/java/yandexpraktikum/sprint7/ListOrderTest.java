package sprint7;

import sprint7.api.OrdersApi;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static sprint7.utils.Steps.ORDERS_API;

public class ListOrderTest extends BaseTest{

    @Test
    @DisplayName("Получение списка заказов без параметров")
    public void listOrdersWithoutParameters() {
        ORDERS_API.sendGetRequestOrder().
                then()
                .body("orders", notNullValue());;
    }
}
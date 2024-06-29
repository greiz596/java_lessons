package diplom.task_2;

import diplom.task_2.data.CreateOrder;
import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;

import static org.hamcrest.Matchers.*;
import static diplom.task_2.utils.constants.Constants.*;
import static diplom.task_2.utils.constants.Order.*;
import static diplom.task_2.utils.constants.Steps.*;
import static diplom.task_2.utils.constants.User.*;

public class CreateOrderTests extends BaseTest {


    @Test
    @DisplayName("Создать новый заказ с ингредиентами. Пользователь авторизован")
    @Description("Успешное создание заказа под учетной записью пользователя")
    public void createOrderWithAuth() {
        USER_API.sendCreateUser(DEFAULT_CREATE_USER_DATA).then().statusCode(CODE_200);
        String accessToken = USER_API.loginGetAccessToken(DEFAULT_LOGIN_DATA);

        ORDER_API.sendCreateOrder(DEFAULT_CREATE_ORDER_DATA, accessToken).then()
                .statusCode(CODE_200)
                .body("name", not(emptyOrNullString()))
                .body("order.number", not(emptyOrNullString()))
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Создать новый заказ с ингредиентами. Пользователь не авторизован")
    @Description("Успешное создание заказа без учетной записи пользователя")
    public void createOrderWithoutAuth() {
        ORDER_API.sendCreateOrder(DEFAULT_CREATE_ORDER_DATA, "").then()
                .statusCode(CODE_200)
                .body("name", not(emptyOrNullString()))
                .body("order.number", not(emptyOrNullString()))
                .body("success", equalTo(true));
    }

    @Test
    @DisplayName("Создать новый заказ без ингредиентов")
    @Description("Неуспешное создание заказа без ингредиентов")

    public void createOrderWithoutIngredients() {
        USER_API.sendCreateUser(DEFAULT_CREATE_USER_DATA).then().statusCode(CODE_200);
        String accessToken = USER_API.loginGetAccessToken(DEFAULT_LOGIN_DATA);

        String[] ingredients = new String[]{};
        CreateOrder createOrder = new CreateOrder(ingredients);

        ORDER_API.sendCreateOrder(createOrder, accessToken).then()
                .statusCode(CODE_400)
                .body("message", equalTo("Ingredient ids must be provided"))
                .body("success", equalTo(false));
    }

    @Test
    @DisplayName("Создать новый заказ. Некорректный хэш")
    @Description("Неуспешное создание заказа с неправильным хэш ингредиентов")
    public void createOrderIncorrectHash() {
        USER_API.sendCreateUser(DEFAULT_CREATE_USER_DATA).then().statusCode(CODE_200);
        String accessToken = USER_API.loginGetAccessToken(DEFAULT_LOGIN_DATA);

        String[] ingredients = new String[]{"1", "2"};
        CreateOrder createOrder = new CreateOrder(ingredients);

        ORDER_API.sendCreateOrder(createOrder, accessToken).then()
                .statusCode(CODE_500);
    }

    @After
    public void sendDeleteUser() {
        USER_API.deleteUser(DEFAULT_LOGIN_DATA);
    }
}
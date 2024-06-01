package sprint7.utils.constants;

import sprint7.data.courier.CreateCourier;
import sprint7.data.courier.LoginCourier;

import static sprint7.data.GenerateData.*;

public class Courier {
    public static final String LOGIN = generateRandomString(5);
    public static final String PASSWORD = generateRandomString(5);
    public static final String FIRST_NAME = generateRandomString(5);
    public static final CreateCourier DEFUALT_CREATE_COURIER_DATA = new CreateCourier(LOGIN, PASSWORD, FIRST_NAME);
    public static final LoginCourier DEFUALT_LOGIN_COURIER_DATA = new LoginCourier(LOGIN, PASSWORD);
}
package sprint7.utils.constants;

import static sprint7.data.GenerateData.*;

public class Order {

    public final static String FIRST_NAME_CLIENT = generateRandomString(5);
    public final static String LAST_NAME_CLIENT =  generateRandomString(5);;
    public final static String ADDRESS_CLIENT =  generateRandomString(5);;
    public final static String METRO_STATION = "4";
    public final static String PHONE = generateRandomPhoneNumber();
    public final static int RENT_TIME = 99;
    public final static String DELIVERY_DATE = generateRandomDate();
    public final static String COMMENT =  generateRandomString(5);


    public static String[] COLOR;

}
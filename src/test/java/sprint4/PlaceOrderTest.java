package sprint4;

import sprint4.PageObject.OrderData;
import sprint4.PageObject.PlaceOrder;
import sprint4.PageObject.QuestionTask;
import sprint4.PageObject.RentData;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class PlaceOrderTest extends TestBase {

    private final String firstName;
    private final String secondName;
    private final String address;
    private final String phone;
    private final String orderButton;

    public PlaceOrderTest(String firstName, String secondName, String address, String phone, String orderButton) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.address = address;
        this.phone = phone;
        this.orderButton = orderButton;

    }
    /*  //*[@class='Button_Button__ra12g'] - верхняя кнопка "заказать" на главной странице
        //*[@class='Home_FinishButton__1_cWm'] - нижняя кнопка "заказать" на главной странице
     */
    @Parameterized.Parameters
    public static Object[][] placeOrderData() {
        return new Object[][]{
                {"Аня", "Аннетовна", "ул. Пятиизбянская", "+79377112233", "//*[@class='Button_Button__ra12g']"},
                {"Петр", "Петров", "", "+79377112233", "//*[@class='Home_FinishButton__1_cWm']"}
        };
    }

    @Test
    public void enterData() {
        PlaceOrder placeOrder = new PlaceOrder(driver);
        OrderData orderData = new OrderData(driver);
        RentData rentData = new RentData(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderData.ifFindCookie();

        placeOrder.findOrderButton(orderButton);
        orderData.ifFindCookie();


        orderData.findFirstName().sendKeys(firstName);
        orderData.findSecondName().sendKeys(secondName);
        orderData.findAddress().sendKeys(address);
        orderData.findSubway();
        orderData.findPhone().sendKeys(phone);
        orderData.clickFurther();

        rentData.findCalendar().click();
        rentData.findDate().click();
        rentData.findRentalPeriod().click();
        rentData.findRentalPeriodValue().click();
        rentData.findColor().click();
        rentData.findOrderButton().click();
        rentData.findAgreementButton().click();

        assertTrue(rentData.findPlacedOrder().isDisplayed());
    }

}
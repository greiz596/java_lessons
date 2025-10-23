package sprint4.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import java.time.Duration;

public class RentData {
    private WebDriver driver;

    public RentData(WebDriver driver) {
        this.driver = driver;
    }

    // Строка, при нажатии на которую появляется всплывающее окно календаря
    private final By calendar = By.xpath("//*[contains(@placeholder, '* Когда привезти самокат')]");

    // дата календаря
    private final By date = By.xpath("//*[@class=\"react-datepicker__month-container\"]/div[2]/div[1]/div[2]");

    // Строка, при нажатии на которую появляется выпадающий список срока аренды
    private final By rentalPeriod = By.xpath("//*[@class=\"Dropdown-placeholder\"]");

    // срок аренды
    private final By rentalPeriodValue = By.xpath("//*[@class=\"Dropdown-menu\"]/div[1]");

    // цвет
    private final By color = By.xpath("//*[@id=\"black\"]");

    private final By orderButton = By.xpath("//*[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    private final By agreementButton = By.xpath("//*[@class=\"Order_Modal__YZ-d3\"]/div[2]/button[2]");
    private final By placedOrder = By.xpath("//*[contains(text(), 'Заказ оформлен')]");


    public WebElement findCalendar() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement t = driver.findElement(calendar);
        return t;
    }

    public WebElement findDate() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement t = driver.findElement(date);
        return t;
    }

    public WebElement findRentalPeriod() {
        WebElement t = driver.findElement(rentalPeriod);
        return t;
    }

    public WebElement findRentalPeriodValue() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement t = driver.findElement(rentalPeriodValue);
        return t;
    }

    public WebElement findColor() {
        WebElement t = driver.findElement(color);
        return t;
    }

    public WebElement findOrderButton() {
        WebElement t = driver.findElement(orderButton);
        return t;
    }

    public WebElement findAgreementButton() {
        WebElement t = driver.findElement(agreementButton);
        return t;
    }

    public WebElement findPlacedOrder() {
        WebElement t = driver.findElement(placedOrder);
        return t;
    }
}
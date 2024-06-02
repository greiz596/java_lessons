package sprint4.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderData {
    private WebDriver driver;

    public OrderData(WebDriver driver) {
        this.driver = driver;
    }

    // Поле "имя"
    private final By firstName = By.xpath("//*[contains(@placeholder, 'Имя')]");

    // Поле "Фамилия"
    private final By secondName = By.xpath("//*[contains(@placeholder, 'Фамилия')]");

    // Поле "Адресс"
    private final By address = By.xpath("//*[contains(@placeholder, 'Адрес')]");

    //Выпадающий список "метро" до нажатия
    private final By parrentSubway = By.cssSelector(".select-search");

    // Выпадающий список "метро" после нажатия
    private final By hiddenSubway = By.xpath("//*[@class=\"select-search__select\"]");

    // Константа-значение метро из списка
    private final By anySubway = By.xpath("//li[@data-index=224]");

    //Поле "телефон"
    private final By phone = By.xpath("//*[contains(@placeholder, 'Телефон')]");

    // Кнопка "далее"
    private final By further = By.xpath("//*[@class=\"Button_Button__ra12g Button_Middle__1CSJM\"]");
    private final By cookie = By.xpath("//*[@class=\"App_CookieButton__3cvqF\"]");

    public void ifFindCookie() {

        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
            WebElement t = driver.findElement(cookie);
            if (t.isDisplayed()){
                t.click();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Cookie кнопка не найдена");
        }

    }


    public WebElement findFirstName() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        WebElement t = driver.findElement(firstName);
        return t;
    }

    public WebElement findSecondName(){
        WebElement t = driver.findElement(secondName);
        return t;
    }

    public WebElement findAddress(){
        WebElement t = driver.findElement(address);
        return t;
    }

    public void findSubway() {
        driver.findElement(parrentSubway).click();

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOfElementLocated(hiddenSubway));

        WebElement t = driver.findElement(anySubway);
        t.click();
    }

    public WebElement findPhone(){
        WebElement t = driver.findElement(phone);
        return t;
    }

    public void clickFurther(){
        WebElement t = driver.findElement(further);
        t.click();
    }
}
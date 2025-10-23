package sprint4.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class PlaceOrder {
    private WebDriver driver;
    public PlaceOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void findOrderButton(String orderButton)  {

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(orderButton)));

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(orderButton)));

        WebElement typedOrderButton = driver.findElement(By.xpath(orderButton));
        typedOrderButton.click();
    }
}
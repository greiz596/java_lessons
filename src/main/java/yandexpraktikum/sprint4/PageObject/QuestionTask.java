package sprint4.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class QuestionTask {
    private final WebDriver driver;

    public QuestionTask(WebDriver driver) {
        this.driver = driver;
    }

    private final List<By> questions = new ArrayList<>();
    private final List<By> answers = new ArrayList<>();

    public String findElements(int i) {

        //Выпадающий список
        questions.add(By.id("accordion__heading-0"));
        questions.add(By.id("accordion__heading-1"));
        questions.add(By.id("accordion__heading-2"));
        questions.add(By.id("accordion__heading-3"));
        questions.add(By.id("accordion__heading-4"));
        questions.add(By.id("accordion__heading-5"));
        questions.add(By.id("accordion__heading-6"));
        questions.add(By.id("accordion__heading-7"));

        //Текст в выпадающем списке
        answers.add(By.id("accordion__panel-0"));
        answers.add(By.id("accordion__panel-1"));
        answers.add(By.id("accordion__panel-2"));
        answers.add(By.id("accordion__panel-3"));
        answers.add(By.id("accordion__panel-4"));
        answers.add(By.id("accordion__panel-5"));
        answers.add(By.id("accordion__panel-6"));
        answers.add(By.id("accordion__panel-7"));

        driver.get("https://qa-scooter.praktikum-services.ru/");


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(questions.get(i)));

        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(driver.findElement(questions.get(i))));

        WebElement question = driver.findElement(questions.get(i));
        question.click();

        new WebDriverWait(driver, Duration.ofSeconds(2))
                .until(ExpectedConditions.visibilityOf(driver.findElement(answers.get(i))));

        String actualText = driver.findElement(answers.get(i)).getText();

        return actualText;
    }
}
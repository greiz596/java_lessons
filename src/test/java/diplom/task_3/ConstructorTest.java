package diplom.task_3;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pajeobject.HomePage;

import static constants.Food.*;

public class ConstructorTest extends BaseTest{
    @Test
    @DisplayName("Булки: переход к разделу по нажатию на «Булки»")
    public void openSectionBuns() {
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage();
        homePage.openSauces();
        homePage.openBuns();

        assertEquals(homePage.checkScrollBuns(), SEARCH_BUN);
    }

    @Test
    @DisplayName("Соусы: переход к разделу по нажатию на «Соусы»")
    public void openSectionSauces() {
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage();
        homePage.openSauces();

        assertEquals(homePage.checkScrollSauces(), SEARCH_SAUCE);
    }

    @Test
    @DisplayName("Начинки: переход к разделу по клику на «Начинки»")
    public void openSectionFillings() {
        HomePage homePage = new HomePage(driver);

        homePage.openHomePage();
        homePage.openFillings();

        assertEquals(homePage.checkScrollFillings(), SEARCH_FILLINGS);
    }
}

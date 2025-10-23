package sprint2;

import sprint2.model.Apple;
import sprint2.model.Food;
import sprint2.model.Meat;
import sprint2.model.constants.Colour;
import sprint2.service.ShoppingCart;

public class Main {
    public static void main(String[] args) {
        Food meat = new Meat(5, 100);
        Food appleRed = new Apple(10, 50, Colour.RED);
        Food appleGreen = new Apple(8, 60, Colour.GREEN);
        Food[] products = new Food[]{meat, appleRed, appleGreen};
        ShoppingCart shoppingCart = new ShoppingCart(products);

        System.out.println("Общая сумма товаров в корзине без скидки: " + shoppingCart.getAllSum() + " рублей.");
        System.out.println("Общая сумма товаров в корзине со скидкой: " + shoppingCart.getAllWithDiscount() + " рублей.");
        System.out.println("Общая сумма всех вегетарианских продуктов в корзине без скидки: " + shoppingCart.getAllVegetarianSum() + " рублей.");
    }
}
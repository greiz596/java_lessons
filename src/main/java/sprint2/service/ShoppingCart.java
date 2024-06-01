package sprint2.service;

import sprint2.model.Food;

public class ShoppingCart {
    private Food[] food;
    public ShoppingCart(Food[] food){
        this.food = food;
    };

    public double getAllSum () {
        double sum = 0.0;
        for (int i = 0; i <food.length; i++) {
            sum += (food[i].getAmount() * food[i].getPrice());
        }
        return sum;
    }

    public double getAllWithDiscount() {
        double sum = 0.0;
        for (int i = 0; i < food.length; i ++) {
            sum += (food[i].getAmount() * (food[i].getPrice() - (food[i].getPrice() * (food[i].getDiscount()/100))));
        }
        return sum;
    }

    public double getAllVegetarianSum() {
        double sum = 0.0;
        for (int i = 0; i < food.length; i++) {
            if (food[i].isVegetarian()) {
                sum += (food[i].getAmount() * food[i].getPrice());
            }
        }
        return sum;
    }
}
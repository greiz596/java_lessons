package sprint2.model;

import sprint2.model.constants.Colour;
import sprint2.model.constants.Discount;

public class Apple extends Food {
    private final String colour;

    public Apple(int amount, double price, String colour) {
        super(amount, price, true);
        this.colour = colour;
    }
    @Override
    public double getDiscount() {
        if (Colour.RED.equals(colour)) {
            return Discount.DISCOUNT_RED_APPLE;
        } else return 0.0;
    }
}
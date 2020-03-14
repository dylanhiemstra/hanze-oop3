package week2.PizzaStore;

public class PlainPizza implements Pizza {

    private PIZZA_SIZES size = PIZZA_SIZES.MEDIUM;

    public String getDescription() {
        return "a plain pizza";
    }

    public double getCost() {
        System.out.println("Cost of plain pizza: " + 4.00);
        return 4.00;
    }

    @Override
    public PIZZA_SIZES getSize() {
        return size;
    }

    @Override
    public void setSize(PIZZA_SIZES size) {
        this.size = size;
    }
}

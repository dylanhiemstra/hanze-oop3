package week2.PizzaStore;

enum PIZZA_SIZES {
    SMALL,
    MEDIUM,
    LARGE
}

public interface Pizza {
    String getDescription();
    double getCost();
    PIZZA_SIZES getSize();
    void setSize(PIZZA_SIZES size);
}

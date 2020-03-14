package week2.PizzaStore;

abstract class ToppingDecorator implements Pizza {
    protected Pizza tempPizza;
    
    public ToppingDecorator(Pizza newPizza) {
        tempPizza = newPizza;
    }
    
    public String getDescription() {
        return tempPizza.getDescription();
    }

    public double getCost() {
        return tempPizza.getCost();
    }

    @Override
    public PIZZA_SIZES getSize() {
        return tempPizza.getSize();
    }

    @Override
    public void setSize(PIZZA_SIZES size) {
        tempPizza.setSize(size);
    }
}

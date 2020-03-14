package week2.PizzaStore;

public class Mozzarella extends ToppingDecorator {

    public Mozzarella(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding mozzarella");
    }
    
    public String getDescription() {
        return tempPizza.getDescription() + " + mozzarella";
    }
    
    public double getCost() {
        switch (tempPizza.getSize()) {
            case SMALL:
                System.out.println("Cost of mozzarella on small pizza: " + .50);
                return tempPizza.getCost() + .50;
            case MEDIUM:
                System.out.println("Cost of mozzarella on medium pizza: " + .60);
                return tempPizza.getCost() + .60;
            default:
                System.out.println("Cost of mozzarella on large pizza: " + .80);
                return tempPizza.getCost() + .80;
        }
    }
}

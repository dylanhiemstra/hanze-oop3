package week2.PizzaStore;

public class TomatoSauce extends ToppingDecorator {

    public TomatoSauce(Pizza newPizza) {
        super(newPizza);
        System.out.println("Adding sauce");
    }
    
    public String getDescription() {
        return tempPizza.getDescription() + " + tomato sauce";
    }
    
    public double getCost() {
        switch (tempPizza.getSize()) {
            case SMALL:
                System.out.println("Cost of sauce on small pizza: " + .35);
                return tempPizza.getCost() + .35;
            case MEDIUM:
                System.out.println("Cost of sauce on medium pizza: " + .40);
                return tempPizza.getCost() + .40;
            default:
                System.out.println("Cost of sauce on large pizza: " + .60);
                return tempPizza.getCost() + .60;
        }
    }
}

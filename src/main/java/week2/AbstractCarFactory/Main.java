package week2.AbstractCarFactory;

public class Main {
    public static void main(String[] args) {
        DealerShip randomDealerOne = new RandomDealer();
        DealerShip randomDealerTwo = new RandomDealer();

        randomDealerOne.setFactory(new BMWFactory());
        randomDealerTwo.setFactory(new OpelFactory());

        randomDealerOne.getFactory().makePickUp();
        randomDealerTwo.getFactory().makeSedan();
    }
}

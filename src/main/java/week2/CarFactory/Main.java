package week2.CarFactory;

import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {
        CarFactory sedanFactory = new SedanFactory();
        CarFactory pickUpFactory = new PickupFactory();
        CarFactory stationWagonFactory = new StationWagonFactory();
        CarFactory SUVFactory = new SUVFactory();

        for (int i=0; i<20; i++){
            java.util.Random rand = new java.util.Random();
            int r1 = rand.nextInt(4) + 1;
            Car car;
            switch (r1) {
                case 1:
                    car = sedanFactory.makeCar();
                    break;
                case 2:
                    car = pickUpFactory.makeCar();
                    break;
                case 3:
                    car = stationWagonFactory.makeCar();
                    break;
                default:
                    car = SUVFactory.makeCar();
                    break;
            }
        
            // your code
            System.out.println("Type of car is " + car.getClass().getSimpleName() + " with price " + car.getCost());
        }
    }
}

package week2.CarFactory;

// abstract factory
interface CarFactory {
    Car makeCar();
}

// concrete factories
class SedanFactory implements CarFactory {
    @Override
    public Car makeCar() {
        System.out.println("* Let's make a Sedan *");
        return new Sedan();
    }
}

class PickupFactory implements CarFactory {
    @Override
    public Car makeCar() {
        System.out.println("* Let's make a PickUp *");
        return new PickUp();
    }
}

class StationWagonFactory implements CarFactory {
    @Override
    public Car makeCar() {
        System.out.println("* Let's make a StationWagon *");
        return new StationWagon();
    }
}

class SUVFactory implements CarFactory {
    @Override
    public Car makeCar() {
        System.out.println("* Let's make a SUV *");
        return new SUV();
    }
}
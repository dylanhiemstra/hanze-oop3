package week2.AbstractCarFactory;

interface DealerShip {
    void setFactory(CarFactory carFactory);
    CarFactory getFactory();
}

class RandomDealer implements DealerShip {
    private CarFactory factory;

    public void setFactory(CarFactory carFactory) {
        this.factory = carFactory;
    }

    public CarFactory getFactory() {
        return this.factory;
    }
}
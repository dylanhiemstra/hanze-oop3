package week2.AbstractCarFactory;

public interface Car {
    double getPrice();
}

class RandomCar implements Car {
    private double price;

    RandomCar(double price) {
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
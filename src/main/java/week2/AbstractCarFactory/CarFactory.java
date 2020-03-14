package week2.AbstractCarFactory;

public interface CarFactory {
     Car makePickUp();
     Car makeSedan();
     Car makeStationWagon();
     Car makeSUV();
}

class BMWFactory implements CarFactory {
    @Override
    public Car makePickUp() {
        return new RandomCar(1000);
    }

    @Override
    public Car makeSedan() {
        return new RandomCar(2000);
    }

    @Override
    public Car makeStationWagon() {
        return new RandomCar(3000);
    }

    @Override
    public Car makeSUV() {
        return new RandomCar(4000);
    }
}

class OpelFactory implements CarFactory {
    @Override
    public Car makePickUp() {
        return new RandomCar(5000);
    }

    @Override
    public Car makeSedan() {
        return new RandomCar(6000);
    }

    @Override
    public Car makeStationWagon() {
        return new RandomCar(7000);
    }

    @Override
    public Car makeSUV() {
        return new RandomCar(8000);
    }
}
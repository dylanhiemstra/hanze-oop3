package week2.CarFactory;

// abstract product
interface Car {
    public int getCost();
    public String getExtras();
}

// the concrete products
class Sedan implements Car {

    @Override
    public int getCost() {
        return 30000;
    }

    @Override
    public String getExtras() {
        return "";
    }
}

class StationWagon implements Car {
    @Override
    public int getCost() {
        return 40000;
    }

    @Override
    public String getExtras() {
        return "";
    }
}

class PickUp implements Car {

    @Override
    public int getCost() {
        return 50000;
    }

    @Override
    public String getExtras() {
        return "";
    }
}

class SUV implements Car {

    @Override
    public int getCost() {
        return 60000;
    }

    @Override
    public String getExtras() {
        return "";
    }
}
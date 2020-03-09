package week2.StockExchange;

import java.util.ArrayList;

public class StockGenerator implements Subject {
    
    private ArrayList<Observer> observers;
    
    public StockGenerator(){
        observers = new ArrayList<>();
    }
    
    public void register(Observer newObserver) {
        observers.add(newObserver);
    }

    public void unregister(Observer deleteObserver) {
        observers.remove(deleteObserver);
    }

    public void notifyObserver(String stock, float price) {
        // cycle through all observers and notifies them of price changes
        observers.forEach(observer -> observer.update(stock, price));
    }
}

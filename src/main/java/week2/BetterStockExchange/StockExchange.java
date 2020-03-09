package week2.BetterStockExchange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StockExchange {
    public static String[] stocks = new String[] { "GOOG", "AAPL", "IBM"};

    public static void main(String[] args) {
        StockObservable stock =  new StockObservable();
        new Thread(stock).start();

        PriceObserver IBMPrice = new PriceObserver("IBM");
        PriceObserver AAPLPrice = new PriceObserver("AAPL");
        PriceObserver GOOGPrice = new PriceObserver("GOOG");

        stock.register(IBMPrice);
        stock.register(AAPLPrice);
        stock.register(GOOGPrice);
    }
}

class PriceObserver implements Observer<HashMap<String, Float>> {
    private String stock;

    PriceObserver(String stock) {
        this.stock = stock;
    }

    @Override
    public void update(HashMap<String, Float> prices) {
        System.out.println(stock + " = " + prices.get(stock));
    }
}

class StockObservable extends Observable<HashMap<String, Float>> implements Runnable {
    private HashMap<String, Float> stocks = new HashMap<>();

    StockObservable() {
        stocks.put("GOOG", 530f);
        stocks.put("AAPL", 1042f);
        stocks.put("IBM", 235f);
    }

    @Override
    public void run() {
        while(true) {
            try {
                for(String stock : StockExchange.stocks) {
                    float randNum = (float)(6*Math.random() - 3);
                    float newPrice = stocks.get(stock) + randNum;
                    stocks.put(stock, newPrice);

                    notifyObservers(stocks);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

interface Observer<T> {
    void update(T value);
}

abstract class Observable<T> {
    private List<Observer<T>> observers = new ArrayList<>();

    public void register(Observer<T> observer) {
        observers.add(observer);
    }

    public void unregister(Observer<T> observer) {
        observers.remove(observer);
    }

    protected void notifyObservers(T value) {
        for(Observer<T> observer : observers) {
            observer.update(value);
        }
    }
}
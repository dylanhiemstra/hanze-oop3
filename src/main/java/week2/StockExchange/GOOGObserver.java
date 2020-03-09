package week2.StockExchange;

import java.text.DecimalFormat;

// concrete Observer that is monitoring changes in the subject
public class GOOGObserver implements Observer {

    private int observerNr;
    private int step;

    private Subject stockGenerator;

    public GOOGObserver(Subject stockGenerator) {
        this.stockGenerator = stockGenerator;
        this.observerNr = ObserverCounter.getNextValue();
    }

    public void update(String stock, float price) {
        if(stock.equals("GOOG")) {
            printPrice(price);
        }
    }

    public void printPrice(float price){
        // formats decimals to two places
        DecimalFormat df = new DecimalFormat("###,###.##");
        System.out.println("GOOG = " + df.format(price));
    }
}
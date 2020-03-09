package week2.StockExchange;

import java.text.DecimalFormat;

// concrete Observer that is monitoring changes in the subject
public class IBMObserver implements Observer {
    
    private int observerNr;
    private int step;
    
    private Subject stockGenerator;
    
    public IBMObserver(Subject stockGenerator) {
        this.stockGenerator = stockGenerator;
        this.observerNr = ObserverCounter.getNextValue();
    }
    
    public void update(String stock, float price) {
        if(stock.equals("IBM")) {
            printPrice(price);
        }
    }
    
    public void printPrice(float price){
        // formats decimals to two places
        DecimalFormat df = new DecimalFormat("###,###.##");
        System.out.println("IBM = " + df.format(price));
    }
}
package week2.StockExchange;

public interface Observer {

    // update method is called when the Subject changes
    public void update(String stock, float price);
}

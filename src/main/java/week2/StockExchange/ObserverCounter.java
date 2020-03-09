package week2.StockExchange;

class ObserverCounter {
   
    private static int counter;
    public static int getNextValue()
    {
        return ++counter;
    }
}

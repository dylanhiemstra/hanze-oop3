package week2.StockExchange;

import javafx.application.Application;
import javafx.stage.Stage; 

public class App extends Application { 

    public static void main(String[] args) {
        // create the Subject
        StockGenerator stockGen = new StockGenerator();

        // create 3 runnables, pass them Subject and initial stock proces
        Runnable genIBM = new UpdateStock(stockGen, "IBM", 97.0f);
        Runnable genAAPL = new UpdateStock(stockGen, "AAPL", 174.6f);
        Runnable genGOOG = new UpdateStock(stockGen, "GOOG", 267.4f);

        // create Observers and pass Subject
        Observer ibmObserver = new IBMObserver(stockGen);
        Observer aaplObserver = new AAPLObserver(stockGen);
        Observer googObserver = new GOOGObserver(stockGen);

        stockGen.register(ibmObserver);
        stockGen.register(aaplObserver);
        stockGen.register(googObserver);

        // and start 3 threads
        new Thread(genIBM).start();
        new Thread(genAAPL).start();
        new Thread(genGOOG).start();
    }

    @Override 
    public void start(Stage stage) {

    }
}

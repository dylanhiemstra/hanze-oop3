package week1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.TextArea;


public class TaskThreadDemo extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        TextArea textArea = new TextArea();
        VBox vBox = new VBox(textArea);

        Scene scene = new Scene(vBox, 200, 100);
        stage.setScene(scene);
        stage.show();


        // Create tasks
        Runnable printA = new PrintChar('a', 100, textArea);
        Runnable printB = new PrintChar('b', 100, textArea);
        Runnable print100 = new PrintNum(100, textArea);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

// The task for printing a specified character in specified times
class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The times to repeat
    private TextArea textArea;

    /** Construct a task with specified character and number of
     *  times to print the character
     */
    public PrintChar(char c, int t, TextArea textArea) {
        charToPrint = c;
        times = t;
        this.textArea = textArea;
    }

    /** Override the run() method to tell the system
     *  what the task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            Platform.runLater(() -> textArea.appendText(String.valueOf(charToPrint)));
        }
    }
}

// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;
    private TextArea textArea;

    /** Construct a task for printing 1, 2, ... i */
    public PrintNum(int n, TextArea textArea) {
        lastNum = n;
        this.textArea = textArea;
    }

    /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            int finalI = i;
            Platform.runLater(() -> textArea.appendText(String.valueOf(" " + finalI)));
        }
    }
}
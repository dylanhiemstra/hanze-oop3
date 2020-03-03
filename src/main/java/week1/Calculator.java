package week1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Calculator extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/calculator.fxml"));

        Scene scene = new Scene(root);
        GridPane numbersPane = (GridPane) scene.lookup("#NumbersPane");
        createNumberButtons(numbersPane);

        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.show();
    }

    private void createNumberButtons(GridPane container) {
        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                Button button = new Button();
                button.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
                container.add(button, x, y);
            }
        }

        Button button = new Button();
        container.add(button, 1, 3);
    }

    private void createOperationsButtons(GridPane container) {
        Button addButton = new Button();
        container.add(addButton, 0, 0);

        Button subtractButton = new Button();
        container.add(subtractButton, 0, 1);

        Button multiplyButton = new Button();
        container.add(multiplyButton, 0, 2);

        Button divisionButton = new Button();
        container.add(divisionButton, 0, 3);
    }
}

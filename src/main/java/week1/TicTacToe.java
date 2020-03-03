package week1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

public class TicTacToe extends Application {
    private static Random random = new Random();

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        GridPane pane = new GridPane();

        applyConstrains(pane);
        fillIn(pane);

        Scene scene = new Scene(pane, 105, 120);

        stage.setTitle("TIC TAC TOE");
        stage.setScene(scene);
        stage.show();
    }

    private void fillIn(GridPane pane) throws FileNotFoundException {
        Image imageX = new Image(new FileInputStream("/home/dylan/IdeaProjects/HanzeOOP3/x.gif"));
        Image imageO = new Image(new FileInputStream("/home/dylan/IdeaProjects/HanzeOOP3/o.gif"));


        for(int x = 0; x < 3; x++) {
            for(int y = 0; y < 3; y++) {
                // Should this column have a X or O?
                if(random.nextBoolean()) {
                    ImageView image = new ImageView(random.nextBoolean() ? imageX : imageO);
                    pane.add(image, x, y);
                }
            }
        }
    }

    /**
     * Apply constrains to the pane
     *
     * @param pane
     */
    private void applyConstrains(GridPane pane) {
        ColumnConstraints columnConstraints = new ColumnConstraints();
        columnConstraints.setPrefWidth(35);

        RowConstraints rowConstraints = new RowConstraints();
        rowConstraints.setPrefHeight(40);

        pane.getColumnConstraints().add(columnConstraints);
        pane.getRowConstraints().add(rowConstraints);
    }
}

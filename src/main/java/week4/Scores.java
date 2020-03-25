package week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Scores {
    public static void main(String[] args) {
        new Scores().readScores();
    }

    public void readScores() {
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter file name");
        String fileName = in.next();
        Scanner file;

        try {
            file = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("That file does not exist!");
            return;
        }

        int total = 0;
        int amount = 0;
        while (file.hasNext()) {
            total += Integer.parseInt(file.next());
            amount++;
        }

        System.out.println("Total = " + total + " Average =" + total / amount);
    }
}

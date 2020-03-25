package week3.ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // create the context
        ATM atm = new ATM();
        atm.setState(new IdleState());

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Type a number for an event:");
            System.out.println("1. Insert card");
            System.out.println("2. Enter PIN code");
            System.out.println("3. Enter amount");
            System.out.println("4. I want my money honey");
            System.out.println();

            int number = input.nextInt();

            switch (number) {
                case 1:
                    atm.insertCard();
                    break;
                case 2:
                    atm.insertPin();
                    break;
                case 3:
                    atm.requestAmount();
                    break;
                case 4:
                    atm.ejectCard();
                    break;
                default:
                    System.out.println("No idea what you want mate");
            }
        }
    }
}
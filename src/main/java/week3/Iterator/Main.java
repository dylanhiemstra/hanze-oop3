package week3.Iterator;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push("kwik");
        stack.push("kwek");
        stack.push("kwak");

        // your code
        for(String item : stack) {
            System.out.println(item);
        }
    }
}

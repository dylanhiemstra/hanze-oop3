package week4.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket server = new Socket("localhost", 8000);

        DataInputStream inputStream = new DataInputStream(server.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(server.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String text = inputStream.readUTF();
                    System.out.println("SERVER SAYS: " + text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Scanner me = new Scanner(System.in);

        while (true) {
            String text = me.next();
            outputStream.writeUTF(text);
        }
    }
}

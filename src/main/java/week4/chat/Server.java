package week4.chat;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8000);
        System.out.println("Waiting");
        Socket otherPerson = server.accept();
        System.out.println("WOW SOME ONE CONNECTED");

        DataInputStream inputStream = new DataInputStream(otherPerson.getInputStream());
        DataOutputStream outputStream = new DataOutputStream(otherPerson.getOutputStream());

        new Thread(() -> {
            while (true) {
                try {
                    String text = inputStream.readUTF();
                    System.out.println("OTHER GUY SAYS: " + text);
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

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 3456);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {
            out.println("WITAJ, SERWERZE!");
            System.out.println("WYSŁANO WIADOMOŚĆ DO SERWERA.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

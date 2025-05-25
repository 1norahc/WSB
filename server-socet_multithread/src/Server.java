import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(3456)) {
            System.out.println("Serwer oczekuje na połączenie...");
            while (true) {
                Socket socket = serverSocket.accept();
                // Uruchamiamy nowy wątek do obsługi klienta
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Klasa obsługująca klienta w osobnym wątku
class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("Start obsługi klienta w wątku: " + Thread.currentThread().getName());
        try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message = in.readLine();
            System.out.println("Otrzymano wiadomość: " + message + " (wątek: " + Thread.currentThread().getName() + ")");
            // symulacja długiej pracy
            Thread.sleep(2000);
            System.out.println("Koniec obsługi klienta w wątku: " + Thread.currentThread().getName());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException ignored) {
            }
        }
    }
}
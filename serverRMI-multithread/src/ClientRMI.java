import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) {
        int numberOfThreads = 5; // liczba równoczesnych wywołań
        for (int i = 0; i < numberOfThreads; i++) {
            new Thread(() -> {
                try {
                    System.out.println("Wątek " + Thread.currentThread().getName() + " próbuje wywołać sayHello()");
                    Hello obj = (Hello) Naming.lookup("rmi://localhost/Hello");
                    String response = obj.sayHello();
                    System.out.println("Odpowiedz z serwera (wątek " + Thread.currentThread().getName() + "): " + response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}

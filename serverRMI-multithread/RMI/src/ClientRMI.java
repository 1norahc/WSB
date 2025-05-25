import java.rmi.Naming;

public class ClientRMI {
    public static void main(String[] args) {
        try {
            Hello obj = (Hello) Naming.lookup("RMI://localhost/Hello");
            String response = obj.sayHello();
            System.out.println("Odpowiedz z serwera: " + response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

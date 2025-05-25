import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServerRMI {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099); // Uruchamiamy registry RMI
            HelloImpl obj = new HelloImpl();
            Naming.rebind("Hello", obj);
            System.out.println("Serwer RMI działa...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

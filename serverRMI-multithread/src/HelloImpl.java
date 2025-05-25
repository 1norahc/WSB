import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class HelloImpl extends UnicastRemoteObject implements Hello {
    protected HelloImpl() throws RemoteException {
        super();
    }

    @Override
    public String sayHello() throws RemoteException {
        String threadName = Thread.currentThread().getName();
        System.out.println("sayHello() wywołane przez wątek: " + threadName);
        try {
            // symulacja dłuższej pracy
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Witaj z RMI! (obsłużone przez: " + threadName + ")";
    }
}

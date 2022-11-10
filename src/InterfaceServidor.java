import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceServidor extends Remote {
    void registro(InterfaceCliente cliente) throws RemoteException;
    void mensaje(String mensaje) throws RemoteException;
}

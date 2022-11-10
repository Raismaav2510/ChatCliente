import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceCliente extends Remote {
    void mensajeCliente(String mensaje) throws RemoteException;
}

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;

public class ImplementacionCliente extends UnicastRemoteObject implements InterfaceCliente, Runnable {
    InterfaceServidor servidor;
    public String nombre = "";

    ImplementacionCliente(String nombre, InterfaceServidor servidor) throws RemoteException {
        this.nombre = nombre;
        this.servidor = servidor;
        servidor.registro(this);
    }

    public void mensajeCliente(String mensaje) throws RemoteException {
        System.err.println(mensaje);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String mensaje;

        while (true) {
            mensaje = scanner.nextLine();
            try {
                servidor.mensaje(nombre + ": " + mensaje);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

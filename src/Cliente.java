import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public static void main(String[] args) {
        try {
            String ipLocal = JOptionPane.showInputDialog("Ingresa la dirección IP de este equipo");
            String ipServidor = JOptionPane.showInputDialog("Ingresa la dirección IP del servidor");
            String nombre = JOptionPane.showInputDialog("Ingresa tu nombre");
            System.setProperty("java.rmi.server.hostname", ipLocal);
            Registry registry = LocateRegistry.getRegistry(ipServidor, 8080);
            InterfaceServidor servidor = (InterfaceServidor) registry.lookup("Chat");
            new Thread(new ImplementacionCliente(nombre, servidor)).start();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }
}
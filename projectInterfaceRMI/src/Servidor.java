import java.io.FileNotFoundException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
	public static void main(String[] args) throws FileNotFoundException {
		String host;
		int puerto = 5055;
		try {
			host = InetAddress.getLocalHost().getHostAddress();
		} catch (UnknownHostException e) {
			System.out.println("No se ha podido obtener la dirección IP");
			System.out.println(e.getMessage());
			return;
		}
		try {
			Registry registro = LocateRegistry.createRegistry(puerto);
			EquiposRMI equipo = new EquiposRMI();
			registro.rebind("miEquipo", equipo);
			System.out.println("Servicio registrado en host " + host + " y puerto " + puerto);
		} catch (RemoteException e) {
			System.out.println("No se ha podido registrar el servicio");
			System.out.println(e.getMessage());
		}
	}
}
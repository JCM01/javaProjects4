import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		Productos productos = new Productos();
		System.out.println("APLICACIÓN DE SERVIDOR PROVEEDORA DE CANCIONES");
		System.out.println("-------------------------------------------------");
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("172.19.160.1", 2001);
			servidor.bind(direccion);
			System.out.println("Dirección IP: " + direccion.getAddress());
			while (true) {
				Socket enchufeAlCliente = servidor.accept();
				System.out.println("Comunicación entrante");
				new HiloEscuchador(enchufeAlCliente, productos);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) {
		Canciones canciones = new Canciones();
		System.out.println("APLICACI�N DE SERVIDOR PROVEEDORA DE CANCIONES");
		System.out.println("-------------------------------------------------");
		try {
			ServerSocket servidor = new ServerSocket();
			InetSocketAddress direccion = new InetSocketAddress("192.168.34.41", 2000);
			servidor.bind(direccion);
			System.out.println("Direcci�n IP: " + direccion.getAddress());
			while (true) {
				Socket enchufeAlCliente = servidor.accept();
				System.out.println("Comunicaci�n entrante");
				new HiloEscuchador(enchufeAlCliente, canciones);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
	private static ObjectInputStream entrada;
	private static ObjectOutputStream salida;

	public static void main(String[] args) throws ClassNotFoundException {
		System.out.println(" APLICACIÓN CLIENTE");
		System.out.println("-----------------------------------");
		Scanner lector = new Scanner(System.in);
		try {
			Socket cliente = new Socket();
			InetSocketAddress direccionServidor = new InetSocketAddress("192.168.34.41", 2001);
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			// Conectamos con el servidor.
			System.out.println("Comunicación establecida con el servidor");

			salida = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new ObjectInputStream(cliente.getInputStream());

			String peticion = "";
			while (!peticion.equals("FIN")) {
				System.out.println("1. Un solo producto aleatorio");
				System.out.println("2. Productos por categoría");
				System.out.println("3. Productos por nombre");
				System.out.println("4. Todos los productos");
				System.out.println("5. Desconectar");
				System.out.println("¿Qué opción eliges (1-5)?");
				peticion = lector.nextLine();

				switch (peticion) {
				case "1":
					salida.writeObject("1-nada");
					Producto c = (Producto) entrada.readObject();
					System.out.println(c);
					break;
				case "2":
					System.out.println("¿Id de categoria (1-8)?");
					String grupo = lector.nextLine();
					salida.writeObject("2-" + grupo);
					ArrayList<Producto> canciones = (ArrayList<Producto>) entrada.readObject();
					for (Producto ca : canciones) {
						System.out.println(ca);
					}
					break;
				case "3":
					System.out.println("¿Nombre del producto?");
					String nombre = lector.nextLine();
					salida.writeObject("3-" + nombre);
					ArrayList<Producto> canciones2 = (ArrayList<Producto>) entrada.readObject();
					for (Producto ca : canciones2) {
						System.out.println(ca);
					}
					break;
				case "4":
					salida.writeObject("4-nada");
					ArrayList<Producto> canciones3 = (ArrayList<Producto>) entrada.readObject();
					for (Producto ca : canciones3) {
						System.out.println(ca);
					}
					break;
				case "5":
					peticion = "FIN";
					break;
				default:
					System.out.println("Opción incorrecta");
				}
			}
			entrada.close();
			salida.close();
			cliente.close();
			System.out.println("Comunicación cerrada");
		} catch (UnknownHostException e) {
			System.out.println("No se puede establecer comunicación con el servidor");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("Error de E/S");
			System.out.println(e.getMessage());
		}
		lector.close();
	}
}

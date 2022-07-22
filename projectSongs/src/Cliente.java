
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
			InetSocketAddress direccionServidor = new InetSocketAddress("192.168.34.41", 2000);
			System.out.println("Esperando a que el servidor acepte la conexión");
			cliente.connect(direccionServidor);
			// Conectamos con el servidor.
			System.out.println("Comunicación establecida con el servidor");

			salida = new ObjectOutputStream(cliente.getOutputStream());
			entrada = new ObjectInputStream(cliente.getInputStream());

			String peticion = "";
			while (!peticion.equals("5")) {
				System.out.println("1. Una sola canción");
				System.out.println("2. Canciones de un grupo");
				System.out.println("3. Canciones por título");
				System.out.println("4. Todas las canciones de la lista");
				System.out.println("5. Desconectar");
				String texto = lector.nextLine();
				int textoTodo = Integer.parseInt(texto);

				switch (textoTodo) {
				case 1:

					salida.writeObject("1" + "-" + "cancion");
					Object m1 = entrada.readObject();
					System.out.println(m1);

					break;
				case 2:
					System.out.println("Dime el grupo de la canción");
					String g = lector.nextLine();
					salida.writeObject("2" + "-" + g);

					Object m2 = entrada.readObject();
					ArrayList c2 = (ArrayList) m2;
					for (int i = 0; i < c2.size(); i++) {

						System.out.println(c2.get(i));
					}

					break;
				case 3:

					System.out.println("Dime el titulo de la cancion");
					String t = lector.nextLine();
					salida.writeObject("3" + "-" + t);

					Object m3 = entrada.readObject();
					ArrayList c3 = (ArrayList) m3;
					for (int i = 0; i < c3.size(); i++) {
						System.out.println(c3.get(i));

					}
					break;

				case 4:
					salida.writeObject("4" + "-" + "cancion");
					Object m4 = entrada.readObject();
					ArrayList c4 = (ArrayList) m4;
					for (int i = 0; i < c4.size(); i++) {

						System.out.println(c4.get(i));

					}
					break;

				case 5:

					entrada.close();
					salida.close();
					cliente.close();
					peticion = "FIN";
					System.out.println("Comunicación cerrada");

				default:
					System.out.println("Esa opcion no existe");
				}

			}

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
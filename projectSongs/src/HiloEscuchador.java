
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class HiloEscuchador implements Runnable {
	private Thread hilo;
	private static int numCliente = 0;
	private Socket enchufeAlCliente;
	private Canciones canciones;
	private ObjectInputStream entrada;
	private ObjectOutputStream salida;
	private Canciones misCanciones = new Canciones();

	public HiloEscuchador(Socket cliente, Canciones canciones) throws IOException {
		numCliente++;
		hilo = new Thread(this, "Cliente" + numCliente);
		this.enchufeAlCliente = cliente;
		this.canciones = canciones;
		hilo.start();
	}

	@Override
	public void run() {
		System.out.println("Estableciendo comunicaci�n con " + hilo.getName());
		try {
			salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());
			entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
			Canciones canciones = new Canciones();
			String peticion = "";

			do {
				// Recoge la petici�n del cliente como un objeto String.
				// La comunicaci�n con el cliente se mantendr� hasta que
				// el cliente env�e la palabra "FIN".

				peticion = (String) entrada.readObject();

				String[] splited = peticion.split("-");
				String n = (String) (splited[0]);

				Integer numEntero = Integer.parseInt(n);

				String textoCanciones = (String) (splited[1]);

				if (peticion.trim().equals("FIN")) {
					salida.writeObject("Hasta pronto, gracias por establecer conexi�n");
					System.out.println(hilo.getName() + " ha cerrado la comunicaci�n");
				} else {

					switch (numEntero) {
					case 1:

						Cancion unaCancion = misCanciones.cancionAzar();
						salida.writeObject(unaCancion.toString());
						break;
					case 2:
						ArrayList<Cancion> buscarCancion = misCanciones.getCancionesGrupo(textoCanciones);

						salida.writeObject(buscarCancion);
						break;

					case 3:
						ArrayList<Cancion> buscarTitulo = misCanciones.getCancionesTitulo(textoCanciones);

						salida.writeObject(buscarTitulo);
						break;
					case 4:

						ArrayList<Cancion> listaCanciones = misCanciones.getCancionesTitulo("");

						salida.writeObject(listaCanciones);
						break;

					case 5:
						salida.writeObject("Hasta luego, se ha cerrado la conexi�n");

						System.out.println(hilo.getName() + " ha cerrado la comunicaci�n");

						break;
					}
					// Atiende aqu� la petici�n del cliente
					// ************************************
					// Debes enviar al cliente una canci�n o un ArrayList de canciones
					// lo que env�es ir� en funci�n de la petici�n recibida.

				}
			} while ((!peticion.trim().equals("5")));
			entrada.close();
			salida.close();
			enchufeAlCliente.close();
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
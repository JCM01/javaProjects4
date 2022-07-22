
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
		System.out.println("Estableciendo comunicación con " + hilo.getName());
		try {
			salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());
			entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
			Canciones canciones = new Canciones();
			String peticion = "";

			do {
				// Recoge la petición del cliente como un objeto String.
				// La comunicación con el cliente se mantendrá hasta que
				// el cliente envíe la palabra "FIN".

				peticion = (String) entrada.readObject();

				String[] splited = peticion.split("-");
				String n = (String) (splited[0]);

				Integer numEntero = Integer.parseInt(n);

				String textoCanciones = (String) (splited[1]);

				if (peticion.trim().equals("FIN")) {
					salida.writeObject("Hasta pronto, gracias por establecer conexión");
					System.out.println(hilo.getName() + " ha cerrado la comunicación");
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
						salida.writeObject("Hasta luego, se ha cerrado la conexión");

						System.out.println(hilo.getName() + " ha cerrado la comunicación");

						break;
					}
					// Atiende aquí la petición del cliente
					// ************************************
					// Debes enviar al cliente una canción o un ArrayList de canciones
					// lo que envíes irá en función de la petición recibida.

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
import java.io.IOException;

import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;

import java.net.Socket;

import java.util.ArrayList;

public class HiloEscuchador implements Runnable {

	private Thread hilo;

	private static int numCliente = 0;

	private Socket enchufeAlCliente;

	private Productos productos;

	private ObjectInputStream entrada;

	private ObjectOutputStream salida;

	public HiloEscuchador(Socket cliente, Productos productos) throws IOException {

		numCliente++;

		hilo = new Thread(this, "Cliente" + numCliente);

		this.enchufeAlCliente = cliente;

		this.productos = productos;

		hilo.start();

	}

	@Override

	public void run() {

		System.out.println("Estableciendo comunicación con " + hilo.getName());

		try {

			salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());

			entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());

			String peticion = "";

			do {

			

				peticion = (String) entrada.readObject();

				String[] partes = peticion.split("-");

				String numero = partes[0];

				String filtro = "";

				if (partes.length >= 2)
					filtro = partes[1];

				if (peticion.trim().equals("FIN")) {

					salida.writeObject("Hasta pronto, gracias por establecer conexión");

					System.out.println(hilo.getName() + " ha cerrado la comunicación");

				} else {

					switch (numero) {

					case "1":

						Producto c = productos.productoAzar();

						salida.writeObject(c);

						break;

					case "2":

						ArrayList<Producto> productos1 =

								productos.getProductosGrupo(filtro);

						salida.writeObject(productos1);

						break;

					case "3":

						ArrayList<Producto> productos2 =

								productos.getProductosTitulo(filtro);

						salida.writeObject(productos2);

						break;

					case "4":

						salida.writeObject(productos.getListaDistribucion());

						break;

					}

				}

			} while ((!peticion.trim().equals("FIN")));

			entrada.close();

			salida.close();

			enchufeAlCliente.close();

		} catch (IOException | ClassNotFoundException e) {

			System.out.println(e.getMessage());

		}

	}

}
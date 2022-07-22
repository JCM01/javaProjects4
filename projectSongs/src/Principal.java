
import java.util.ArrayList;

public class Principal {

	public static void main(String[] args) {
		Canciones misCanciones = new Canciones();
		
		// Obtenemos la tercera canción de la lista.
		Cancion unaCancion = misCanciones.getListaDistribucion().get(2);
		System.out.println(unaCancion.toString());

		// Obtenemos una canción al azar.
		unaCancion = misCanciones.cancionAzar();
		System.out.println(unaCancion.toString());
		
		// Obtenemos las canciones de Queen.
		System.out.println("LAS CANCIONES DE QUEEN");
		ArrayList<Cancion> buscar = misCanciones.getCancionesGrupo("Queen");
		for (Cancion c : buscar) {
			System.out.println(c);
		}

		System.out.println("LAS CANCIONES CON TITULO QUE CONTENGA MA");
		buscar = misCanciones.getCancionesTitulo("ma");
		for (Cancion c : buscar) {
			System.out.println(c);
		}
	}

}
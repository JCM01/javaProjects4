import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) {
		Registry registry;
		Scanner lector = new Scanner(System.in);
		try {
			registry = LocateRegistry.getRegistry("192.168.1.128", 5055);
			System.out.println("Hemos obtenido el registro");
			EquipoInterfaceRMI equipos = (EquipoInterfaceRMI) registry.lookup("miEquipo");
			System.out.println("Hemos obtenido el objeto remoto");
			System.out.println(); // Retorno de carro.
			String buscado;
			String opcion;
			do {
				escribirMenu();
				opcion = lector.nextLine().toUpperCase();
				switch (opcion) {
				case "1":
					System.out.println("Escribe el nombre del equipo: ");
					buscado = lector.nextLine();
					System.out.println(equipos.buscarNombre(buscado));
					break;
				case "2":
					System.out.println("Escribe el nombre de la competición: ");
					buscado = lector.nextLine();
					System.out.println(equipos.Competicion(buscado));
					break;
				case "3":
					System.out.println("Equipos con mas tarjetas amarillas de : ");
					buscado = lector.nextLine();
					int amarillas = Integer.parseInt(buscado);
					System.out.println(equipos.tarjetasAmarillas(amarillas));
					break;
				case "4":
					System.out.println("Equipos con mas tarjetas rojas de :");
					buscado = lector.nextLine();
					int rojas = Integer.parseInt(buscado);
					System.out.println(equipos.tarjetasRojas(rojas));
					break;
				case "5":
					System.out.println("Escribe el número de goles que quieres y te saldrán los equipos con más de esos goles: ");
					buscado = lector.nextLine();
					int goles = Integer.parseInt(buscado);
					System.out.println(equipos.Goles(goles));
					break;
				case "6":
					System.out.println("Programa finalizado");
					break;
				default:
					System.out.println("Opción incorrecta");
				}
			} while (!opcion.equals("6"));
		} catch (RemoteException | NotBoundException e) {
			System.out.println(e.getMessage());
		}
		lector.close();
	}

	private static void escribirMenu() {
		System.out.println();
		System.out.println("Búsqueda de equipos de fútbol");
		System.out.println("--------------------------");
		System.out.println("1 = Nombre del Equipo");
		System.out.println("2 = Nombre de la Competición");
		System.out.println("3 = Equipo con tarjetas Amarillas de: ");
		System.out.println("4 = Equipo con mas tarjetas rojas de: ");
		System.out.println("5 = Ver equipos que tienen más goles de :");
		System.out.println("6 = Terminar Programa");
		System.out.println("--------------------------");
		System.out.println("Elige una opción");
	}
}

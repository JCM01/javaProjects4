import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class EquiposRMI extends UnicastRemoteObject implements EquipoInterfaceRMI {
	private static final long serialVersionUID = -4817856459999901795L;
	private ArrayList<Equipo> equipos;
	
	public EquiposRMI() throws RemoteException, FileNotFoundException {
		equipos = new ArrayList<Equipo>();
		equipos.add(new Equipo("Manchester City", "Premier League",  83,  46, 2));
		equipos.add(new Equipo("Bayern Munich", "Bundesliga",  99,  44, 3));
		equipos.add(new Equipo("Paris Saint-Germain", "Ligue 1",  86,  73, 7));
		equipos.add(new Equipo("Barcelona", "LaLiga",  85,  68, 2));
		equipos.add(new Equipo("Real Madrid", "LaLiga",  67,  57, 2));
		equipos.add(new Equipo("Manchester United", "Premier League",  73,  64, 1));
		equipos.add(new Equipo("Juventus", "Serie A",  77,  76, 6));
		equipos.add(new Equipo("Aston Villa", "Premier League",  55,  63, 4));
		equipos.add(new Equipo("Borussia Dortmund", "Bundesliga",  75,  43, 1));
		equipos.add(new Equipo("Atletico Madrid", "LaLiga", 67, 100, 0));
		equipos.add(new Equipo("Atalanta", "Serie A",  90,  66, 3));
		equipos.add(new Equipo("Chelsea", "Premier League",  58, 49, 3));
		equipos.add(new Equipo("Liverpool", "Premier League",  68,  40, 0));
		equipos.add(new Equipo("AC Milan", "Serie A",  74,  80, 4));
		equipos.add(new Equipo("Lille", "Ligue 1",  64,  67, 2));
		equipos.add(new Equipo("Tottenham", "Premier League", 68, 53, 2));
		equipos.add(new Equipo("Napoli", "Serie A",  86,  71, 3));
		equipos.add(new Equipo("Leicester", "Premier League",  68, 61, 0));
		equipos.add(new Equipo("Wolfsburg", "Bundesliga",  61,  56, 3));
		equipos.add(new Equipo("Inter", "Serie A",  89,  59, 2));
		equipos.add(new Equipo("Lyon", "Ligue 1",  81,  60, 10));
		equipos.add(new Equipo("RB Leipzig", "Bundesliga", 60, 57, 0));
		equipos.add(new Equipo("Leeds", "Premier League",  62, 61, 1));
		equipos.add(new Equipo("West Ham", "Premier League",  62, 48, 3));
		equipos.add(new Equipo("Bayer Leverkusen", "Bundesliga",  53,  58, 0));
		equipos.add(new Equipo("Eintracht Frankfurt", "Bundesliga",  53,  58, 0));
		equipos.add(new Equipo("Monaco", "Ligue 1",  76, 74, 7));
		equipos.add(new Equipo("Roma", "Seria A", 68, 84, 3));
		equipos.add(new Equipo("Sevilla", "LaLiga",  53, 75, 2));
		equipos.add(new Equipo("West Ham", "Premier League",  62, 48, 3));
		equipos.add(new Equipo("Borussia M.Gladbach", "Bundesliga",  64,  61, 0));
		equipos.add(new Equipo("Arsenal", "Premier League",  55,  47, 5));
		equipos.add(new Equipo("Rennes", "Ligue 1",  52, 80, 5));
		equipos.add(new Equipo("VfB Stuttgart", "Bundesliga", 56, 63, 2));
		equipos.add(new Equipo("Wolverhampton Wanderers", "Premier League",  36, 53, 1));
		equipos.add(new Equipo("Sassuolo", "Series A",  64, 74, 4));
		equipos.add(new Equipo("Metz", "Ligue 1",  44,  82, 4));
		
		}
	


	@Override
	public String buscarNombre(String nombre) throws RemoteException {
		String resultado = "";
		for (Equipo eq : equipos) {
			if (eq.getNombre().contains(nombre)) {
				resultado = resultado + eq + "\n";
			}
		}
		return resultado;
	}

	@Override
	public String Competicion(String competicion) throws RemoteException {
		String resultado = "";
		for (Equipo eq : equipos) {
			if (eq.getCompeticion().contains(competicion)) {
				resultado = resultado + eq + "\n";
			}
		}
		return resultado;
	}

	@Override
	public String Goles(int goles) throws RemoteException {
		String resultado ="";

		for (Equipo eq : equipos) {
			if (eq.getGoles()>(goles)) {
				resultado = resultado + eq + "\n";
			}
		}
		return resultado;
	}

	@Override
	public String tarjetasRojas(int rojas) throws RemoteException {
		String resultado ="";
	
		for (Equipo eq : equipos) {
			if (eq.getTarjetasRojas()>(rojas)) {
				resultado = resultado + eq + "\n";
			}
		}
		return resultado;
	}

	@Override
	public String tarjetasAmarillas(int amarillas) throws RemoteException {
		String resultado ="";

		for (Equipo eq : equipos) {
			if (eq.getTarjetasAmarillas()>(amarillas)) {
				resultado = resultado + eq + "\n";
				
			}
		}
		return resultado;

	
}
}

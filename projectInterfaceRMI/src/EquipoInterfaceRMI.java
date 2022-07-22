import java.rmi.Remote;
import java.rmi.RemoteException;

public interface EquipoInterfaceRMI extends Remote{
	public String buscarNombre(String nombre) throws RemoteException;
	public String Competicion(String competicion) throws RemoteException;
	public String Goles(int goles) throws RemoteException;
	public String tarjetasRojas(int rojas) throws RemoteException;
	public String tarjetasAmarillas(int amarillas) throws RemoteException;
}

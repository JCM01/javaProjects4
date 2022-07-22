package logica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Cuento;
import model.Usuario;

/**
 * Hello world!
 * 
 */
public class LogicaBD 
{
	static TypedQuery<Cuento> query;
	static TypedQuery<Usuario> queryuser;
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory("CuentosInterciclicas");
	private static EntityManager em = factory.createEntityManager();
	
	public LogicaBD() {
	
	}

	public static List<Cuento> listaCuentos() {
		query= em.createQuery("SELECT cu FROM Cuento cu", Cuento.class);
		List<Cuento> cuentos = query.getResultList();
		return cuentos;
		
	}
	public static Usuario  listaUsuarios(String Usuario) {
		
	
		Usuario user = em.find(Usuario.class, Usuario);
	
		return user;
		
	}
	
	public static List<Cuento> cuentosEdad(String edad) {
		query= em.createQuery("SELECT cu FROM Cuento cu where edad="+ edad+ "", Cuento.class);
		List<Cuento> cuentos = query.getResultList();
		return cuentos;
	}
    	
	public static void insertarDatos(int idcuento, String autor, String descripcion, int edad, String editorial, String titulo
		) {
	
		
		
		System.out.println("Hemos creado el Entity Manager Factory");
		em = factory.createEntityManager();
		System.out.println("Hemos creado en Entity Manager");
		Cuento yo;
		yo = new Cuento(idcuento,autor,descripcion,edad,editorial,titulo);
		EntityTransaction tx = em.getTransaction();
		System.out.println("Hemos iniciado la transacción");
		tx.begin();
		em.persist(yo);
		tx.commit();
	
	}
	public static void insertarUsuario(String correo, String apellidos, String nombre, String password) {
		
			
			
			System.out.println("Hemos creado el Entity Manager Factory");
			em = factory.createEntityManager();
			System.out.println("Hemos creado en Entity Manager");
			Usuario yo;
			
			yo = new Usuario(correo,apellidos,nombre,password);
			EntityTransaction tx = em.getTransaction();
			System.out.println("Hemos iniciado la transacción");
			tx.begin();
			em.persist(yo);
			tx.commit();
		
		}
	    
    
}

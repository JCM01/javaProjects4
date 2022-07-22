package es.CuentosInterciclicas;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import logica.LogicaBD;
import model.Cliente;
import model.Cuento;
import model.Usuario;

public class App {
	static Scanner lector=new Scanner(System.in);
	private static int opcion;
	public static void main(String[] args) {

		do {
			
		System.out.println("1- Dime Todos los cuentos");
		System.out.println("2- Dime cuentos por edad");
		System.out.println("3- Mostrar los Usuarios");
		System.out.println("4- Dar de alta un cuento");
		System.out.println("5- Dar de alta un usuario");
		opcion=lector.nextInt();
		switch (opcion) {
		case 1:
			List<Cuento> cuentos =LogicaBD.listaCuentos();
			for (Cuento p : cuentos) {
			     
	             System.out.println("Listado Productos : ");
	             System.out.println("Cuentos  "+p.toString());
		 }
			break;
		case 2:
			System.out.println("Dime edad recomendada que quieres ver (1-3)");
			
			String edad= lector.next();
			LogicaBD.cuentosEdad(edad);
			List<Cuento> cuentosEdad =LogicaBD.listaCuentos();
			for (Cuento p : cuentosEdad) {
			     
	             System.out.println("Listado Productos : ");
	             System.out.println("Cuentos  "+p.toString());
	             }
			break;
		case 3:
			System.out.println("Dime el usuario");
			String user=lector.next();
			System.out.println(LogicaBD.listaUsuarios(user));
		
			
			
			break;
		case 4:
		
			System.out.println("Dime id del cuento");
			int idcuento= lector.nextInt();
			lector.nextLine();
			
			System.out.println("Dime el autor");
			String autor= lector.next();
			
			System.out.println("Dime una descripción");
			String descripcion= lector.next();
			
			System.out.println("Dime la edad recomendada");
			int edad1 = lector.nextInt();
			
			System.out.println("Dime la editorial");
			String editorial= lector.next();
			
			System.out.println("Dime el título del cuento");
			String titulo= lector.next();
			
			LogicaBD.insertarDatos(idcuento,autor,descripcion,edad1,editorial,titulo);
			break;
		case 5:
			
			System.out.println("Dime el correo");
			String correo = lector.next();
		
			
			System.out.println("Dime apellidos");
			String apellidosUser= lector.next();
			
			System.out.println("Dime tu nombre");
			String nombreUser= lector.next();
			
			System.out.println("Dime el password");
			String password = lector.next();
			
			
			LogicaBD.insertarUsuario(correo, apellidosUser, nombreUser, password);
			break;
		default:
			break;
		}
		}while(opcion!=6);
		
		
		
		lector.close();
		
	}
	
}

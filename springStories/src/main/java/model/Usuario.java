package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the usuario database table.
 * 
 */
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String correo;

	private String apellidos;

	private String nombre;

	private String password;

	//bi-directional many-to-one association to Cuento
	@OneToMany(mappedBy="usuario")
	private List<Cuento> cuentos;

	public Usuario(String correo, String apellidos, String nombre, String password) {
		super();
		this.correo = correo;
		this.apellidos = apellidos;
		this.nombre = nombre;
		this.password = password;
	
	}

	public Usuario() {
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Cuento> getCuentos() {
		return this.cuentos;
	}

	public void setCuentos(List<Cuento> cuentos) {
		this.cuentos = cuentos;
	}

	public Cuento addCuento(Cuento cuento) {
		getCuentos().add(cuento);
		cuento.setUsuario(this);

		return cuento;
	}

	public Cuento removeCuento(Cuento cuento) {
		getCuentos().remove(cuento);
		cuento.setUsuario(null);

		return cuento;
	}

}
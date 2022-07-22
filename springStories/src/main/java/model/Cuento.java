package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the cuento database table.
 * 
 */
@Entity
@NamedQuery(name="Cuento.findAll", query="SELECT c FROM Cuento c")
public class Cuento implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	private int idcuento;

	private String autor;

	private String descripcion;

	private int edad;

	private String editorial;

	private String titulo;
	public Cuento(int idcuento, String autor, String descripcion, int edad, String editorial, String titulo
			) {
		super();
		this.idcuento = idcuento;
		this.autor = autor;
		this.descripcion = descripcion;
		this.edad = edad;
		this.editorial = editorial;
		this.titulo = titulo;
		this.usuario = usuario;
	}



	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="correo")
	private Usuario usuario;

	public Cuento() {
	}

	public int getIdcuento() {
		return this.idcuento;
	}

	public void setIdcuento(int idcuento) {
		this.idcuento = idcuento;
	}

	public String getAutor() {
		return this.autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEdad() {
		return this.edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getEditorial() {
		return this.editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}



	public Usuario getUsuario() {
		return this.usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Cuento [idcuento=" + idcuento + ", autor=" + autor + ", descripcion=" + descripcion + ", edad=" + edad
				+ ", editorial=" + editorial + ", titulo=" + titulo + "," + ", usuario="
				+ usuario + "]";
	}


}
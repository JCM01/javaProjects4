import java.io.Serializable;

public class Producto implements Serializable {


	private static final long serialVersionUID = 3962468642172057001L;


	private String id;
	private String nombre;
	private String idCategoria;
	private String medida;
	private double precio;
	private int stock;

	public Producto(String id, String nombre, String idCategoria, String medida, double precio, int stock) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.idCategoria = idCategoria;
		this.medida = medida;
		this.precio = precio;
		this.stock = stock;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getMedida() {
		return medida;
	}

	public void setMedida(String medida) {
		this.medida = medida;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto id=" + id + ", nombre=" + nombre + ", idCategoria=" + idCategoria + ", medida=" + medida
				+ ", precio=" + precio + ", stock=" + stock ;
	}
}
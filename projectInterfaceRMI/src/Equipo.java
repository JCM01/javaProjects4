
public class Equipo {
	private String nombre;
	private String competicion;
	private int tarjetasRojas;
	private int tarjetasAmarillas;
	private int goles;

	
	public Equipo(String nombre, String Competicion, int Goles, int TarjetasRojas,int TarjetasAmarillas) {
		super();
		this.nombre = nombre;
		this.competicion = Competicion;
		this.goles=  Goles;
		this.tarjetasRojas = TarjetasRojas ;
		this.tarjetasAmarillas= TarjetasAmarillas ;
	}

	public String getNombre() {
		return nombre;
	}

	public String getCompeticion() {
		return competicion;
	}

	public int getGoles() {
		return goles;
	}


	public int getTarjetasRojas() {
		return tarjetasRojas;
	}
	public int getTarjetasAmarillas() {
		return tarjetasAmarillas;
	}

	@Override
	public String toString() {
		return "Equipo [nombre=" + nombre + ", competicion=" + competicion + ", tarjetasRojas=" + tarjetasRojas
				+ ", tarjetasAmarillas=" + tarjetasAmarillas + ", goles=" + goles + "]";
	}
	
	
	

	
}

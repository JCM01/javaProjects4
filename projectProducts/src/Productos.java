import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Productos {

	private ArrayList<Producto> listaProductos;
	private static int sumaStock = 0;
	private static double sumaPrecio = 0.0;
	private static int numeroProductos = 0;

	public Productos() {
		
		File file; // Iniciador
        file = new File("C:\\Users\\Campus FP\\Desktop\\Jose Carreras\\psp\\JavaPsp\\Hito2_JoseCarreras\\src\\producto.csv");
        if (file.exists()) {
            System.out.println("Fichero encontrado");
   
        } else {
            System.out.println("No encontrado " + file.exists());
        }
        Scanner lectorTodas;
        Scanner fila;
        try {
            lectorTodas = new Scanner(file);

            listaProductos = new ArrayList<Producto>();
            while (lectorTodas.hasNextLine()) {
                //System.out.println(lectorTodas);
                String linea = lectorTodas.nextLine();
             
                fila = new Scanner(linea);
                fila.useDelimiter(";");
                String id = fila.next();
                String nombre = fila.next();
                String idCategoria = fila.next();
                String medida = fila.next();
                String precio = fila.next();
                int stock = fila.nextInt();
                double precioDouble = Double.parseDouble(precio);

                numeroProductos++;
                sumaPrecio += precioDouble;
                sumaStock += stock;

                //System.out.println(nombre + " (" + idCategoria + ")" + " -- Precio: " + precio + " € " + "Stock: " + stock + "");
                listaProductos.add(new Producto(id, nombre, idCategoria, medida, precioDouble, stock));
            }
double media = sumaPrecio / numeroProductos;

            System.out.println("----------------");
            System.out.println("Cantidad de productos: " + numeroProductos);
            System.out.println("Suma de precios: " + sumaPrecio + "€");
            System.out.println("Coste total: " + (double) Math.round((sumaPrecio * sumaStock) * 100d) / 100d + "€");
            System.out.println("Media de los precios: " + (double) Math.round(media * 100d) / 100d + "€");

            lectorTodas.close();
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el fichero");
            System.out.println(e.getMessage());
        }
    }
    
	

	public ArrayList<Producto> getListaDistribucion() {
		return listaProductos;
	}

	public void setListaDistribucion(ArrayList<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public Producto productoAzar() {
		int i = (int) (Math.random() * 10);
		return this.listaProductos.get(i);
	}

	public ArrayList<Producto> getProductosGrupo(String idCategoria) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		for (Producto c : this.listaProductos) {
			if (c.getIdCategoria().equals(idCategoria)) {
				productos.add(c);
			}
		}
		return productos;
	}

	public ArrayList<Producto> getProductosTitulo(String nombre) {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		for (Producto c : this.listaProductos) {
			if (c.getNombre().toUpperCase().contains(nombre.toUpperCase())) {
				productos.add(c);
			}
		}
		return productos;
	}
}
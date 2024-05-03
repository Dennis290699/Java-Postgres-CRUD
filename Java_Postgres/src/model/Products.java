package model;

public class Products {
	// Atributos
	private int idProducto;
	private String nombre;
	private String categoria;
	private int cantidad;
	private double precio;

	// Constructor
	public Products(int idProducto, String nombre, String categoria, int cantidad, double precio) {
		this.idProducto = idProducto;
		this.nombre = nombre;
		this.categoria = categoria;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Products() {
	}

	// Metodos Getters y Setters
	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Productos{" + "idProducto=" + idProducto + ", nombre='" + nombre + '\'' + ", categoria='" + categoria
				+ '\'' + ", cantidad=" + cantidad + ", precio=" + precio + '}';
	}

} // FINAL CLASS

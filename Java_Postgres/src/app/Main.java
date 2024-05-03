package app;

import crud.Products_CRUD;
import model.Products;

public class Main {
	public static void main(String[] args) {
		// Ejemplo de uso: insertar un nuevo producto
		Products_CRUD crud = new Products_CRUD();
		Products nuevoProducto = new Products(1, "Producto de prueba", "Electrónica", 10, 99.99);
		crud.insertarProducto(nuevoProducto);

		// Ejemplo de uso: obtener todos los productos e imprimirlos
		System.out.println("Lista de productos:");
		for (Products producto : crud.obtenerProductos()) {
			System.out.println(producto);
		}
	}
	
}//FINAL CLASS

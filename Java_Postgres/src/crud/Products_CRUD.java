package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Products;
import conection.Conection; // Asegúrate de importar la clase Connection adecuada

public class Products_CRUD {

	// Método para insertar un nuevo producto en la tabla
	public void insertarProducto(Products producto) {
		Connection conexion = null;
		PreparedStatement statement = null;

		try {
			// Obtener conexión
			conexion = Conection.obtenerConexion();
			// Query para insertar un nuevo producto
			String query = "INSERT INTO productos (nombre, categoria, cantidad, precio) VALUES (?, ?, ?, ?)";
			// Preparar la declaración SQL
			statement = conexion.prepareStatement(query);
			statement.setString(1, producto.getNombre());
			statement.setString(2, producto.getCategoria());
			statement.setInt(3, producto.getCantidad());
			statement.setDouble(4, producto.getPrecio());
			// Ejecutar la declaración
			statement.executeUpdate();
			System.out.println("Producto insertado exitosamente.");
		} catch (SQLException e) {
			System.out.println("Error al insertar producto: " + e.getMessage());
		} finally {
			// Cerrar la conexión y el statement
			try {
				if (statement != null)
					statement.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar conexión: " + e.getMessage());
			}
		}
	}

	// Método para obtener todos los productos de la tabla
	public List<Products> obtenerProductos() {
		Connection conexion = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		List<Products> productos = new ArrayList<>();

		try {
			// Obtener conexión
			conexion = Conection.obtenerConexion();
			// Query para obtener todos los productos
			String query = "SELECT * FROM productos";
			// Preparar la declaración SQL
			statement = conexion.prepareStatement(query);
			// Ejecutar la consulta
			resultSet = statement.executeQuery();
			// Procesar los resultados
			while (resultSet.next()) {
				Products producto = new Products(resultSet.getInt("id"), resultSet.getString("nombre"),
						resultSet.getString("categoria"), resultSet.getInt("cantidad"), resultSet.getDouble("precio"));
				productos.add(producto);
			}
		} catch (SQLException e) {
			System.out.println("Error al obtener productos: " + e.getMessage());
		} finally {
			// Cerrar la conexión, el statement y el resultSet
			try {
				if (resultSet != null)
					resultSet.close();
				if (statement != null)
					statement.close();
				if (conexion != null)
					conexion.close();
			} catch (SQLException e) {
				System.out.println("Error al cerrar conexión: " + e.getMessage());
			}
		}

		return productos;
	}

}// FINAL CLASS

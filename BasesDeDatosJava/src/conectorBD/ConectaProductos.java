package conectorBD;

import java.sql.*;

public class ConectaProductos {

	public static void main(String[] args) {
		//clase que pide los datos de la tabla productos y los devuelve
		try {
			// 1 - creamos la conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/practicasql?autoReconnect=true&useSSL=false", "root", "");
			
			// 2 - creamos la declaracion sql
			Statement miStatement = miConexion.createStatement();
			
			// 3 - ejecutar la declaracion sql
			ResultSet resultado = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			// 4 - leer el resultset
			//titulos de los campos
			System.out.println("Nombre de Articulo - Precio - Seccion - Fecha");
			System.out.println(" ");
			System.out.println(" ");
			while(resultado.next()) {
				System.out.println(resultado.getString("NOMBREARTÍCULO") + " " + resultado.getDouble("PRECIO") + " " + resultado.getString("SECCIÓN") + " " + resultado.getDate("FECHA"));
				//System.out.println(resultado.getString(1) + " " + resultado.getString(2) + " " + resultado.getString(3) + " " + resultado.getString(4) + " " + resultado.getString(5) + " " + resultado.getString(6));
			}
			
			System.out.println(" ");
		}
		catch(Exception e) {
			
			System.out.println("La consulta fallo");
			
			e.printStackTrace();
			
		}

	}

}

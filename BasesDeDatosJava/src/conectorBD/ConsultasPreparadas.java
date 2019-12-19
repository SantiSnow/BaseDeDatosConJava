package conectorBD;

import java.sql.*;

public class ConsultasPreparadas {

	public static void main(String[] args) {
		//clase que pide los datos de la tabla productos y los devuelve
		try {
			// 1 - creamos la conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/practicasql?autoReconnect=true&useSSL=false", "root", "");
		
			// 2 - creamos la consulta sql
			PreparedStatement miStatement = miConexion.prepareStatement("SELECT * FROM PRODUCTOS" + " WHERE SECCIÓN=? AND PAÍSDEORIGEN=?");
			
			// 3 - Establecer los parametros de consulta
			miStatement.setString(1, "DEPORTES");
			miStatement.setString(2, "USA");
			
			// 4 - Ejecutar y recorrer la consulta
			ResultSet rs = miStatement.executeQuery();
			
			while(rs.next()) {
				
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(7));
				
			}
			
			rs.close();
			
			System.out.println(" ");
			System.out.println(" ");
			System.out.println(" ");
			
			//reutilizacion de consulta
			// 3 - Establecer los parametros de consulta
			miStatement.setString(1, "CONFECCIÓN");
			miStatement.setString(2, "ITALIA");
					
			// 4 - Ejecutar y recorrer la consulta
			rs = miStatement.executeQuery();
						
			while(rs.next()) {
							
				System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(7));
							
			}
						
			rs.close();		
			
		}
		catch(Exception e) {
					
			System.out.println("La consulta fallo");
					
			e.printStackTrace();
					
		}		
	}

}

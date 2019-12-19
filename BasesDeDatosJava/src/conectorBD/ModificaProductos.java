package conectorBD;

import java.sql.*;

public class ModificaProductos {
	public static void main(String[] args) {
		//clase que pide los datos de la tabla productos y los devuelve
		try {
			// 1 - creamos la conexion
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/practicasql?autoReconnect=true&useSSL=false", "root", "");
			
			// 2 - creamos la declaracion sql
			Statement miStatement = miConexion.createStatement();
			
			// insertar registros en la tabla
			// creamos la instruccion sql
			String instruccionSql1 = "INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO, NOMBREARTÍCULO, PRECIO) VALUES ('AR33','PANTALONES', 35.5)";
			String instruccionSql2 = "UPDATE PRODUCTOS SET PRECIO=PRECIO*2 WHERE CÓDIGOARTÍCULO='AR33'";
			String instruccionSql3 = "DELETE FROM PRODUCTOS WHERE CÓDIGOARTÍCULO='AR33'";
			
			//la ejecutamos mediante executeUpdate , que sirve para delete, insert o update 
			miStatement.executeUpdate(instruccionSql3);
			
			System.out.println("Datos actualizados correctamente");
			// 3 - ejecutar la declaracion sql
			//ResultSet resultado = miStatement.executeQuery("SELECT * FROM PRODUCTOS");
			
			
			
			System.out.println(" ");
		}
		catch(Exception e) {
			
			System.out.println("La consulta fallo");
			
			e.printStackTrace();
			
		}

	}
}

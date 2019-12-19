package conectorBD;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Ventana extends JFrame{

	//atributos
	private JComboBox secciones;
	private JComboBox paises;
	private JTextArea resultado;
	
	public Ventana() {
		setSize(500, 700);
		setTitle("Programa de Consultas a Bases de Datos");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel menus = new JPanel();
		menus.setLayout(new FlowLayout());
		
		
		secciones = new JComboBox();
		secciones.setEditable(false);
		secciones.addItem("Todos");
		paises=new JComboBox();
		paises.setEditable(false);
		paises.addItem("Todos");
		
		resultado= new JTextArea(4,50);
		resultado.setEditable(false);
		add(resultado);
		menus.add(secciones);
		menus.add(paises);	
		add(menus, BorderLayout.NORTH);
		add(resultado, BorderLayout.CENTER);
		
		JButton botonConsulta=new JButton("Consulta");	
		add(botonConsulta, BorderLayout.SOUTH);
		
		
		
		//------------------------------------  CONEXION CON LA BASE DE DATOS -------------------------------------------//
		
		try {
			
			Connection miConexion = DriverManager.getConnection("jdbc:mysql://localhost:3308/practicasql?autoReconnect=true&useSSL=false", "root", "");
			
			Statement miStatement = miConexion.createStatement();
			//Primer consulta secciones
			String querysql = "SELECT DISTINCTROW SECCIÓN FROM PRODUCTOS";
			ResultSet miResultSet = miStatement.executeQuery(querysql);
			while(miResultSet.next()) {
				secciones.addItem(miResultSet.getString(1));			
			}
			miResultSet.close();
			
			//segunda consulta paises
			String querysql2 = "SELECT DISTINCTROW PAÍSDEORIGEN FROM PRODUCTOS";
			miResultSet = miStatement.executeQuery(querysql2);
			while(miResultSet.next()) {
				paises.addItem(miResultSet.getString(1));			
			}
			miResultSet.close();
			
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Algo fallo");
			System.out.println("Algo Fallo");
			e.printStackTrace();
		}
	}
		
}

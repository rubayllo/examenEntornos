package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

import vista.VistaTablaDB;

public class Modelo {
	VistaTablaDB vistaTablaBD;

	private final String bbdd = "world";
	private final String user = "root";
	private final String pass = "";
	private final String driver = "com.mysql.cj.jdbc.Driver";
	private final String url = "jdbc:mysql://localhost/" + bbdd;
	private Connection conexion;

	private DefaultTableModel modeloTabla;
	
	public Modelo() {
		conexionBd();
	}
	
	private void conexionBd() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, user, pass);
			System.out.println("Conexión establecida");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setVistaTablaDB(VistaTablaDB vistaTablaDB) {
		this.vistaTablaBD = vistaTablaDB;
	}

	public void consultarQuery(String query) {
		int columnasTabla = getCol(query);
		int filasTabla = getFil(query);
		int fila = 0;
		String[] cabecera = new String[columnasTabla];
		Object[][] registro = new Object[filasTabla][columnasTabla];
		try {
			PreparedStatement prepararSQL = conexion.prepareStatement(query);
			ResultSet datosSQL = prepararSQL.executeQuery();
			ResultSetMetaData metaDatosSQL = datosSQL.getMetaData();
			
			for (int i = 1; i <= columnasTabla; i++) {
				cabecera[i-1] = metaDatosSQL.getColumnName(i);
			}
			while(datosSQL.next()) {
				for (int i = 1; i <= columnasTabla; i++) {
					registro[fila][i-1] = datosSQL.getString(i);
				}
				fila++;
			}
			modeloTabla = new DefaultTableModel(registro, cabecera);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private int getCol(String query) {
		int columnas = 0;
		try {
			PreparedStatement prepararSQL = conexion.prepareStatement(query);
			ResultSet datosSQL = prepararSQL.executeQuery();
			ResultSetMetaData metaDatosSQL = datosSQL.getMetaData();
			columnas = metaDatosSQL.getColumnCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnas;
	}

	private int getFil(String query) {
		int filas = 0;
		try {
			PreparedStatement prepararSQL = conexion.prepareStatement(query);
			ResultSet datosSQL = prepararSQL.executeQuery();
			while(datosSQL.next()) {
				filas++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return filas;
	}

	public DefaultTableModel getModeloTabla() {
		return this.modeloTabla;
	}

}

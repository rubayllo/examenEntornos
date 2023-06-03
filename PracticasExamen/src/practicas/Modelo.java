package practicas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

public class Modelo {

	private Vista vista;

	private String bbdd = "world";
	private final String url = "jdbc:mysql://localhost/" + bbdd + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";		;
	private String driver = "com.mysql.cj.jdbc.Driver";
	private String usuario = "root";
	private String password = "";
	private Connection conexion;
	
	private DefaultTableModel vistaTabla;
	
	public Modelo() {
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(url, usuario, password);
			System.out.println("Conexion establecida a BBDD " + bbdd);
		} catch (ClassNotFoundException e) {
			System.out.println("Error de conexion url, usuario o contraseña");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error de conexion general");
			e.printStackTrace();
		}
	}
	
	public void recuperarDatos(String sql) {
		String consultaSQL = sql;
		String[] cabecera;
		Object[][] datosTabla;
		int columnas = 0;
		int filas = 0;
		
		try {
			PreparedStatement prepararSQL = conexion.prepareStatement(consultaSQL);
			ResultSet datosRecibidos = prepararSQL.executeQuery();
			ResultSetMetaData metaDatosBD = datosRecibidos.getMetaData();
			
			columnas = metaDatosBD.getColumnCount();
			cabecera = new String[columnas];
		
			for (int i = 1; i <= columnas; i++) {
				cabecera[i-1] = metaDatosBD.getColumnName(i);
				System.out.println(cabecera[i-1]);
			}
			datosTabla = new Object[getNumFilas(consultaSQL)][columnas];
		
			while (datosRecibidos.next()) {
				for (int i = 1; i <= columnas; i++) {
					datosTabla[filas][i-1] = datosRecibidos.getString(i);
				}
				filas++;
			}
			this.vistaTabla = new DefaultTableModel(datosTabla, cabecera);
			vista.setModeloTabla(vistaTabla);
			
		} catch (SQLException e) {
			System.out.println("Error de conexion general");
			e.printStackTrace();
		}
		
	}
	
	private int getNumFilas(String sql) {
		int filas = 0;
		try {
			PreparedStatement prepararSQL = conexion.prepareStatement(sql);
			ResultSet datosRecibidos = prepararSQL.executeQuery();
			while (datosRecibidos.next()) {
				filas++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	public void setVista(Vista vista) {
		this.vista = vista;
	}

}

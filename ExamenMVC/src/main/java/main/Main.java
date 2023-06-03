package main;

import java.util.ArrayList;

import controlador.Controlador;
import interfaceVistas.Vistas;
import modelo.Modelo;
import vista.VistaTablaDB;

public class Main {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador();
		VistaTablaDB vistaTablaDB =new VistaTablaDB();
		
		ArrayList<Vistas> vistas = new ArrayList<>();
			vistas.add(vistaTablaDB);
			
		modelo.setVistaTablaDB(vistaTablaDB);
		
		for (Vistas vista : vistas) {
			vista.setControlador(controlador);
			vista.setModelo(modelo);
		}
		
		controlador.setVistaTablaDB(vistaTablaDB);
		controlador.setModelo(modelo);
		
		vistaTablaDB.setVisible(true);		
	}

}

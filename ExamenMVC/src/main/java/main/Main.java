package main;

import java.util.ArrayList;

import controlador.Controlador;
import interfaceVistas.Vistas;
import modelo.Modelo;
import vista.VistaSeleccionados;
import vista.VistaTablaDB;

public class Main {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Controlador controlador = new Controlador();
		VistaTablaDB vistaTablaDB = new VistaTablaDB();
		VistaSeleccionados vistaSeleccionados= new VistaSeleccionados();

		ArrayList<Vistas> vistas = new ArrayList<>();
			vistas.add(vistaTablaDB);
			vistas.add(vistaSeleccionados);
			
		modelo.setVistaTablaDB(vistaTablaDB);
		modelo.setVistaSeleccionados(vistaSeleccionados);
		
		for (Vistas vista : vistas) {
			vista.setControlador(controlador);
			vista.setModelo(modelo);
		}
		
		controlador.setModelo(modelo);
		controlador.setVistaTablaDB(vistaTablaDB);
		controlador.setVistaSeleccionados(vistaSeleccionados);
		
		vistaTablaDB.setVisible(true);		
	}

}

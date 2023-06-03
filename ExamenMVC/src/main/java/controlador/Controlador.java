package controlador;

import modelo.Modelo;
import vista.VistaTablaDB;

public class Controlador {
	VistaTablaDB vistaTablaBD;
	Modelo modelo;
	
	public void setVistaTablaDB(VistaTablaDB vistaTablaDB) {
		this.vistaTablaBD = vistaTablaDB;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public void consultarQuery(String query) {
		modelo.consultarQuery(query);
		vistaTablaBD.setModeloTabla(modelo.getModeloTabla());
	}
	
	
}

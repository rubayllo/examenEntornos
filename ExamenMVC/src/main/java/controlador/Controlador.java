package controlador;

import modelo.Modelo;
import vista.VistaSeleccionados;
import vista.VistaTablaDB;

public class Controlador {
	private Modelo modelo;
	private VistaTablaDB vistaTablaBD;
	private VistaSeleccionados vistaSeleccionados;
	
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public void setVistaTablaDB(VistaTablaDB vistaTablaDB) {
		this.vistaTablaBD = vistaTablaDB;
	}
	public void setVistaSeleccionados(VistaSeleccionados vistaSeleccionados) {
		this.vistaSeleccionados = vistaSeleccionados;
	}

	public void consultarQuery(String query) {
		modelo.consultarQuery(query);
		vistaTablaBD.setModeloTabla(modelo.getModeloTabla());
	}
	public void cambiarVista(String vista) {
		switch (vista) {
		case "vistaSeleccionados":
			vistaSeleccionados.setVisible(true);
			vistaTablaBD.setVisible(false);
			break;
			
		case "vistaTablaDB":
			vistaTablaBD.setVisible(true);
			vistaSeleccionados.setVisible(false);
			break;
			
		default:
			break;
		}
	}
	
	
}

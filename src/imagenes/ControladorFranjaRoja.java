package imagenes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import imagenes.transformaciones.FranjaRoja;

public class ControladorFranjaRoja implements ActionListener {
	
	private Imagen modelo;
	
	public ControladorFranjaRoja(Imagen m) {
		modelo = m;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		FranjaRoja f= new FranjaRoja(modelo);
		f.hacer();
	}

}

package animacion.vista;

import java.awt.Graphics;

import animacion.modelo.Figura;

public class DibujoFigura implements IDibujo {
	
	private Figura objeto;
	
	public DibujoFigura(Figura f) {
		objeto = f;
	}

	public void dibujar(Graphics g) {
		g.drawRect(objeto.getX(), objeto.getY(), 
				objeto.getAncho(), objeto.getAlto());
	}
}

package animacion.gui;

import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;

import animacion.vista.IDibujo;

public class PanelAnimacion extends JPanel implements PropertyChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDibujo dibujo;
	
	public PanelAnimacion(IDibujo dibujo) {
		this.dibujo = dibujo;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(600,400);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (dibujo != null) {
			dibujo.dibujar(g);
		}
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		repaint();
	}
}

package arboles.gui;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import arboles.Arbol;
import arboles.Persona;

public class FrameArbol extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Arbol<Persona> modelo;
	
	public FrameArbol() {
		initModelo();
		init();
	}
	
	private void initModelo() {
		modelo = new Arbol<>();
		
		modelo.addHijo(new Persona("X", "Perro"), null);
		modelo.addHijo(new Persona("M", "Gato"), "X");
		modelo.addHijo(new Persona("D", ""), "X");
		modelo.addHijo(new Persona("P", "Paco"), "D");
		modelo.addHijo(new Persona("E", "Paco"), "D");
		modelo.addHijo(new Persona("A", "Paco"), "D");
		
		System.out.println(modelo);
	}

	private void init() {

		PanelArbol panel = new PanelArbol(modelo);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		this.pack();
	}
	
	public static void main(String[] args) {
		FrameArbol frameArbol = new FrameArbol();
		frameArbol.setVisible(true);
	}
}

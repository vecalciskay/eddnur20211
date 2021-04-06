package imagenes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import imagenes.transformaciones.FranjaCafeClaro;
import imagenes.transformaciones.FranjaRoja;


public class WinImagen extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Imagen modelo;
	
	public WinImagen() {
		init();
	}
	
	public void init() {
		
		modelo = new Imagen(500, 350);
		
		PanelImagen panel = new PanelImagen(modelo);
		
		modelo.addObserver(panel);
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(panel, BorderLayout.CENTER);
		
		JMenuBar menuBar = new JMenuBar();
		
		JMenu mnuImagen = new JMenu("Imagen");
		
		JMenuItem item = new JMenuItem("Franja roja");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mnuImagen_franjaRoja();
			}
		});
		
		mnuImagen.add(item);
		
		item = new JMenuItem("Franja cafe claro");
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				mnuImagen_franjaCafeClaro();
			}
		});
		
		mnuImagen.add(item);
		
		menuBar.add(mnuImagen);
		
		this.setJMenuBar(menuBar);
		
		this.pack();
	}

	protected void mnuImagen_franjaCafeClaro() {
		FranjaCafeClaro f= new FranjaCafeClaro(modelo);
		f.hacer();
	}

	protected void mnuImagen_franjaRoja() {
		FranjaRoja f= new FranjaRoja(modelo);
		f.hacer();
	}
}

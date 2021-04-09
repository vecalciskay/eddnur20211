package imagenes.transformaciones;

import imagenes.Imagen;

public class PintarEnXY extends Transformacion {

	private int x;
	private int y;
	
	public PintarEnXY(Imagen img, int x, int y) {
		imagenBase = img;
		this.x = x;
		this.y = y;
	}
	@Override
	public void hacer() {
	
		try {
			pintarPuntoXY(x,y, -1);
		} catch(StackOverflowError ex) {
			System.out.println("Termina por stack overflow");
		}
		imagenBase.cambioOk();
	}
	
	public void pintarPuntoXY(int m, int n, int colorBase) {
		int base = colorBase;
		int c = imagenBase.getPixel(m, n);
		
		if (base < 0)
			base = c;
				
		imagenBase.setPixel(0, m, n);
		
		if ((m+1) < imagenBase.getAncho() && imagenBase.getPixel(m+1,n) == base)
			pintarPuntoXY(m + 1, n, base);
		if ((m-1) >= 0 && imagenBase.getPixel(m-1,n) == base)
			pintarPuntoXY(m - 1, n, base);
		
		if ((n+1) < imagenBase.getAlto() && imagenBase.getPixel(m,n+1) == base)
			pintarPuntoXY(m, n + 1, base);
		if ((n-1) >= 0 && imagenBase.getPixel(m,n-1) == base)
			pintarPuntoXY(m, n - 1, base);
	}
}

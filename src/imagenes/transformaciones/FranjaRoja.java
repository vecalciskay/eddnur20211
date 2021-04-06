package imagenes.transformaciones;

import imagenes.Imagen;

public class FranjaRoja extends Transformacion {

	public FranjaRoja(Imagen img) {
		imagenBase = img;
	}
	@Override
	public void hacer() {
		
		//int rojo = 16711680; // 0 255 0 0
		
		int rojo = 255 << 16;
		
		for (int i = 0; i < imagenBase.getAncho(); i++) {
			for (int j = 0; j < 50; j++) {
				imagenBase.setPixel(rojo, i, j);
			}
		}
		
		imagenBase.cambioOk();
	}

}

package imagenes.transformaciones;

import imagenes.Imagen;

public class FranjaCafeClaro extends Transformacion {

	public FranjaCafeClaro(Imagen img) {
		imagenBase = img;
	}

	@Override
	public void hacer() {
		int rojo = 173 << 16;
		int verde = 182 << 8;
		int azul = 73;
		
		int c = rojo | verde | azul;
		
		for (int i = 0; i < imagenBase.getAncho(); i++) {
			for (int j = 80; j < 120; j++) {
				imagenBase.setPixel(c, i, j);
			}
		}

		imagenBase.cambioOk();
	}

}

package arboles.aritmetico;


public class Operador extends ElementoAritmetico {

	private String simbolo;
	private String nombre;
	
	public Operador(String s) {
		simbolo = s;
		if (s.equals("+")) {
			nombre = "Suma";
		}
	}

	public String getSimbolo() {
		return simbolo;
	}

	public String getNombre() {
		return nombre;
	}
	
}

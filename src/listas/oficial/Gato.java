package listas.oficial;

public class Gato {
	private int edad;
	private String nombre;
	
	public Gato(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
	}
	
	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}

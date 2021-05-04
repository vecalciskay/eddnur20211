package listas.oficial;

import java.util.Comparator;

public class Perro implements Comparable<Perro> {
	
	private int edad;
	private String nombre;
	private Comparator<Perro> comparador;

	public Perro(int edad, String nombre) {
		this.edad = edad;
		this.nombre = nombre;
		this.comparador = new ComparatorPerroNormal();
	}

	public Comparator<Perro> getComparador() {
		return comparador;
	}

	public void setComparador(Comparator<Perro> comparador) {
		this.comparador = comparador;
	}

	@Override
	public int compareTo(Perro o) {
		// Si perro o es IGUAL a nosotros entonces devuelve 0
		// Si perro o viene ANTES que nosotros entonces devuelve -1
		// Si perro o viene DESPUES que nosotros entonces devuelve 1
		return comparador.compare(this, o);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return nombre + " (" + edad + ")";
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

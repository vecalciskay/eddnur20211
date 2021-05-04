package listas;

import listas.oficial.Gato;
import listas.oficial.ListaOrdenada;
import listas.oficial.Perro;

public class TestOrdenada {
	public static void main(String[] args) {
		
		ListaOrdenada<String> a = new ListaOrdenada<String>();
		
		a.insertar("hugo");
		a.insertar("paco");
		a.insertar("luis");
		a.insertar("maria");
		
		System.out.println(a);
		

		ListaOrdenada<Perro> b = new ListaOrdenada<>();
		
		b.insertar(new Perro(4,"hugo"));
		b.insertar(new Perro(8,"paco"));
		b.insertar(new Perro(10,"luis"));
		b.insertar(new Perro(8,"luis"));
		b.insertar(new Perro(13,"maria"));
		
		System.out.println(b);
	}
}

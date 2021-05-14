package listas;

import listas.oficial.Lista;
import listas.oficial.ListaOrdenada;

public class TestSort {
	public static void main(String[] args) {
		
		System.out.println("LISTA 1");
		Lista<String> lista1 = new Lista<String>();
		lista1.insertar("hugo");
		lista1.insertar("paco");
		lista1.insertar("luis");
		lista1.insertar("laura");

		System.out.println(lista1);

		// Usando el sort de lista
		lista1.sort();
		System.out.println(lista1);
		
		System.out.println("LISTA 2");
		Lista<String> lista2 = new Lista<String>();
		lista2.insertar("hugo");
		lista2.insertar("paco");
		lista2.insertar("luis");
		lista2.insertar("laura");

		System.out.println(lista2);
		
		// Con lista ordenada
		ListaOrdenada<String> ordenada = new ListaOrdenada<String>();
		for(String s : lista2) {
			ordenada.insertar(s);
		}
		
		System.out.println(ordenada);

		
	}
}

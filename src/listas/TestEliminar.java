package listas;

import listas.oficial.Lista;

public class TestEliminar {
	public static void main(String[] args) {
		Lista<String> lista2 = crearLista();
		
		eliminarUnElemento(lista2);		
		
		System.out.println(lista2);
	}
	
	public static Lista<String> crearLista() {
		Lista<String> lista2 = new Lista<String>();
		lista2.insertar("hugo");
		lista2.insertar("paco");
		lista2.insertar("luis");
		lista2.insertar("laura");
		
		return lista2;
	}
	
	public static void eliminarUnElemento(Lista<String> lista2) {
		try {
			lista2.eliminar(5);
		} catch (Exception e) {
			System.out.println("Mensaje bonito para el cliente: Usó un indice fuera del tamaño de la lista. No se eliminó nada");
		}
	}
}

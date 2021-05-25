package arboles;

import listas.oficial.Lista;

public class Arbol<T> {
	private Contenedor<T> raiz;
	
	public Contenedor<T> getRaiz() {
		return raiz;
	}

	public void setRaiz(Contenedor<T> raiz) {
		this.raiz = raiz;
	}

	class Contenedor<T> {
		private T contenido;
		private Lista<Contenedor<T>> hijos;
		private Contenedor<T> padre;
		public T getContenido() {
			return contenido;
		}
		public void setContenido(T contenido) {
			this.contenido = contenido;
		}
		public Lista<Contenedor<T>> getHijos() {
			return hijos;
		}
		public void setHijos(Lista<Contenedor<T>> hijos) {
			this.hijos = hijos;
		}
		public Contenedor<T> getPadre() {
			return padre;
		}
		public void setPadre(Contenedor<T> padre) {
			this.padre = padre;
		}
		
	}
}

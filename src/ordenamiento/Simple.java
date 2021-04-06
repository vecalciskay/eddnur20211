package ordenamiento;

/**
 * Complejidad de ordenar Simple es n^2.
 * O(n) = n^2
 * @author Vladimir
 *
 */
public class Simple {
	public static int[] ordenar(int[] lista) {
		for(int i=0; i<lista.length; i++) {
			for(int j=i+1; j<lista.length; j++) {
				if (lista[i] > lista[j]) {
					int aux = lista[i];
					lista[i] = lista[j];
					lista[j] = aux;
				}
			}
		}
		return lista;
	}

}

package ordenamiento;

public class Ordenar {
	public static void main(String[] args) {

		int[] a = new int[100];
		
		llenarArreglo(a);
		
		imprimir(a);
		
		Quicksort qs = new Quicksort(); 
		qs.quickSort(a, 0, 99);
		
		imprimir(a);
		
		System.out.println(qs.getCantidadOperaciones());
	}

	private static void imprimir(int[] a) {
		for (int i : a) {
			System.out.print(String.valueOf(i) + " ");
		}
		System.out.println();
	}

	private static void llenarArreglo(int[] a) {
		for (int i = 0; i < a.length; i++) {
			a[i] = 1 + (int)(Math.random() * 10000.0);
		}
	}
}

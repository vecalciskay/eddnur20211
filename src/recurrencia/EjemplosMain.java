package recurrencia;

public class EjemplosMain {
	public static void main(String[] args) {

		EjemploBasico ejemplos = new EjemploBasico();
		
		// Este da StackOverflowError
		//ejemplos.m();
		
		ejemplos.imprimirNVeces(5);
		
		int resultado = ejemplos.suma(4);
		System.out.println(resultado);
		
		System.out.println("HANOI DE 3");
		HanoiBasico h = new HanoiBasico();
		h.hanoi(1, 2, 3, 4);
	}
}

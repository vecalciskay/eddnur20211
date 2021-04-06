package recurrencia;

public class HanoiBasico {

	public void hanoi(int de, int a, int pp, int n) {
		if (n == 1) {
			System.out.println("Mover " + de + " -> " + a);
			return;
		}		
		
		hanoi(de, pp, a, n-1);
		hanoi(de, a, pp, 1);
		hanoi(pp, a, de, n-1);
	}
}

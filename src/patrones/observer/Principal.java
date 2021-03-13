package patrones.observer;

public class Principal {

	public static void main(String[] args) {

		PromocionComercial promo = new PromocionComercial(100,1);
		CuentaBanco cta = new CuentaBanco("Vladimir",0);
		cta.addObserver(promo);
		
		System.out.println(cta);
		cta.depositar(300);
		System.out.println(cta);
		cta.sacar(200);
		System.out.println(cta);
		cta.depositar(400);
		System.out.println(cta);
		cta.sacar(300);
		System.out.println(cta);
	}

}

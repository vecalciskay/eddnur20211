package patrones.observer;

import java.beans.PropertyChangeSupport;

public class CuentaBanco {

	private int saldo;
	private String cliente;

	private PropertyChangeSupport cambios;

	public CuentaBanco(String clt, int i) {
		cliente = clt;
		saldo = i;
		cambios = new PropertyChangeSupport(this);
	}
	
	public void addObserver(PromocionComercial promo) {
		cambios.addPropertyChangeListener(promo);
	}
	
	@Override
	public String toString() {
		return "Cliente: " + cliente + ", Saldo: " + saldo + " Bs";
	}

	public void depositar(int i) {
		int oldSaldo = saldo;
		saldo += i;		

		cambios.firePropertyChange("SALDO", oldSaldo, saldo);
	}

	public void sacar(int i) {
		int oldSaldo = saldo;
		saldo -= i;

		cambios.firePropertyChange("SALDO", oldSaldo, saldo);
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

}


public class Conta {
	private double saldo;
	int agencia;
	int numero;
	// Cliente titular = new Cliente;
	Cliente titular;
	
	
	// metodo == deve comencr com letra minusculo
	// valor e o parametro que ele recebe
	void deposita(double valor) {
		this.saldo += valor;
	}
	
	public boolean saca(double valor){
		if(this.saldo >= valor) {
			this.saldo -= valor;
			return true;
		}else {
			return false;
		}
	}
	
	public boolean transfere(double valor, Conta destino){
		if(this.saldo >= valor) {
			this.saldo -= valor;
			destino.deposita(valor);
			return true;
		}
		return false;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	
}

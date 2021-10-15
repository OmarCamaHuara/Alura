
public class Conta {
	private double saldo;
	private int agencia;
	private int numero;
	// Cliente titular = new Cliente;
	private Cliente titular;
	private static int total;
	
	Conta(int agencia, int numero){
		Conta.total++;
		this.agencia = agencia;
		this.numero = numero;
	}
	
	
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
	
	public int getNumero() {
		return this.numero;
	}
	
	public void setNumero(int numero) {
		if(numero <= 0) {
			System.out.println("Erro, nro invalido!!");
			return;
		}
		this.numero = numero;
	}
	
	public int getAgencia() {
		return this.agencia;
	}
	public void setAgencia(int agencia) {
		if(agencia <= 0) {
			System.out.println("Erro, nro invalido!!!");
			return;
		}
		this.agencia = agencia;
	}
	public Cliente getTitular() {
		return this.titular;
	}
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}
	
	public static int getTotal() {
		return Conta.total;
	}
}

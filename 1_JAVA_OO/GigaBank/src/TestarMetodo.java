
public class TestarMetodo {
	public static void main(String[] args) {
		Conta contaDoOmar = new Conta();
		Conta contaDaMarcela = new Conta();
		
		contaDoOmar.deposita(50.03);
		contaDaMarcela.deposita(1000);
		
		System.out.println(contaDoOmar.saldo);
		
		boolean conseguiuRetirar = contaDoOmar.saca(20);
		
		System.out.println(contaDoOmar.saldo);
		
		System.out.println(conseguiuRetirar);
		
		// contaDaMarcela.transfere(300, contaDoOmar);
		
		boolean sucessoTranferencia = contaDaMarcela.transfere(300, contaDoOmar);
		
		if(sucessoTranferencia) {
			System.out.println("Tranferencia com sucesso");
			System.out.println("Novo saldo da Marcela " + contaDaMarcela.saldo);
			
		}else {
			System.out.println("Falto dinhero");
		}
		
		
		System.out.println("Saldo do Omar "+contaDoOmar.saldo);
	}
}

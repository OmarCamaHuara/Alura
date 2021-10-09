
public class main {
	public static void main(String[] args) {
		
		Cliente omar = new Cliente();
		omar.cpf = "242.290.048-85";
		omar.nome = "Omar Cama Huarahuara";
		omar.profisao = "Programador";
		
		Conta contaDoOmar = new Conta();
		
		contaDoOmar.deposita(600);
		contaDoOmar.titular = omar;
		
		System.out.println(contaDoOmar.titular.nome);
		
		System.out.println("Inicializando un Cliente dentro de uma conta");
		
		Conta contaDaMarcela = new Conta();
		contaDaMarcela.deposita(300);
		
		System.out.println(contaDaMarcela.titular);
		
		contaDaMarcela.titular = new Cliente();
		contaDaMarcela.titular.nome = "Marcela";
		
		System.out.println(contaDaMarcela.titular);
		System.out.println(contaDaMarcela.titular.nome);
		
		System.out.println(contaDaMarcela.getSaldo());
	}
}

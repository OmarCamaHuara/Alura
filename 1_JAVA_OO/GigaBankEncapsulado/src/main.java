
public class main {

	public static void main(String[] args) {
		
		Conta conta = new Conta(889, 447);
		Conta conta2 = new Conta(885, 665);
		Conta conta3 = new Conta(975, 885);
		
		
		System.out.println("Nro de Agencia: "+ conta.getAgencia());
		System.out.println("Nro de Conta: "+ conta.getNumero());
		
		
		Cliente omar = new Cliente();
		omar.setNome("Omar Cama Huarahuara");
		
		
		conta.setTitular(omar);
		
		System.out.println(conta.getTitular().getNome());
		
		conta.getTitular().setProfisao("Programador");
		System.out.println(conta.getTitular().getProfisao());
		
		
		Cliente titularDaConta = conta.getTitular();
		titularDaConta.setProfisao("Programador2.0");
		
		System.out.println(conta.getTitular().getProfisao());
		
		System.out.println("Quantidade de contas: "+ Conta.getTotal());
	}

}

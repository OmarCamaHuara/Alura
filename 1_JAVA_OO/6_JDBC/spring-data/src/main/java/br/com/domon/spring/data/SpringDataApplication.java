package br.com.domon.spring.data;

import br.com.domon.spring.data.service.CrudCargoService;
import br.com.domon.spring.data.service.CrudFuncionarioService;
import br.com.domon.spring.data.service.CrudUnidadeTrabalhoService;
import br.com.domon.spring.data.service.RelatorioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
// interface CommandLineRunner que obliga a implementar o metodo run
public class SpringDataApplication implements CommandLineRunner {

	private boolean system = true;

	// Instancia
	// Injecao de dependencia
	private final CrudCargoService cargoService;
    private final CrudFuncionarioService funcionarioService;
    private final CrudUnidadeTrabalhoService unidadeTrabalhoService;
    private final RelatorioService relatorioService;

	public SpringDataApplication(CrudCargoService cargoService,
                                 CrudFuncionarioService funcionarioService,
                                 CrudUnidadeTrabalhoService unidadeTrabalhoService,
                                 RelatorioService relatorioService){
		this.cargoService = cargoService;
        this.funcionarioService = funcionarioService;
        this.unidadeTrabalhoService = unidadeTrabalhoService;
        this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system){
			System.out.println("Qual acao vc quer fazer");
            System.out.println("4 - Relatorios");
            System.out.println("3 - Unidade");
            System.out.println("2 - Funcionario");
			System.out.println("1 - Cargo");
			System.out.println("0 - Sair");

			int action = scanner.nextInt();

            switch (action){
                case 1:
                    cargoService.inicial(scanner);
                    break;
                case 2:
                    funcionarioService.inicial(scanner);
                    break;
                case 3:
                    unidadeTrabalhoService.inicial(scanner);
                    break;
                case 4:
                    relatorioService.inicial(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
		}
//		Antigua forma de criar um cargo agora tudo esta non CrudCargoService
//		Cargo cargo = new Cargo();
//		cargo.setDescription("Professor de HTML");
//		repository.save(cargo);
	}
}

package br.com.domon.spring.data.service;

import br.com.domon.spring.data.orm.Funcionario;
import br.com.domon.spring.data.orm.UnidadeTrabalho;
import br.com.domon.spring.data.repository.FuncionarioRepository;
import br.com.domon.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;
@Service
public class RelatorioService {

    private boolean system = true;

    private final FuncionarioRepository funcionarioRepository;

    public RelatorioService(FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual acao de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - Buscar pelo nombre");

            int action = scanner.nextInt();
            switch (action){
                case 1:
                    BuscaPeloNome(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }
    public void BuscaPeloNome(Scanner scanner){
        System.out.println("Dig. o nome");
        String nome = scanner.next();
        List<Funcionario> funcionarioList = funcionarioRepository.findByName(nome);
        funcionarioList.forEach(System.out::println);
    }
}

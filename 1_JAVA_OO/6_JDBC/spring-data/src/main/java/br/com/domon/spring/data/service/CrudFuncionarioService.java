package br.com.domon.spring.data.service;

import br.com.domon.spring.data.orm.Cargo;
import br.com.domon.spring.data.orm.Funcionario;
import br.com.domon.spring.data.orm.UnidadeTrabalho;
import br.com.domon.spring.data.repository.CargoRepository;
import br.com.domon.spring.data.repository.FuncionarioRepository;
import br.com.domon.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Service
public class CrudFuncionarioService {
    private boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final CargoRepository cargoRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final UnidadeTrabalhoRepository unidadeTrabalhoRepository;

    public CrudFuncionarioService(UnidadeTrabalhoRepository unidadeTrabalhoRepository,
                                      FuncionarioRepository funcionarioRepository,
                                      CargoRepository cargoRepository){
        this.unidadeTrabalhoRepository = unidadeTrabalhoRepository;
        this.cargoRepository = cargoRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner){
        while(system){
            System.out.println("Qual acao de cargo deseja executar");
            System.out.println("0 - Sair");
            System.out.println("1 - salvar");
            System.out.println("2 - Atualizar");
            System.out.println("3 - Visualizar");
            System.out.println("4 - Deletar");

            int action = scanner.nextInt();
            switch (action){
                case 1:
                    salvar(scanner);
                    break;
                case 2:
                    atualizar(scanner);
                    break;
                case 3:
                    visualizar();
                    break;
                case 4:
                    deletar(scanner);
                    break;
                default:
                    system = false;
                    break;
            }
        }
    }
    public void salvar(Scanner scanner){
        System.out.println("Dig. o nome");
        String nome = scanner.next();

        System.out.println("Dig. o CPF");
        String cpf = scanner.next();

        System.out.println("Dig. o salario");
        Double salario = scanner.nextDouble();

        System.out.println("Dig. a data de Contratacao");
        String dataContratacao = scanner.next();

        System.out.println("Dig. o cargoId");
        Integer cargoId = scanner.nextInt();

        List<UnidadeTrabalho> unidades = unidade(scanner);

        Funcionario funcionario = new Funcionario();
        funcionario.setName(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());
        funcionario.setUnidadeTrabalhos(unidades);

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }
    public void atualizar(Scanner scanner){
        System.out.println("Dig. o Id");
        Integer id = scanner.nextInt();

        System.out.println("Dig. o nome");
        String nome = scanner.next();

        System.out.println("Dig. o CPF");
        String cpf = scanner.next();

        System.out.println("Dig. o salario");
        Double salario = scanner.nextDouble();

        System.out.println("Dig. a data de Contratacao");
        String dataContratacao = scanner.next();

        System.out.println("Dig. o cargoId");
        Integer cargoId = scanner.nextInt();

        List<UnidadeTrabalho> unidades = unidade(scanner);

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setName(nome);
        funcionario.setCpf(cpf);
        funcionario.setSalario(salario);
        funcionario.setDataContratacao(LocalDate.parse(dataContratacao, formatter));
        Optional<Cargo> cargo = cargoRepository.findById(cargoId);
        funcionario.setCargo(cargo.get());
        funcionario.setUnidadeTrabalhos(unidades);

        funcionarioRepository.save(funcionario);
        System.out.println("Salvo");
    }
    private void visualizar(){
        Iterable<Funcionario> funcionarios = funcionarioRepository.findAll();
        funcionarios.forEach(funcionario -> System.out.println(funcionario));
    }
    public void deletar(Scanner scanner){
        visualizar();
        System.out.println("Dig o id do cargo");
        int id = scanner.nextInt();
        funcionarioRepository.deleteById(id);
    }
    private List<UnidadeTrabalho> unidade(Scanner scanner){
        Boolean isTrue = true;
        List<UnidadeTrabalho> unidades = new ArrayList<>();
        while(isTrue){
            System.out.println("Digite a unidadeID (Para sair dig. 0)");
            Integer unidadeId = scanner.nextInt();
            if(unidadeId != 0){
                Optional<UnidadeTrabalho> unidade = unidadeTrabalhoRepository.findById(unidadeId);
            }else{
                isTrue = false;
            }
        }
        return unidades;
    }
}

package br.com.domon.spring.data.service;

import br.com.domon.spring.data.orm.Cargo;
import br.com.domon.spring.data.orm.UnidadeTrabalho;
import br.com.domon.spring.data.repository.UnidadeTrabalhoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class CrudUnidadeTrabalhoService {

    private boolean system = true;

    private final UnidadeTrabalhoRepository unidadeTrabalhoRepositoryl;

    public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository unidadeTrabalhoRepository){
        this.unidadeTrabalhoRepositoryl = unidadeTrabalhoRepository;
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
        System.out.println("Description de cargo");
        String description = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setDescription(description);
        unidadeTrabalhoRepositoryl.save(unidadeTrabalho);
        System.out.println("Salvo");
    }
    public void atualizar(Scanner scanner){
        System.out.println("Dig ID");
        int id = scanner.nextInt();
        System.out.println("Descricao de cargo");
        String description = scanner.next();
        UnidadeTrabalho unidadeTrabalho = new UnidadeTrabalho();
        unidadeTrabalho.setId(id);
        unidadeTrabalho.setDescription(description);
        unidadeTrabalhoRepositoryl.save(unidadeTrabalho);
        System.out.println("Salvo");
    }
    private void visualizar(){
        Iterable<UnidadeTrabalho> unidadeTrabalhos = unidadeTrabalhoRepositoryl.findAll();
        unidadeTrabalhos.forEach(unidadeTrabalho -> System.out.println(unidadeTrabalho));
    }
    public void deletar(Scanner scanner){
        visualizar();
        System.out.println("Dig o id do cargo");
        int id = scanner.nextInt();
        unidadeTrabalhoRepositoryl.deleteById(id);
    }
}

package br.com.domon.spring.data.service;

import br.com.domon.spring.data.orm.Cargo;
import br.com.domon.spring.data.repository.CargoRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;
@Service
public class CrudCargoService {

    private boolean  system = true;
    private final CargoRepository cargoRepository;

    public CrudCargoService(CargoRepository cargoRepository){
        // ele esta vindo injetado na hora de criar o cargoRepository
        this.cargoRepository = cargoRepository;
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
        Cargo cargo = new Cargo();
        cargo.setDescription(description);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }
    public void atualizar(Scanner scanner){
        System.out.println("Dig ID");
        int id = scanner.nextInt();
        System.out.println("Descricao de cargo");
        String description = scanner.next();
        Cargo cargo = new Cargo();
        cargo.setId(id);
        cargo.setDescription(description);
        cargoRepository.save(cargo);
        System.out.println("Salvo");
    }
    private void visualizar(){
        Iterable<Cargo> cargos = cargoRepository.findAll();
        cargos.forEach(cargo -> System.out.println(cargo));
    }
    public void deletar(Scanner scanner){
        visualizar();
        System.out.println("Dig o id do cargo");
        int id = scanner.nextInt();
        cargoRepository.deleteById(id);
    }
}

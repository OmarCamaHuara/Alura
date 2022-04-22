package br.com.domon.spring.data.repository;

import br.com.domon.spring.data.orm.Funcionario;
import br.com.domon.spring.data.service.CrudFuncionarioService;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByName(String name);

    @Query("SELECT f FROM Funcionario f JOIN f.cargo c WHERE c.descricao = :descricao")
    List<Funcionario> findByCargoPelaDescricao(String descricao);
}

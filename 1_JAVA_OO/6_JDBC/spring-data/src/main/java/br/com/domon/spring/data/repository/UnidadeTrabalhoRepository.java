package br.com.domon.spring.data.repository;

import br.com.domon.spring.data.orm.UnidadeTrabalho;
import br.com.domon.spring.data.service.CrudUnidadeTrabalhoService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnidadeTrabalhoRepository extends CrudRepository<UnidadeTrabalho, Integer> {
}

package br.com.domon.spring.data.repository;

import br.com.domon.spring.data.orm.Cargo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
// para fazer o CRUD precisamos o objeto e o tipo do ID = ele tem ja metodos pronto para ser utilizados
public interface CargoRepository  extends CrudRepository<Cargo, Integer> {

}

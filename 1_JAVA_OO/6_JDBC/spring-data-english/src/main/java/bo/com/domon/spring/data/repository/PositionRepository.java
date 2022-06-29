package bo.com.domon.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bo.com.domon.spring.data.orm.Position;

@Repository
public interface PositionRepository extends CrudRepository<Position, Integer> {

}

package bo.com.domon.spring.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bo.com.domon.spring.data.orm.WorkUnit;

@Repository
public interface WorkUnitRepository extends CrudRepository<WorkUnit, Integer> {

}

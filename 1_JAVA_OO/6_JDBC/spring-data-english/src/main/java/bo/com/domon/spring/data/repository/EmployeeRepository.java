package bo.com.domon.spring.data.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import bo.com.domon.spring.data.orm.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
	
	List<Employee> findByName(String name);
	
	@Query("SELECT f FROM Employee f WHERE f.name = :name"
			+ "AND f.salary >= :salary AND f.contractDate = :date")
	List<Employee> findNameOfTheHighesSalaryByHireDate(String name, Double salary, LocalDate date);

	@Query(value = "SELECT * FROM Employee f WHERE f.contract_date >= :date", nativeQuery = true)
	List<Employee> findContractDateHigher(LocalDate date);
}

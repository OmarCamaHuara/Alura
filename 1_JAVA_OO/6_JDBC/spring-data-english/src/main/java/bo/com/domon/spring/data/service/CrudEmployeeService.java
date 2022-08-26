package bo.com.domon.spring.data.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.sun.xml.bind.util.Which;

import bo.com.domon.spring.data.orm.Employee;
import bo.com.domon.spring.data.orm.Position;
import bo.com.domon.spring.data.orm.WorkUnit;
import bo.com.domon.spring.data.repository.EmployeeRepository;
import bo.com.domon.spring.data.repository.PositionRepository;
import bo.com.domon.spring.data.repository.WorkUnitRepository;

@Service
public class CrudEmployeeService {
	
	private Boolean system = true;
	private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private final PositionRepository positionRepository;
	private final EmployeeRepository employeeRepository;
	private final WorkUnitRepository workUnitRepository;
	
	public CrudEmployeeService( EmployeeRepository employeeRepository,
								PositionRepository positionRepository,
								WorkUnitRepository workUnitRepository) {
		this.employeeRepository = employeeRepository;
		this.positionRepository = positionRepository;
		this.workUnitRepository = workUnitRepository;
	}
	
	public void initial(Scanner scanner) {
		while(system) {
			System.out.println("Which employee action do you want to perform");
			System.out.println("0 - Exit");
			System.out.println("1 - Save");
			System.out.println("2 - Update");
			System.out.println("3 - List");
			System.out.println("4 - Delete");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				save(scanner);
				break;
			case 2:
				update(scanner);
				break;
			case 3:
				list();
				break;
			case 4:
				delete(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void delete(Scanner scanner) {
		System.out.println("Type the ID");
		Integer id = scanner.nextInt();
		employeeRepository.deleteById(id);
		System.out.println("Deleted!!");
	}

	private void list() {
		Iterable<Employee> employees = employeeRepository.findAll();
		employees.forEach(employee -> System.out.println(employee));
	}

	private void update(Scanner scanner) {
		System.out.println("Type the ID");
		Integer id = scanner.nextInt();
		
		System.out.println("Type the name");
		String name = scanner.next();
		
		System.out.println("Type the CPF");
		String cpf = scanner.next();
		
		System.out.println("Type the salary");
		Double salary = scanner.nextDouble();
		
		System.out.println("Type the date og hire");
		String contractDate = scanner.next();
		
		System.out.println("Type positionId");
		Integer positionId = scanner.nextInt();	
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setCpf(cpf);
		employee.setSalary(salary);
		employee.setContractDate(LocalDate.parse(contractDate));
		Optional<Position> position = positionRepository.findById(positionId);
		employee.setPositionl(position.get());
		
		employeeRepository.save(employee);
		System.out.println("Updated!!");
	}

	private void save(Scanner scanner) {
		System.out.println("Type the name");
		String name = scanner.next();
		
		System.out.println("Type the CPF");
		String cpf = scanner.next();
		
		System.out.println("Type the salary");
		Double salary = scanner.nextDouble();
		
		System.out.println("Type the date og hire");
		String contractDate = scanner.next();
		
		System.out.println("Type positionId");
		Integer positionId = scanner.nextInt();	
		
		Employee employee = new Employee();
		employee.setName(name);
		employee.setCpf(cpf);
		employee.setSalary(salary);
		employee.setContractDate(LocalDate.parse(contractDate, formatter));
		
		Optional<Position> position = positionRepository.findById(positionId);
		employee.setPositionl(position.get());
		
		List<WorkUnit> units = unit(scanner);
		employee.setWorkUnit(units);
		
		employeeRepository.save(employee);
		System.out.println("Saved!!");
	}

	private List<WorkUnit> unit(Scanner scanner) {
		Boolean isTrue = true;
		List<WorkUnit> units = new ArrayList<>();
		
		while(isTrue) {
			System.out.println("Type the unitId - To exit type 0");
			Integer unitId = scanner.nextInt();
			
			if(unitId != 0) {
				Optional<WorkUnit> unit = workUnitRepository.findById(unitId);
				units.add(unit.get());
			}else {
				isTrue = false;
			}
		}
		return units;
	}
}

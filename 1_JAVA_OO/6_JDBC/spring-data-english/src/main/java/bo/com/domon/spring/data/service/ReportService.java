package bo.com.domon.spring.data.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import bo.com.domon.spring.data.orm.Employee;
import bo.com.domon.spring.data.repository.EmployeeRepository;

@Service
public class ReportService {
	
	private boolean system = true;
	
	private final EmployeeRepository employeeRepository;
	
	public ReportService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public void initial(Scanner scanner) {
		while (system) {
			System.out.println("Wich job do you want to perform");
			System.out.println("0 - Exit");
			System.out.println("1 - Serch by name");
			
			int action = scanner.nextInt();
			switch (action) {
				case 1:
					serchByName(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}
	
	public void serchByName(Scanner scanner) {
		System.out.println("Type the name");
		String name = scanner.next();
		List<Employee> listOfEmployee = employeeRepository.findByName(name);
		listOfEmployee.forEach(System.out::println);
	}
}

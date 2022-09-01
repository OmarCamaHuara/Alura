package bo.com.domon.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import bo.com.domon.spring.data.orm.WorkUnit;
import bo.com.domon.spring.data.repository.WorkUnitRepository;

@Service
public class CrudWorkUnitService {
	
	private boolean system = true;
	
	private final WorkUnitRepository workUnitRepository;
	
	public CrudWorkUnitService(WorkUnitRepository workUnitRepository) {
		this.workUnitRepository = workUnitRepository;
	}
	
	public void initial(Scanner scanner) {
		while(system) {
			System.out.println("Wich init of work action do you want to perform");
			System.out.println("0 - Exit");
			System.out.println("1 - Save");
			System.out.println("2 - Update");
			System.out.println("3 - View");
			System.out.println("4 - Delete");
			
			int action = scanner.nextInt();
			switch(action){
				case 1:
					saveWorkUnit(scanner);
					break;
				case 2:
					updateWorkUnit(scanner);
					break;
				case 3:
					ViewWorkUnits();
					break;
				case 4:
					deleteWorkUnit(scanner);
					break;
				default:
					system = false;
					break;
			}
		}
	}
	
	private void deleteWorkUnit(Scanner scanner) {
		ViewWorkUnits();
		System.out.println("Enter the job ID");
		int id = scanner.nextInt();
		workUnitRepository.deleteById(id);
	}

	private void ViewWorkUnits() {
		Iterable<WorkUnit> workUnits = workUnitRepository.findAll();
		workUnits.forEach(workUnit -> System.out.println(workUnit));
	}

	public void saveWorkUnit(Scanner read) {
		System.out.println("Enter de unit name");
		String description = read.next();
		WorkUnit workUnit = new WorkUnit();
		workUnit.setDescription(description);
		workUnitRepository.save(workUnit);
		System.out.println("Saved");
	}
	
	public void updateWorkUnit(Scanner read) {
		System.out.println("Enter ID");
		int id = read.nextInt();
		System.out.println("Unit description");
		String description = read.next();
		WorkUnit workUnit = new WorkUnit();
		workUnit.setId(id);
		workUnit.setDescription(description);
		workUnitRepository.save(workUnit);
		System.out.println("Saved");
	}

}

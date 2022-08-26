package bo.com.domon.spring.data.service;

import java.util.Optional;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import bo.com.domon.spring.data.orm.Position;
import bo.com.domon.spring.data.repository.PositionRepository;

@Service
public class CrudPositionService {

	private final PositionRepository positionRepository;
	private boolean system = true;
	
	public CrudPositionService(PositionRepository positionRepository) {
		this.positionRepository = positionRepository;
	}
	
	public void initial(Scanner scanner) {
		System.out.println("CRUD position");
		System.out.println("1 - New");
		System.out.println("2 - Update");
		System.out.println("3 - List");
		System.out.println("4 - Delete");
		
		int option = scanner.nextInt();
		
		switch (option) {
		case 1: 
			save(scanner);	
			break;
		
		case 2: 
			update(scanner);	
			break;
		case 3: 
			jobList();	
			break;
		case 4: 
			deleteJob(scanner);	
			break;
			
		default:
			system = false;
			break;
		}
	}
	
	private void save(Scanner read) {
		System.out.println("Job description");
		String description = read.next();
		Position position = new Position();
		position.setDescription(description);
		positionRepository.save(position);
		System.out.println("Saved");
	}
	
	private void update(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		System.out.println("New job description");
		String description = scanner.next();
		
		Position position = new Position();
		position.setId(id);
		position.setDescription(description);
		positionRepository.save(position);
		System.out.println("Updated...");
	}
	private void jobList() {
		System.out.println("Job list");
		Iterable<Position> positions = positionRepository.findAll();
		positions.forEach(position -> System.out.println(position.toString()));
	}
	private void deleteJob(Scanner scanner) {
		System.out.println("ID");
		int id = scanner.nextInt();
		positionRepository.deleteById(id);
		System.out.println("Deleted...");
	}
}

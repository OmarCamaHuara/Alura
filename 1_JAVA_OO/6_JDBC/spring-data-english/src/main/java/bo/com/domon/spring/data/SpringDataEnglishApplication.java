package bo.com.domon.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bo.com.domon.spring.data.orm.Position;
import bo.com.domon.spring.data.repository.PositionRepository;
import bo.com.domon.spring.data.service.CrudPositionService;

@SpringBootApplication
public class SpringDataEnglishApplication implements CommandLineRunner {
	
	private final CrudPositionService crudPositionService;
	
	private Boolean system = true;
	
	public SpringDataEnglishApplication(CrudPositionService crudPositionService) {
		this.crudPositionService = crudPositionService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataEnglishApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Scanner read = new Scanner(System.in);
		
		while(system) {
			
			System.out.println("What action do you want to perform");
			System.out.println("0 - Exit");
			System.out.println("1 - Position");
			
			int action = read.nextInt();
			
			switch (action) {
			case 0:
				return;
			
			case 1:
				crudPositionService.initial(read);
				break;
				
			default:
				break;
			}
		}
	}
}

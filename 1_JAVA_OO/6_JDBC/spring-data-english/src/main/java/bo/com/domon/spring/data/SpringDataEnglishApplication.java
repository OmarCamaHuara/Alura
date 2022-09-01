package bo.com.domon.spring.data;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import bo.com.domon.spring.data.service.CrudEmployeeService;
import bo.com.domon.spring.data.service.CrudPositionService;
import bo.com.domon.spring.data.service.CrudWorkUnitService;
import bo.com.domon.spring.data.service.ReportService;

@SpringBootApplication
public class SpringDataEnglishApplication implements CommandLineRunner {
	
	private final CrudPositionService crudPositionService;
	private final CrudEmployeeService crudEmployeeService;
	private final CrudWorkUnitService crudWorkUnitService;
	private final ReportService reportService;
	
	private Boolean system = true;
	
	public SpringDataEnglishApplication(CrudPositionService crudPositionService,
			CrudEmployeeService crudEmployeeService,
			CrudWorkUnitService crudWorkUnitService,
			ReportService reportService) {
		this.crudPositionService = crudPositionService;
		this.crudEmployeeService = crudEmployeeService;
		this.crudWorkUnitService = crudWorkUnitService;
		this.reportService = reportService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataEnglishApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		Scanner read = new Scanner(System.in);
		
		while(system) {
			
			System.out.println("What action do you want to do");
			System.out.println("0 - Exit");
			System.out.println("1 - Position");
			System.out.println("2 - Employee");
			System.out.println("3 - Work Unit");
			System.out.println("4 - Report");
			
			int action = read.nextInt();
			
			switch (action) {
			case 1:
				crudPositionService.initial(read);
				break;
			case 2:
				crudEmployeeService.initial(read);
				break;
			case 3:
				crudWorkUnitService.initial(read);
				break;
			case 4: 
				reportService.initial(read);
				break;
			default:
				system = false;
				break;
			}
		}
	}
}

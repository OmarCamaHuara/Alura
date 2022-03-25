package br.com.domar.mvc.edomar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EdomarApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdomarApplication.class, args);
		System.out.println("Hola domar");
	}

}

package com.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdata.service.CargoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private CargoService cargoService;
	
	private Boolean system = true;
	
	public SpringDataApplication(CargoService cargoService) {
		this.cargoService = cargoService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		while(system) {
			System.out.println("Qual acao você vai executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Cargo");
			
			int action = scanner.nextInt();
			if(action == 1) {
				cargoService.iniciar(scanner);
			} else {
				this.system = false;
			}
		}
	}

}

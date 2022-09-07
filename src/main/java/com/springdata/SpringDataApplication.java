package com.springdata;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdata.service.CargoService;
import com.springdata.service.FuncionarioService;
import com.springdata.service.RelatorioService;
import com.springdata.service.UnidadeTrabalhoService;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private Boolean system = true;

	private final CargoService cargoService;

	private final FuncionarioService funcionarioService;

	private final UnidadeTrabalhoService unidadeTrabalhoService;
	
	private final RelatorioService relatorioService;

	public SpringDataApplication(CargoService cargoService,
			FuncionarioService funcionarioService, 
			UnidadeTrabalhoService unidadeTrabalhoService,
			RelatorioService relatorioService
			) {
		this.cargoService = cargoService;
		this.funcionarioService = funcionarioService;
		this.unidadeTrabalhoService = unidadeTrabalhoService;
		this.relatorioService = relatorioService;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner scanner = new Scanner(System.in);

		while (system) {
			System.out.println("Qual função deseja executar?");
			System.out.println("0 - Sair");
			System.out.println("1 - Funcionario");
			System.out.println("2 - Cargo");
			System.out.println("3 - Unidade");
			System.out.println("4 - relatorio por nome");
			
			Integer function = scanner.nextInt();

			switch (function) {
				case 1:
					cargoService.iniciar(scanner);
					break;
				case 2:
					funcionarioService.inicial(scanner);
					break;
				case 3:
					unidadeTrabalhoService.inicial(scanner);
					break;
				case 4:
					relatorioService.inicial(scanner);
					break;
				default:
					System.out.println("Processo encerrado");
					system = false;
					break;
			}
		}
	}

}

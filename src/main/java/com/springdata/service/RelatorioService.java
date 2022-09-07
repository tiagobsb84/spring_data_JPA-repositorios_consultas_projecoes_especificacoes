package com.springdata.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.models.Funcionario;
import com.springdata.repository.FuncionarioRepository;

@Service
public class RelatorioService {

	private Boolean system = true;
	
	private final DateTimeFormatter  formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private FuncionarioRepository funcionarioRepository;
	
	public RelatorioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}
	
	public void inicial(Scanner scanner) {
		while(system) {
			System.out.println("Qual acao de cargo deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Consultar por funcionário por nome");
			System.out.println("2 - Consultar por funcionário por nome, salario e data");
			System.out.println("3 - Consultar por funcionário pela data de contratação");
			
			int action = scanner.nextInt();
			
			switch (action) {
			case 1:
				buscarFuncionarioNome(scanner);
				break;
			case 2:
				buscarNomeSalarioMaiorData(scanner);
				break;
			case 3:
				buscarDataContratacaoMaior(scanner);
				break;
			default:
				system = false;
				break;
			}
			
		}
		
	}
	
	public void buscarFuncionarioNome(Scanner scanner) {
		System.out.println("Qual o nome deseja pesquisar?");
		String nome = scanner.next();
		List<Funcionario> list = funcionarioRepository.findByNome(nome);
		list.forEach(System.out::println);
	}
	
	public void buscarNomeSalarioMaiorData(Scanner scanner) {
		System.out.println("Qual o nome deseja pesquisar?");
		String nome = scanner.next();
		
		System.out.println("Qual a data de contratação deseja pesquisar?");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		System.out.println("Qual salário que deseja pesquisar?");
		Double salario = scanner.nextDouble();
		
		List<Funcionario> list = funcionarioRepository.findNomeSalarioMaiorDataContratacao(nome, salario, localDate);
		list.forEach(System.out::println);
		
	}
	
	public void buscarDataContratacaoMaior(Scanner scanner) {
		System.out.println("Qual a data de contratação deseja pesquisar?");
		String data = scanner.next();
		LocalDate localDate = LocalDate.parse(data, formatter);
		
		List<Funcionario> list = funcionarioRepository.findDataContratacaoMaior(localDate);
		list.forEach(System.out::println);
	}
}

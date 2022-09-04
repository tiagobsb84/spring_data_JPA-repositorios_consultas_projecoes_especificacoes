package com.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.models.Cargo;
import com.springdata.repository.CargoRepository;

@Service
public class CargoService {
	
	private boolean system = true;

	private CargoRepository cargoRepository;
	
	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void iniciar(Scanner scanner) {
		while(system) {
			System.out.println("Qual açao deseja fazer?");
			System.out.println("0 - sair");
			System.out.println("1 - cadastra");
			System.out.println("2 - atualizar");
			System.out.println("3 - visualizar");
			System.out.println("4 - deletar");
			
			int acao = scanner.nextInt();
			
			switch (acao) {
			case 1: {
				this.salvar(scanner);
				break;
			} 
			case 2: {
				this.atualizar(scanner);
				break;
			}
			case 3: {
				this.visualizar();
				break;
			}
			case 4: {
				this.deletar(scanner);
				break;
			}
			default:
				 this.system = false;
				 break;
			}
		}
		
	}
	
	public void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo salvo!");
	}
	
	public void atualizar(Scanner scanner) {
		System.out.println("Digite id");
		int id = scanner.nextInt();
		
		System.out.println("Descrição do cargo");
		String descricao = scanner.next();
		
		Cargo cargo = new Cargo();
		cargo.setId(id);
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Atualizado com sucesso!");
	}
	
	public void visualizar() {
		Iterable<Cargo> cargos = cargoRepository.findAll();
		cargos.forEach(cargo -> System.out.println(cargo.toString()));
	}
	
	public void deletar(Scanner scanner) {
		System.out.println("Digite id");
		int id = scanner.nextInt();
		cargoRepository.deleteById(id);
		System.out.println("Deletado!");
	}
}
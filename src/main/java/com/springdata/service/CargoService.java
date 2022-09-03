package com.springdata.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.springdata.models.Cargo;
import com.springdata.repository.CargoRepository;

@Service
public class CargoService {

	private CargoRepository cargoRepository;
	
	public CargoService(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}
	
	public void iniciar(Scanner scanner) {
		this.salvar(scanner);
	}
	
	public void salvar(Scanner scanner) {
		System.out.println("Descricao do cargo");
		String descricao = scanner.next();
		Cargo cargo = new Cargo();
		cargo.setDescricao(descricao);
		cargoRepository.save(cargo);
		System.out.println("Cargo salvo!");
	}
}
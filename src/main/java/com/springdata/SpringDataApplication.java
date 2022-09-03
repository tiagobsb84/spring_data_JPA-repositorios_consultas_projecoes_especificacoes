package com.springdata;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springdata.models.Cargo;
import com.springdata.repository.CargoRepository;

@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {
	
	private CargoRepository cargoRepository;
	
	public SpringDataApplication(CargoRepository cargoRepository) {
		this.cargoRepository = cargoRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Cargo cargo = new Cargo();
		cargo.setDescricao("Desenvolvedor Software");
		cargoRepository.save(cargo);
	}

}

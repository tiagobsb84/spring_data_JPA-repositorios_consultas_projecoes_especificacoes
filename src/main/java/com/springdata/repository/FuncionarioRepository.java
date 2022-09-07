package com.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.springdata.models.Funcionario;

public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer> {

	List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f FROM Funcionario WHERE f.nome = :nome "
			+ "AND f.salario >= :salario, AND f.dataContracao = :data")
	List<Funcionario> findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);

	@Query(value = "SELECT * FROM funcionario f WHERE f.data_contracao >= :data", nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
}

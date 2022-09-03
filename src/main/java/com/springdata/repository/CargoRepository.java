package com.springdata.repository;

import org.springframework.data.repository.CrudRepository;

import com.springdata.models.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Integer> {

}

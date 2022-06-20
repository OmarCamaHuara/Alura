package br.com.alura.microservice.provider.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.microservice.provider.model.InfProvider;

@Repository
public interface InfRepository extends CrudRepository<InfProvider, Long> {

		InfProvider findByState(String state);
}

package br.com.alura.microservice.provider.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.microservice.provider.model.Solicitation;

public interface SolicitationRepository extends CrudRepository<Solicitation, Long> {

}

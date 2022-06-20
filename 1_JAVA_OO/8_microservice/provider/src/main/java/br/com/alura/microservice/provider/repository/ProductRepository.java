package br.com.alura.microservice.provider.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.alura.microservice.provider.model.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {

	public List<Product> findByIdIn(List<Long> ids);

	public List<Product> findByState(String state);

}

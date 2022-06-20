package br.com.alura.microservice.provider.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.model.InfProvider;
import br.com.alura.microservice.provider.repository.InfRepository;

@Service
public class InfService {

	@Autowired
	private InfRepository infRepository;
	
	public InfProvider getInfForState(String state) {
		return infRepository.findByState(state);
	}

}

package br.com.alura.microservice.provider.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.model.InfProvider;
import br.com.alura.microservice.provider.service.InfService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
	private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfService infService;
	
	@RequestMapping("/{state}")
	public InfProvider getInfForState(@PathVariable String state) {
		LOG.info("Recibido pedido de informacao do fornecedor de {}", state);
		return infService.getInfForState(state);
	}
}

package br.com.alura.microservice.provider.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.provider.dto.SolicitationItemDTO;
import br.com.alura.microservice.provider.model.Solicitation;
import br.com.alura.microservice.provider.service.SolicitationService;

@RestController
@RequestMapping("solicitation")
public class SolicitationController {
	
	private static final Logger LOG = LoggerFactory.getLogger(SolicitationController.class);
	
	@Autowired
	private SolicitationService solicitationService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Solicitation ordering(@RequestBody List<SolicitationItemDTO> product) {
		LOG.info("Pedido recevido");
		return solicitationService.ordering(product);
	}
	
	@RequestMapping("/{id}")
	public Solicitation getOrderForId(@PathVariable Long id) {
		return solicitationService.getSolicitationForId(id);
	}
	
}

package br.com.alura.microservice.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.microservice.store.dto.buyDTO;
import br.com.alura.microservice.store.model.Buy;
import br.com.alura.microservice.store.service.BuyService;

@RestController
@RequestMapping("/buy")
public class buyController {
	
	@Autowired
	private BuyService buyService;
	
	@RequestMapping(method = RequestMethod.POST)
	public Buy makePurchase(@RequestBody buyDTO buy) {
		return buyService.makePurchase(buy);
	}
}

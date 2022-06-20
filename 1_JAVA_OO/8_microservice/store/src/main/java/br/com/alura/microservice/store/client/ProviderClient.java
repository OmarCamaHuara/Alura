                                                                                                                                                                                                                                                                                                                                                                                                        package br.com.alura.microservice.store.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.alura.microservice.store.dto.InfSolicitationDTO;
import br.com.alura.microservice.store.dto.InfoProviderDTO;
import br.com.alura.microservice.store.dto.PurcharseItensDTO;

@FeignClient("provider")
public interface ProviderClient {
	
	@RequestMapping("/info/{state}")
	InfoProviderDTO getInfForState(@PathVariable String state);

	@RequestMapping(method = RequestMethod.POST, value = "/solicitation")
	InfSolicitationDTO placeSolicitation(List<PurcharseItensDTO> itens);

}

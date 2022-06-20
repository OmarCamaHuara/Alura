package br.com.alura.microservice.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import org.springframework.cloud.client.discovery.DiscoveryClient;

import br.com.alura.microservice.store.client.ProviderClient;
import br.com.alura.microservice.store.dto.InfSolicitationDTO;
import br.com.alura.microservice.store.dto.InfoProviderDTO;
import br.com.alura.microservice.store.dto.buyDTO;
import br.com.alura.microservice.store.model.Buy;

@Service
public class BuyService {
	
	private static final Logger LOG = LoggerFactory.getLogger(BuyService.class);

	@Autowired
	private ProviderClient providerClient;
	
	public Buy makePurchase(buyDTO buy) {
		
		final String state = buy.getAddress().getState();
		
		LOG.info("Buscanco informacao do fornecedor de {}", state);
		InfoProviderDTO info = providerClient.getInfForState(buy.getAddress().getState());
		
		LOG.info("Realizando pedido");
		InfSolicitationDTO solicitation = providerClient.placeSolicitation(buy.getItens());
		
		System.out.println(info.getAddress());
		
		Buy buySave = new Buy();
		
		buySave.setSolicitationId(solicitation.getId());
		buySave.setPreparationTime(solicitation.getPreparationTime());
		buySave.setDestinationAddress(buy.getAddress().toString());

		return buySave;
	}
	
}



/*
@Autowired
private RestTemplate client;

@Autowired
private DiscoveryClient eurekaClient;
*/




/*
 * makePurchase 
 * Os primeiros testes para comprecao das inyecoes DiscoveryClient e o RestTemplate
 * 
ResponseEntity<InfoProviderDTO> exchange = client.exchange("http://provider/info/"+buy.getAddress().getState(),
		HttpMethod.GET, null, InfoProviderDTO.class);


eurekaClient.getInstances("provider").stream()
.forEach(provider -> {
	System.out.println("localhost"+provider.getPort());
});
System.out.println(change.getBody().getAddress());

*/
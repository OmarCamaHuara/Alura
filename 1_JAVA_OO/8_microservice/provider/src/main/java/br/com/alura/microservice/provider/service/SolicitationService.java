package br.com.alura.microservice.provider.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alura.microservice.provider.dto.SolicitationItemDTO;
import br.com.alura.microservice.provider.model.Solicitation;
import br.com.alura.microservice.provider.model.SolicitationItem;
import br.com.alura.microservice.provider.model.Product;
import br.com.alura.microservice.provider.repository.SolicitationRepository;
import br.com.alura.microservice.provider.repository.ProductRepository;

@Service
public class SolicitationService {
	
	@Autowired
	private SolicitationRepository solicitationRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public Solicitation ordering(List<SolicitationItemDTO> itens) {
		if(itens == null) {
			return null;
		}
		
		List<SolicitationItem> solicitationItens = toSolicitationItem(itens);
		Solicitation solicitation = new Solicitation(solicitationItens);
		solicitation.setPreparationTime(itens.size());
		return solicitationRepository.save(solicitation);
	}

	public Solicitation getSolicitationForId(Long id) {
		return this.solicitationRepository.findById(id).orElse(new Solicitation());
	}
	
	private List<SolicitationItem> toSolicitationItem(List<SolicitationItemDTO> itens){
		
		List<Long> idsProducts = itens
				.stream()
				.map(item -> item.getId())
				.collect(Collectors.toList());
		
		List<Product> solicitationProducts = productRepository.findByIdIn(idsProducts);
		
		List<SolicitationItem> solicitationItens = itens
				.stream()
				.map(item -> {
					
					Product product = solicitationProducts
							.stream()
							.filter(p -> p.getId() == item.getId())
							.findFirst().get();
					
					SolicitationItem solicitationItem = new SolicitationItem();
					solicitationItem.setProduct(product);
					solicitationItem.setAmount(item.getAmount());
					return solicitationItem;
				})
				.collect(Collectors.toList());
		return solicitationItens;
	}
}

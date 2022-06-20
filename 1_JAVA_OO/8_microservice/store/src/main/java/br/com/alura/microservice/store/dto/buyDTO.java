package br.com.alura.microservice.store.dto;

import java.util.List;

public class buyDTO {
	
	private List<PurcharseItensDTO> itens;
	private AddressDTO address;
	
	public List<PurcharseItensDTO> getItens() {
		return itens;
	}
	public void setItens(List<PurcharseItensDTO> itens) {
		this.itens = itens;
	}
	public AddressDTO getAddress() {
		return address;
	}
	public void setAddress(AddressDTO address) {
		this.address = address;
	}
	
	

}

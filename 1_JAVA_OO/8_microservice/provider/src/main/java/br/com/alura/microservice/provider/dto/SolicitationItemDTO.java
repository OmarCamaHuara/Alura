package br.com.alura.microservice.provider.dto;

public class SolicitationItemDTO {
	
	private long id;
	private Integer amount;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
}

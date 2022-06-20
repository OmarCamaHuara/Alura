package br.com.alura.microservice.store.model;

public class Buy {
	
	private Long solicitationId;
	private Integer preparationTime;
	private String destinationAddress;
	
	public Long getSolicitationId() {
		return solicitationId;
	}
	public void setSolicitationId(Long solicitationId) {
		this.solicitationId = solicitationId;
	}
	public Integer getPreparationTime() {
		return preparationTime;
	}
	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}
	public String getDestinationAddress() {
		return destinationAddress;
	}
	public void setDestinationAddress(String destinationAddress) {
		this.destinationAddress = destinationAddress;
	}
	
	

}

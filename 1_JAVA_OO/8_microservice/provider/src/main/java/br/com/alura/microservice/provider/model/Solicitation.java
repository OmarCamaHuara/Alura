package br.com.alura.microservice.provider.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;


@Entity
public class Solicitation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Integer preparationTime;
	
	@Enumerated(EnumType.STRING)
	private SolicitationStatus status;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "solicitationId", nullable = false)
	private List<SolicitationItem> itens;
	
	public Solicitation(List<SolicitationItem> itens) {
		this.itens = itens;
		this.status = SolicitationStatus.RECEIVED;
	}
	
	public Solicitation() {
	}
	
	public List<SolicitationItem> getItens(){
		return itens;
	}

	public void setItens(List<SolicitationItem> itens) {
		this.itens = itens;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public SolicitationStatus getStatus() {
		return status;
	}
	
	public void setStatus(SolicitationStatus status) {
		this.status = status;
	}
	
	public Integer getPreparationTime() {
		return preparationTime;
	}
	
	public void setPreparationTime(Integer preparationTime) {
		this.preparationTime = preparationTime;
	}

}

package bo.com.domon.spring.data.orm;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	private String cpf;
	private Double salary;
	private LocalDate contractDate;
	@ManyToOne
	@JoinColumn(name = "position_id", nullable = false)
	private Position positionl;
	@Fetch(FetchMode.SELECT)
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "employee_units", joinColumns = {
			@JoinColumn(name = "fk_employee")},
	inverseJoinColumns = { @JoinColumn(name = "fk_unit")})
	private List<WorkUnit> workUnit;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public LocalDate getContractDate() {
		return contractDate;
	}

	public void setContractDate(LocalDate contractDate) {
		this.contractDate = contractDate;
	}

	public Position getPositionl() {
		return positionl;
	}

	public void setPositionl(Position positionl) {
		this.positionl = positionl;
	}

	public List<WorkUnit> getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(List<WorkUnit> workUnit) {
		this.workUnit = workUnit;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", cpf=" + cpf + ", salario=" + salary + ", contractDate="
				+ contractDate + ", positionl=" + positionl + ", workUnit=" + workUnit + "]";
	}
}

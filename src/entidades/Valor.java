package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="valores")
@NamedQueries({
	@NamedQuery(name="Todos.valor", query="SELECT v from Valor v ORDER BY v.id")
})
public class Valor {
	@Id
	private String id;
	@Column(length=100, nullable=false)
	private String descricao;
	@Column(columnDefinition="Decimal(10,2)")
	private double valor;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String toString() {
		return String.format("Id={%s}, descrição={%s}, valor={%f}", getId(), getDescricao(), getValor());
	}
}

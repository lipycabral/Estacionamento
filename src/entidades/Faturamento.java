package entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="faturamentos")
@NamedQueries({
	@NamedQuery(name="Faturamento.todos", query="SELECT f from Faturamento f ORDER BY f.id"),
	@NamedQuery(name="Faturamento.porData", query="SELECT f from Faturamento f WHERE f.date LIKE :date ORDER BY f.id")
})
public class Faturamento {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String date;
	@Column(nullable=false)
	private double faturamento;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getFaturamento() {
		return faturamento;
	}
	public void setFaturamento(double faturamento) {
		this.faturamento = faturamento;
	}
	public String toString() {
		return String.format("ID={%s}, DATA={%s}, FATURAMENTO={%.2f}", getId(), getDate(), getFaturamento());
	}
	
}

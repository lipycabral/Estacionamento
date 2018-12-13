package entidades;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="inadimplentes")
@NamedQueries({
	@NamedQuery(name="Todos.inadimplentes", query="SELECT i from Inadimplente i ORDER BY i.id")
})
public class Inadimplente {

	@Id
	@Column(length=11, nullable=false)
	private String cpf;
	@Column(length=50, nullable=false)
	private String nome;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String toString() {
		return String.format("CPF={%s}, NOME={%s}", getCpf(), getNome());
	}
}
